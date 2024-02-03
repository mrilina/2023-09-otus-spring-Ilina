package ru.otus.hw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.otus.hw.service.AuthorService;

/**
 * Контроллер для обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@Controller
@RequiredArgsConstructor
public class AuthorController {

    /**
     * Сервис обработки сведений об авторах.
     */
    private final AuthorService authorService;

    @GetMapping("/authors")
    public String listAllAuthorsPage(Model model) {
        var authors = authorService.getAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("authors", authors);
        return "authors";
    }
}
