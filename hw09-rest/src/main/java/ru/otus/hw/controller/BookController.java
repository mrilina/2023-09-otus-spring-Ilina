package ru.otus.hw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.service.AuthorService;
import ru.otus.hw.service.BookService;
import ru.otus.hw.service.GenreService;

import java.util.List;

/**
 * Контроллер для обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    private final AuthorService authorService;

    private final GenreService genreService;

    @GetMapping("/book/list")
    public String bookList(Model model) {
        List<BookDto> books = bookService.getAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/book")
    public String bookEdit(@RequestParam("id") long id, Model model) {
        BookDto book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("genres", genreService.getAll());
        return "book/edit";
    }

    @GetMapping("/book/create")
    public String bookCreate(Model model) {
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("book", new BookDto());
        return "book/create";
    }

    @PostMapping("/book/{id}")
    public String bookDelete(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/book/list";
    }

    @PostMapping("/book")
    public String bookCreate(@ModelAttribute BookDto book) {
        bookService.saveBook(book.getName(), book.getAuthor(), book.getGenre());
        return "redirect:/book/list";
    }


    @PostMapping(value = "/book", params = {"id"})
    public String bookUpdate(@RequestParam long id, @ModelAttribute BookDto book) {
        book.setId(id);
        bookService.updateBook(book.getId(), book.getName(), book.getAuthor(), book.getGenre());
        return "redirect:/book/list";
    }
}
