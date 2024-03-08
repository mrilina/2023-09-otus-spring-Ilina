package ru.otus.hw.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw.bookstore.dto.AuthorDto;
import ru.otus.hw.bookstore.service.AuthorService;

import java.util.List;

/**
 * Контроллер для обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class AuthorController {

    /**
     * Сервис для обработки сведений об авторах.
     */
    private final AuthorService authorService;

    @GetMapping(value = "/api/authors")
    public List<AuthorDto> handleGetAll() {
        return authorService.getAll(Sort.by(Sort.Direction.ASC,"id"));
    }
}
