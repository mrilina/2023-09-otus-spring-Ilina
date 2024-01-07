package ru.otus.hw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.mapper.AuthorMapper;
import ru.otus.hw.repository.AuthorRepository;

/**
 * Контроллер для обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class AuthorController {

    /**
     * Репозиторий обработки сведений об авторах.
     */
    private final AuthorRepository authorRepository;

    @GetMapping(value = "/api/authors")
    public Flux<AuthorDto> handleGetAll() {
        return authorRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .map(AuthorMapper::mapAuthorToDto);
    }
}
