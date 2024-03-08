package ru.otus.hw.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw.client.feign.BookServiceClient;
import ru.otus.hw.client.dto.BookDto;

import java.util.List;

/**
 * Контроллер для обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookServiceClient bookServiceClient;

    @GetMapping(value = "/api/books")
    public List<BookDto> handleGetAll() {
        return bookServiceClient.getAll(Sort.by(Sort.Direction.ASC,"id"));
    }
}

