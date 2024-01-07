package ru.otus.hw.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@Controller
public class BookPageController {

    @GetMapping(value = "/books")
    public String listAllBooksPage() {
        return "books";
    }

    @GetMapping(value = "/booksByAuthor")
    public String listBooksByAuthorPage() {
        return "booksByAuthor";
    }

    @GetMapping(value = "/booksByGenre")
    public String listBooksByGenrePage() {
        return "booksByGenre";
    }

    @GetMapping(value = "/edit")
    public String listUpdateBookPage() {
        return "edit";
    }
}
