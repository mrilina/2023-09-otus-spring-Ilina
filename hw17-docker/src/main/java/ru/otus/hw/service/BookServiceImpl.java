package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dto.BookCreateDto;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.BookUpdateDto;
import ru.otus.hw.exception.DataNotFoundException;
import ru.otus.hw.mapper.BookMapper;
import ru.otus.hw.repository.AuthorRepository;
import ru.otus.hw.repository.BookRepository;
import ru.otus.hw.repository.GenreRepository;
import ru.otus.hw.service.BookService;
import ru.otus.hw.util.ErrorMessage;

import java.util.List;

import static java.lang.String.format;

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
     * Репозиторий обработки сведений о жанрах.
     */
    private final GenreRepository genreRepository;

    /**
     * Репозиторий обработки сведений об авторах.
     */
    private final AuthorRepository authorRepository;

    @Override
    public BookDto create(BookCreateDto bookCreateDto) {
        var genre = genreRepository.findById(bookCreateDto.getGenreId())
                .orElseThrow(() -> new DataNotFoundException(
                        String.format(ErrorMessage.GENRE_NOT_FOUND, bookCreateDto.getGenreId())
                ));

        var author = authorRepository.findById(bookCreateDto.getAuthorId())
                .orElseThrow(() -> new DataNotFoundException(
                        String.format(ErrorMessage.AUTHOR_NOT_FOUND, bookCreateDto.getAuthorId())
                ));

        var book = bookRepository.save(BookMapper.mapDtoToNewBook(bookCreateDto, genre, author));

        return BookMapper.mapBookToDto(book);
    }

    @Transactional
    @Override
    public BookDto update(BookUpdateDto bookUpdateDto) {
        var genre = genreRepository.findById(bookUpdateDto.getGenreId()).orElseThrow(() -> new DataNotFoundException(
                String.format(ErrorMessage.GENRE_NOT_FOUND, bookUpdateDto.getGenreId())
        ));

        var author = authorRepository.findById(bookUpdateDto.getAuthorId())
                .orElseThrow(() -> new DataNotFoundException(
                        String.format(ErrorMessage.AUTHOR_NOT_FOUND, bookUpdateDto.getAuthorId())
                ));

        var book = bookRepository.findById(bookUpdateDto.getId())
                .orElseThrow(() -> new DataNotFoundException(
                        String.format(ErrorMessage.BOOK_NOT_FOUND, bookUpdateDto.getId())
                ));

        book.setTitle(bookUpdateDto.getTitle());
        book.setGenre(genre);
        book.setAuthor(author);

        return BookMapper.mapBookToDto(book);
    }

    @Override
    public List<BookDto> getAll(Sort sort) {
        return bookRepository.findAll(sort)
                .stream()
                .map(BookMapper::mapBookToDto)
                .toList();
    }

    @Override
    public BookDto getById(long id) {
        return BookMapper.mapBookToDto(bookRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, id))));
    }

    @Override
    public List<BookDto> getAllByGenreId(long genreId) {
        var genre = genreRepository.findById(genreId).orElseThrow(() -> new DataNotFoundException(
                        String.format(ErrorMessage.GENRE_NOT_FOUND, genreId)));
        return bookRepository.findAllByGenreId(genre.getId())
                .stream()
                .map(BookMapper::mapBookToDto)
                .toList();
    }

    @Override
    public List<BookDto> getAllByAuthorId(long authorId) {
        var author = authorRepository.findById(authorId).orElseThrow(() ->
                        new DataNotFoundException(String.format(ErrorMessage.AUTHOR_NOT_FOUND, authorId)));
        return bookRepository.findAllByAuthorId(author.getId())
                .stream()
                .map(BookMapper::mapBookToDto)
                .toList();
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
