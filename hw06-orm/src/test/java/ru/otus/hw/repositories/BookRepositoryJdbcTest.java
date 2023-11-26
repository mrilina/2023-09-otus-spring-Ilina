package ru.otus.hw.repositories;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Genre;
import ru.otus.hw.models.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Юнит тесты для репозитория обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@DisplayName("Репозиторий на основе Jdbc для работы с книгами должен")
@DataJpaTest
@Import({BookRepositoryJpa.class, GenreRepositoryJpa.class})
class BookRepositoryJdbcTest {

    private static final int EXPECTED_NUMBER_OF_BOOKS = 3;
    private static final long FIRST_BOOK_ID = 1L;

    private static final String NEW_BOOK_TITLE = "Book_4";

    private static final long TEST_GENRE_ID = 1;

    private static final long TEST_AUTHOR_ID = 1;

    private static final long EXISTING_BOOK_ID = 1;

    private static final String UPDATED_BOOK_TITLE = "Book_4_updated";

    /**
     * Репозиторий обработки сведений о книгах.
     */
    @Autowired
    private BookRepositoryJpa repositoryJpa;

    @Autowired
    private TestEntityManager em;

    @DisplayName("загружать книгу по id")
    @Test
    void shouldReturnCorrectBookById() {
        val optionalActualBook = repositoryJpa.findById(FIRST_BOOK_ID);
        val expectedBook = em.find(Book.class, FIRST_BOOK_ID);
        assertThat(optionalActualBook).isPresent().get()
                .isEqualToComparingFieldByField(expectedBook);
    }


    @DisplayName("возвращать список всех книг")
    @Test
    void shouldFindAllBooks() {
        List<Book> books = repositoryJpa.findAll();
        assertThat(books).hasSize(EXPECTED_NUMBER_OF_BOOKS);
    }

    @DisplayName("удалять книгу по id")
    @Test
    void shouldDeleteEmployeesWithoutDepartment() {
        var existingBook = repositoryJpa.findById(1L);
        assertThat(existingBook).isNotEmpty();

        repositoryJpa.deleteById(1L);

        var deletedBook = repositoryJpa.findById(1L);
        assertThat(deletedBook).isEmpty();
    }

    @Test
    @DisplayName("добавлять книгу в БД")
    void shouldInsertBook() {
        var newBook = new Book();
        newBook.setTitle(NEW_BOOK_TITLE);
        var testGenre = em.find(Genre.class, TEST_GENRE_ID);
        newBook.setGenres(List.of(testGenre));
        var testAuthor = em.find(Author.class, TEST_AUTHOR_ID);
        newBook.setAuthor(testAuthor);

        var expectedBook = repositoryJpa.save(newBook);
        assertThat(expectedBook).isNotNull();
        assertThat(expectedBook.getId()).isGreaterThan(0);

        var actualBook = em.find(Book.class, expectedBook.getId());

        assertThat(actualBook)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(expectedBook);

        assertThat(actualBook)
                .matches(book -> book.getId() == 4)
                .matches(book -> book.getTitle().equals(NEW_BOOK_TITLE))
                .matches(book -> book.getGenres() != null
                        && book.getGenres().get(0).getId() == TEST_GENRE_ID)
                .matches(book -> book.getAuthor() != null
                        && book.getAuthor().getId() == TEST_AUTHOR_ID);
    }

    @Test
    @DisplayName("изменять имеющуюся в БД книгу")
    void shouldUpdateBook() {
        var book = em.find(Book.class, EXISTING_BOOK_ID);
        book.setTitle(UPDATED_BOOK_TITLE);
        em.flush();
        var updatedBook = em.find(Book.class, EXISTING_BOOK_ID);

        assertThat(updatedBook.getTitle()).isEqualTo(UPDATED_BOOK_TITLE);
    }
}