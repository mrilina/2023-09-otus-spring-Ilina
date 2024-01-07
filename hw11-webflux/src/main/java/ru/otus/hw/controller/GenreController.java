package ru.otus.hw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.hw.dto.GenreDto;
import ru.otus.hw.mapper.GenreMapper;
import ru.otus.hw.repository.GenreRepository;

/**
 * Контроллер для обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class GenreController {

    /**
     * Репозиторий обработки сведений о жанрах.
     */
    private final GenreRepository genreRepository;

    @GetMapping(value = "/api/genres")
    public Flux<GenreDto> handleGetAll() {
        return genreRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .map(GenreMapper::mapGenreToDto);
    }
}
