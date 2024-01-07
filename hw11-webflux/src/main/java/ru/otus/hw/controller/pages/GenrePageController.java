package ru.otus.hw.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@Controller
public class GenrePageController {

    @GetMapping(value = "/genres")
    public String listAllGenresPage() {
        return "genres";
    }
}
