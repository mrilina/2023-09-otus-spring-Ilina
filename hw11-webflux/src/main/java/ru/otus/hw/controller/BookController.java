package ru.otus.hw.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.dto.BookCreateDto;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.BookUpdateDto;
import ru.otus.hw.exception.DataNotFoundException;
import ru.otus.hw.mapper.BookMapper;
import ru.otus.hw.repository.AuthorRepository;
import ru.otus.hw.repository.BookRepository;
import ru.otus.hw.repository.GenreRepository;
import ru.otus.hw.util.ErrorMessage;

import static java.lang.String.format;

/**
 * Контроллер для обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class BookController {

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

    @PostMapping(value = "/api/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BookDto> handleCreate(@Valid @RequestBody BookCreateDto bookDto) {
        return genreRepository.findById(bookDto.getGenreId())
                .switchIfEmpty(Mono.error(new DataNotFoundException(
                        format(ErrorMessage.GENRE_NOT_FOUND, bookDto.getGenreId())
                )))
                .zipWith(authorRepository.findById(bookDto.getAuthorId())
                        .switchIfEmpty(Mono.error(new DataNotFoundException(
                                format(ErrorMessage.AUTHOR_NOT_FOUND, bookDto.getAuthorId())
                        ))))
                .flatMap(tuple -> {
                    var genre = tuple.getT1();
                    var author = tuple.getT2();
                    var newBook = BookMapper.mapDtoToNewBook(bookDto, genre, author);
                    return bookRepository.save(newBook)
                            .map(BookMapper::mapBookToDto);
                });
    }

    @PutMapping(value = "/api/books/{id}")
    public Mono<BookDto> handleUpdate(@PathVariable(value = "id") String id,
                                      @Valid @RequestBody BookUpdateDto bookUpdateDto) {
        return genreRepository.findById(bookUpdateDto.getGenreId())
                .switchIfEmpty(Mono.error(new DataNotFoundException(
                        format(ErrorMessage.GENRE_NOT_FOUND, bookUpdateDto.getGenreId())
                )))
                .zipWith(authorRepository.findById(bookUpdateDto.getAuthorId())
                        .switchIfEmpty(Mono.error(new DataNotFoundException(
                                format(ErrorMessage.AUTHOR_NOT_FOUND, bookUpdateDto.getAuthorId())
                        ))))
                .flatMap(tuple -> bookRepository.findById(bookUpdateDto.getId())
                        .switchIfEmpty(Mono.error(new DataNotFoundException(
                                format(ErrorMessage.BOOK_NOT_FOUND, bookUpdateDto.getId())
                        )))
                        .flatMap(book -> {
                            var genre = tuple.getT1();
                            var author = tuple.getT2();
                            book.setTitle(bookUpdateDto.getTitle());
                            book.setGenre(genre);
                            book.setAuthor(author);
                            return bookRepository.save(book)
                                    .map(BookMapper::mapBookToDto);
                        }));
    }

    @GetMapping(value = "/api/books")
    public Flux<BookDto> handleGetAll() {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .map(BookMapper::mapBookToDto);
    }

    @GetMapping(value = "/api/books/{id}")
    public Mono<BookDto> handleGetById(@PathVariable(value = "id") String id) {
        return bookRepository.findById(id)
                .switchIfEmpty(Mono.error(new DataNotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, id))))
                .map(BookMapper::mapBookToDto);
    }

    @GetMapping(value = "/api/books", params = "authorId")
    public Flux<BookDto> handleGetAllByAuthorId(@RequestParam(value = "authorId") String authorId) {
        return authorRepository.findById(authorId)
                .switchIfEmpty(Mono.error(new DataNotFoundException(
                        format(ErrorMessage.AUTHOR_NOT_FOUND, authorId))))
                .flatMapMany(author -> bookRepository.findAllByAuthorId(author.getId())
                        .map(BookMapper::mapBookToDto));
    }

    @GetMapping(value = "/api/books", params = "genreId")
    public Flux<BookDto> handleGetAllByGenreId(@RequestParam(value = "genreId") String genreId) {
        return genreRepository.findById(genreId)
                .switchIfEmpty(Mono.error(new DataNotFoundException(
                        format(ErrorMessage.GENRE_NOT_FOUND, genreId))))
                .flatMapMany(genre -> bookRepository.findAllByGenreId(genre.getId())
                        .map(BookMapper::mapBookToDto));
    }

    @DeleteMapping(value = "/api/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> handleDelete(@PathVariable(value = "id") String id) {
        return bookRepository.deleteById(id);
    }

    @DeleteMapping(value = "/api/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> handleDeleteAll() {
        return bookRepository.deleteAll();
    }
}



