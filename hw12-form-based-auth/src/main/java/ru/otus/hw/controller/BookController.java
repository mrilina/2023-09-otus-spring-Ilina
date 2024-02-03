package ru.otus.hw.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.hw.dto.BookCreateDto;
import ru.otus.hw.dto.BookUpdateDto;
import ru.otus.hw.service.AuthorService;
import ru.otus.hw.service.BookService;
import ru.otus.hw.service.CommentService;
import ru.otus.hw.service.GenreService;

/**
 * Контроллер для обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@Controller
@RequiredArgsConstructor
public class BookController {

    /**
     * Сервиса обработки сведений о книгах.
     */
    private final BookService bookService;

    /**
     * Сервиса обработки сведений о комментариях.
     */
    private final CommentService commentService;

    /**
     * Сервиса обработки сведений об авторах.
     */
    private final AuthorService authorService;

    /**
     * Сервиса обработки сведений о жанрах.
     */
    private final GenreService genreService;

    @GetMapping("/books")
    public String listAllBooksPage(Model model) {
        var books = bookService.getAll(Sort.by(Sort.Direction.ASC, "id"));
        var authors = authorService.getAll(Sort.by(Sort.Direction.ASC, "id"));
        var genres = genreService.getAll(Sort.by(Sort.Direction.ASC, "id"));

        model.addAttribute("books", books);
        model.addAttribute("genres", genres);
        model.addAttribute("authors", authors);

        return "books";
    }

    @PostMapping("/create")
    public String handleCreate(@Valid BookCreateDto bookDto) {
        bookService.create(bookDto);

        return "redirect:/books";
    }

    @GetMapping("/edit")
    public String listEditPage(@RequestParam(value = "id") Long id, Model model) {
        var book = bookService.getById(id);
        var authors = authorService.getAll(Sort.by(Sort.Direction.ASC, "name"));
        var genres = genreService.getAll(Sort.by(Sort.Direction.ASC, "name"));
        var comments = commentService.getAllByBookId(id);

        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        model.addAttribute("comments", comments);

        return "edit";
    }

    @PostMapping("/update")
    public String handleUpdate(@Valid BookUpdateDto bookUpdateDto) {
        bookService.update(bookUpdateDto);

        return "redirect:/books";
    }

    @GetMapping("/booksByAuthor")
    public String listBooksByAuthorPage(@RequestParam(value = "id") long id, Model model) {
        var books = bookService.getAllByAuthorId(id);
        model.addAttribute("books", books);
        return "booksByAuthor";
    }

    @GetMapping("/booksByGenre")
    public String listBooksByGenrePage(@RequestParam(value = "id") long id, Model model) {
        var books = bookService.getAllByGenreId(id);
        model.addAttribute("books", books);
        return "booksByGenre";
    }

    @PostMapping("/delete")
    public String handleDeleteById(@RequestParam(value = "id") long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @PostMapping("/delete-all")
    public String handleDeleteAll() {
        bookService.deleteAll();
        return "redirect:/books";
    }
}
