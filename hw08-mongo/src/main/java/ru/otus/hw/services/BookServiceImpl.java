package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.mapper.BookMapper;
import ru.otus.hw.models.Author;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Genre;
import ru.otus.hw.repositories.BookRepository;

import java.util.List;

/**
 * Сервис обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    /**
     * Репозиторий обработки сведений о книгах.
     */
    private final BookRepository bookRepository;

    /**
     * Маппер сведений об книге.
     */
    private final BookMapper bookMapper;

    /**
     * Сервис обработки сведений об авторах.
     */
    private final AuthorService authorService;

    /**
     * Сервис обработки сведений о жанрах.
     */
    private final GenreService genreService;

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookMapper::toDto).toList();
    }

    @Override
    public BookDto findBookById(String id) {
        return bookMapper.toDto(bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id %d not found".formatted(id))));
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id %d not found".formatted(id)));
    }

    @Override
    public void insert(String name, String authorId, List<String> genresIds) {
        Author author = authorService.geAuthorById(authorId);
        List<Genre> genres = genreService.findAllByIds(genresIds);
        Book book = new Book(null, name, author, genres, null);
        bookRepository.save(book);
    }

    @Override
    public Book update(String id, String name, String authorId, List<String> genresIds) {
        Author author = authorService.geAuthorById(authorId);
        List<Genre> genres = genreService.findAllByIds(genresIds);
        Book book = new Book(id, name, author, genres, null);
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBookById(String id) {
        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        bookRepository.delete(book);
    }
}