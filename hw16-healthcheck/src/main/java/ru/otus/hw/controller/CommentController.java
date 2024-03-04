package ru.otus.hw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.service.CommentService;

import java.util.List;

/**
 * Контроллер для обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class CommentController {

    /**
     * Сервис обработки сведений о комментариях.
     */
    private final CommentService commentService;

    @GetMapping(value = "/api/books/{id}/comments")
    public List<CommentDto> findAllCommentsForSpecificBook(@PathVariable(value = "id") long id) {
        return commentService.getAllByBookId(id);
    }
}
