package ru.otus.hw.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.hw.models.Author;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Репозиторий обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@Repository
@RequiredArgsConstructor
public class BookRepositoryJdbc implements BookRepository {

    /**
     * Шаблонный класс с базовым набором операций JDBC.
     */
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    /**
     * Репозиторий обработки сведений о жанрах.
     */
    private final GenreRepository genreRepository;

    @Override
    public Optional<Book> findById(long id) {
        var genres = genreRepository.findAll();
        var relations = getGenreRelationsBookId(id);

        Map<String, Object> params = Collections.singletonMap("id", id);
        Book book;
        try {
            book = namedParameterJdbcOperations.queryForObject(
                    "select b.id, b.title, b.author_id, a.full_name " +
                            "from books b " +
                            "left join authors a on a.id = b.author_id " +
                            "where b.id = :id", params,
                    new BookRowMapper());

            mergeBooksInfo(List.of(book), genres, relations);
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }

        return Optional.ofNullable(book);
    }

    @Override
    public List<Book> findAll() {
        var genres = genreRepository.findAll();
        var relations = getAllGenreRelations();
        var books = getAllBooksWithoutGenres();
        mergeBooksInfo(books, genres, relations);
        return books;
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == 0) {
            return insert(book);
        }
        return update(book);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update("delete from books where id = :id", params);
    }

    /**
     * Возвращает список сведений о книгах без сведений о жанрах.
     *
     * @return список сведений о книгах
     */
    private List<Book> getAllBooksWithoutGenres() {
        List<Book> books = namedParameterJdbcOperations.query(
                "select b.id, b.title, b.author_id, a.full_name " +
                        "from books b " +
                        "left join authors a on a.id = b.author_id",
                new BookResultSetExtractor());

        return books;
    }

    /**
     * Возвращает список связей между книгами и жанрами.
     *
     * @return список связей
     */
    private List<BookGenreRelation> getAllGenreRelations() {
        return namedParameterJdbcOperations.query(
                "select book_id, genre_id " +
                        "from books_genres " +
                        "order by book_id, genre_id",
                (rs, i) -> new BookGenreRelation(rs.getLong(1), rs.getLong(2)));
    }

    /**
     * Возвращает список связей между книгами и жанрами по идентификатору книги.
     *
     * @param bookId идентификатор книги
     * @return список связей
     */
    private List<BookGenreRelation> getGenreRelationsBookId(long bookId) {
        Map<String, Object> params = Collections.singletonMap("id", bookId);
        return namedParameterJdbcOperations.query(
                "select book_id, genre_id " +
                        "from books_genres " +
                        "where book_id = :id " +
                        "order by book_id, genre_id",
                params,
                (rs, i) -> new BookGenreRelation(rs.getLong(1), rs.getLong(2)));
    }

    /**
     * Дополняет сведения о книге сведениями о жанрах.
     *
     * @param booksWithoutGenres список сведений о книгах без сведений о жанрах
     * @param genres             список сведений о жанрах
     * @param relations          список связей книг и жанров
     */
    private void mergeBooksInfo(List<Book> booksWithoutGenres, List<Genre> genres,
                                List<BookGenreRelation> relations) {
        relations.forEach(r -> {
            Book book = findBook(booksWithoutGenres, r.bookId());
            Genre genre = findGenre(genres, r.genreId());
            if (book != null && genre != null) {
                book.getGenres().add(genre);
            }
        });
    }

    /**
     * Осуществляет поиск книги по ее идентификатору.
     *
     * @param bookList список сведений о книг
     * @param bookId   идентификатор книги
     * @return сведения о книге
     */
    private Book findBook(final List<Book> bookList, final long bookId) {
        return bookList.stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Осуществляет поиск жанра по его идентификатору.
     *
     * @param genreList список жанров
     * @param genreId   идентификатор жанра
     * @return сведения о жанре
     */
    private Genre findGenre(final List<Genre> genreList, final long genreId) {
        return genreList.stream()
                .filter(g -> g.getId() == genreId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Сохраняет сведения о книге.
     *
     * @param book сведения о книге
     * @return сведения о книге
     */
    private Book insert(Book book) {
        var keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource(
                Map.of("title", book.getTitle(), "author_id", book.getAuthor().getId())
        );
        namedParameterJdbcOperations.update("insert into books(title, author_id) values (:title, :author_id)",
                sqlParameterSource,
                keyHolder
        );

        book.setId(keyHolder.getKeyAs(Long.class));
        batchInsertGenresRelationsFor(book);
        return book;
    }

    /**
     * Обновляет сведения о книге.
     *
     * @param book сведения о книге
     * @return сведения о книге
     */
    private Book update(Book book) {
        namedParameterJdbcOperations.update("update books set title = :title, author_id = :author_id where id = :id",
                Map.of("title", book.getTitle(), "author_id", book.getAuthor().getId(), "id", book.getId())
        );
        removeGenresRelationsFor(book);
        batchInsertGenresRelationsFor(book);

        return book;
    }

    /**
     * Проставляет связи между книгой и жанрами.
     *
     * @param book сведения о книге
     */
    private void batchInsertGenresRelationsFor(Book book) {
        for (Genre genre : book.getGenres()) {
            namedParameterJdbcOperations.update("insert into books_genres(book_id, genre_id) " +
                            "values (:book_id, :genre_id)",
                    Map.of("book_id", book.getId(), "genre_id", genre.getId()));
        }
    }

    /**
     * Удаляет связи между книгой и жанрами.
     *
     * @param book сведения о книге
     */
    private void removeGenresRelationsFor(Book book) {
        Map<String, Object> params = Collections.singletonMap("id", book.getId());
        namedParameterJdbcOperations.update("delete from books_genres where book_id = :id", params);
    }

    /**
     * Класс для отображения строк ResultSet для каждой строки сведений о книге.
     *
     * @author Irina Ilina
     */
    private static class BookRowMapper implements RowMapper<Book> {

        /**
         * Возвращает сведения о книге из ResultSet.
         *
         * @param rs     результирующий набор данных
         * @param rowNum индекс
         * @return сведения об авторе
         * @throws SQLException исключительная ситуация
         */
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long bookId = rs.getLong("id");
            String bookTitle = rs.getString("title");
            long authorId = rs.getLong("author_id");
            String authorFullName = rs.getString("full_name");

            return new Book(bookId, bookTitle, new Author(authorId, authorFullName), new ArrayList<>());
        }
    }

    /**
     * Класс для отображения списка строк ResultSet для каждой строки сведений о книге из списка.
     *
     * @author Irina Ilina
     */
    @SuppressWarnings("ClassCanBeRecord")
    @RequiredArgsConstructor
    private static class BookResultSetExtractor implements ResultSetExtractor<List<Book>> {

        @Override
        public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                Book book = new Book(id, rs.getString("title"),
                        new Author(rs.getLong("author_id"), rs.getString("full_name")),
                        new ArrayList<>());
                books.add(book);
            }
            return books;
        }
    }

    /**
     * Связь между книгой и жанром.
     *
     * @param bookId  идентификатор книги
     * @param genreId идентификатор жанра
     */
    private record BookGenreRelation(long bookId, long genreId) {
    }
}
