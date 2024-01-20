package ru.otus.hw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.hw.service.GenreService;

/**
 * Контроллер для обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@Controller
@RequiredArgsConstructor
public class GenreController {

    /**
     * Сервис обработки сведений о жанрах.
     */
    private final GenreService genreService;

    @GetMapping("/genres")
    public String listAllGenresPage(Model model) {
        var genres = genreService.getAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("genres", genres);
        return "genres";
    }
}
