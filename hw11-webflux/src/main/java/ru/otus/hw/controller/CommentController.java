package ru.otus.hw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.exception.DataNotFoundException;
import ru.otus.hw.mapper.CommentMapper;
import ru.otus.hw.repository.BookRepository;
import ru.otus.hw.repository.CommentRepository;
import ru.otus.hw.util.ErrorMessage;

import static java.lang.String.format;

/**
 * Контроллер для обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
public class CommentController {

    /**
     * Репозиторий обработки сведений о книгах.
     */
    private final BookRepository bookRepository;

    /**
     * Репозиторий обработки сведений о комментариях.
     */
    private final CommentRepository commentRepository;

    @GetMapping(value = "/api/books/{id}/comments")
    public Flux<CommentDto> handleGetAllByBookId(@PathVariable(value = "id") String id) {
        return bookRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new DataNotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, id))))
                .flatMapMany(book -> commentRepository.findAllByBook(book)
                        .map(CommentMapper::mapCommentToDto));
    }
}
