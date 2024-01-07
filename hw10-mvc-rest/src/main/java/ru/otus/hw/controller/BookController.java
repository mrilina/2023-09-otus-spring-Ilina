package ru.otus.hw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.BookUpdateDto;
import ru.otus.hw.service.BookService;

import java.util.List;

/**
 * Контроллер для обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class BookController {

    /**
     * Сервис обработки сведений о книгах.
     */
    private final BookService bookService;

    @PostMapping(value = "/api/books")
    public BookDto handleCreate(@RequestBody BookUpdateDto book) {
        return bookService.create(book);
    }

    @PutMapping(value = "/api/books/{id}")
    public BookDto handleUpdate(@PathVariable(value = "id") long id, @RequestBody BookUpdateDto book) {
        return bookService.update(book);
    }

    @GetMapping(value = "/api/books")
    public List<BookDto> handleGetAll() {
        return bookService.getAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping(value = "/api/books", params = "authorId")
    public List<BookDto> handleGetAllByAuthorId(@RequestParam(value = "authorId") Long authorId) {
        return bookService.getAllByAuthorId(authorId);
    }

    @GetMapping(value = "/api/books", params = "genreId")
    public List<BookDto> handleGetAllByGenreId(@RequestParam(value = "genreId") Long genreId) {
        return bookService.getAllByGenreId(genreId);
    }

    @GetMapping(value = "/api/books/{id}")
    public BookDto handleGetById(@PathVariable(value = "id") long id) {
        return bookService.getById(id);
    }

    @DeleteMapping(value = "/api/books/{id}")
    public void handleDelete(@PathVariable(value = "id") long id) {
        bookService.deleteById(id);
    }

    @DeleteMapping(value = "/api/books")
    public void handleDeleteAll() {
        bookService.deleteAll();
    }
}

