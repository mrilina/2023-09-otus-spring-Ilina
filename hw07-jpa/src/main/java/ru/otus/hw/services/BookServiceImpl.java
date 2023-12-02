package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public BookDto findBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id %d not found".formatted(id))));
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id %d not found".formatted(id)));
    }

    @Transactional
    @Override
    public void insert(String name, Long authorId, List<Long> genresIds) {
        Author author = authorService.geAuthorById(authorId);
        List<Genre> genres = genreService.findAllByIds(genresIds);
        Book book = new Book(null, name, author, genres, null);
        bookRepository.save(book);
    }

    @Transactional
    @Override
    public Book update(Long id, String name, Long authorId, List<Long> genresIds) {
        Author author = authorService.geAuthorById(authorId);
        List<Genre> genres = genreService.findAllByIds(genresIds);
        Book book = new Book(id, name, author, genres, null);
        bookRepository.save(book);
        return book;
    }

    @Transactional
    @Override
    public void deleteBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        bookRepository.delete(book);
    }
}