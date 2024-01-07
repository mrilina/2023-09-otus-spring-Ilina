package ru.otus.hw.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@Controller
public class AuthorPageController {

    @GetMapping(value = "/authors")
    public String listAllAuthorsPage() {
        return "authors";
    }
}
