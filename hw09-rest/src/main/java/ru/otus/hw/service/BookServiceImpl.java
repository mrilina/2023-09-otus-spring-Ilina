package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.domain.Author;
import ru.otus.hw.domain.Book;
import ru.otus.hw.domain.Genre;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.exception.DataNotFoundException;
import ru.otus.hw.mapper.BookMapper;
import ru.otus.hw.repository.BookRepository;

import java.util.List;
import java.util.stream.StreamSupport;

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
    public List<BookDto> getAll() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .map(bookMapper::map).toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookMapper.map(bookRepository.findById(id).orElseThrow(DataNotFoundException::new));
    }

    @Override
    public BookDto saveBook(String name, String authorN, String genreN) {
        Author author = authorService.getAuthorByName(authorN);
        Genre genre = genreService.getGenreByName(genreN);
        Book book = new Book(null, name, author, genre, null);
        return bookMapper.map(bookRepository.save(book));
    }

    @Override
    public BookDto updateBook(Long id, String name, String authorN, String genreN) {
        Author author = authorService.getAuthorByName(authorN);
        Genre genre = genreService.getGenreByName(genreN);
        Book book = new Book(id, name, author, genre, null);
        return bookMapper.map(bookRepository.save(book));
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(DataNotFoundException::new);
        bookRepository.delete(book);
    }

}
