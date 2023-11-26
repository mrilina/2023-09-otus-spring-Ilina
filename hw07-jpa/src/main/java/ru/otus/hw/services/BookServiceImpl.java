package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.models.Book;
import ru.otus.hw.repositories.AuthorRepository;
import ru.otus.hw.repositories.BookRepository;
import ru.otus.hw.repositories.GenreRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    @Override
    public Book insert(String title, long authorId, List<Long> genresIds) {
        var author = authorRepository.findById(authorId).orElseThrow(
                () -> new EntityNotFoundException("Author with id %d not found".
                        formatted(authorId)
                ));
        var genres = genreRepository.findAllById(new HashSet<>(genresIds));
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenres(genres);
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public Book update(long id, String title, long authorId, List<Long> genresIds) {
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
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }
}
