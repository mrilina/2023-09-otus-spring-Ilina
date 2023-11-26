package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.mapper.BookMapper;
import ru.otus.hw.models.Book;
import ru.otus.hw.repositories.AuthorRepository;
import ru.otus.hw.repositories.BookRepository;
import ru.otus.hw.repositories.GenreRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Сервис обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    /**
     * Репозиторий обработки сведений о книгах.
     */
    private final BookRepository bookRepository;

    /**
     * Репозиторий обработки сведений об авторах.
     */
    private final AuthorRepository authorRepository;

    /**
     * Репозиторий обработки сведений о жанрах.
     */
    private final GenreRepository genreRepository;

    /**
     * Маппер сведений о книге.
     */
    private final BookMapper bookMapper;

    /**
     * Сервис преобразования сведений о модели в строковое представление.
     */
    private final ConvertService convertService;

    @Transactional
    @Override
    public BookDto findById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return bookMapper.toDto(book.get());
    }

    @Transactional
    @Override
    public String getById(long id) {
        BookDto bookDto = findById(id);
        if (bookDto != null) {
            return convertService.bookToString(bookDto);
        }
        return "Book with id %d not found".formatted(id);
    }

    @Transactional
    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public String getAll() {
        return findAll().stream()
                .map(convertService::bookToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }

    @Transactional
    @Override
    public String insertBook(String title, long authorId, List<Long> genresIds) {
        var savedBook = insert(title, authorId, genresIds);
        return convertService.bookToString(savedBook);
    }

    @Transactional
    @Override
    public BookDto insert(String title, long authorId, List<Long> genresIds) {
        var author = authorRepository.findById(authorId).orElseThrow(
                () -> new EntityNotFoundException("Author with id %d not found".
                        formatted(authorId)
                ));
        var genres = genreRepository.findAllById(new HashSet<>(genresIds));
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenres(genres);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Transactional
    @Override
    public String updateBook(long id, String title, long authorId, List<Long> genresIds) {
        var savedBook = update(id, title, authorId, genresIds);
        return convertService.bookToString(savedBook);
    }

    @Transactional
    @Override
    public BookDto update(long id, String title, long authorId, List<Long> genresIds) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id %d not found".formatted(id)));

        var author = authorRepository.findById(authorId).orElseThrow(
                () -> new EntityNotFoundException("Author with id %d not found".
                        formatted(authorId)
                ));
        var genres = genreRepository.findAllById(new HashSet<>(genresIds));

        book.setTitle(title);
        book.setAuthor(author);
        book.setGenres(genres);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }
}
