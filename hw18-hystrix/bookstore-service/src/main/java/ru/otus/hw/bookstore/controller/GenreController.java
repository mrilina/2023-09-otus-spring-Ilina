package ru.otus.hw.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw.bookstore.dto.GenreDto;
import ru.otus.hw.bookstore.service.GenreService;

import java.util.List;

/**
 * Контроллер для обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class GenreController {

    /**
     * Сервис обработки сведений о жанрах.
     */
    private final GenreService genreService;

    @GetMapping(value = "/api/genres")
    public List<GenreDto> handleGetAllGenres() {
        return genreService.getAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
