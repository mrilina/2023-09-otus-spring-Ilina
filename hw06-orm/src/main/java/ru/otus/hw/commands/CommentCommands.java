package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.converters.CommentConverter;
import ru.otus.hw.services.CommentService;

import java.util.stream.Collectors;

/**
 * Команды для обработки сведений о комментарии.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@ShellComponent
public class CommentCommands {

    /**
     * Сервис обработки сведений о комментариях.
     */
    private final CommentService commentService;

    /**
     * Конвертер сведений о комментариях.
     */
    private final CommentConverter commentConverter;

    /**
     * Возвращает все комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     * @return строковое представление комментариев
     */
    @ShellMethod(value = "Find all comments by book id", key = "ac")
    public String findAllCommentsByBookId(Long bookId) {
        return commentService.findAllByBookId(bookId).stream()
                .map(commentConverter::commentToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }

    /**
     * Добавляет комментарий к книге.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     * @return строковое представление комментария
     */
    @ShellMethod(value = "Insert comment", key = "cins")
    public String insertComment(String text, long bookId) {
        var savedComment = commentService.insert(text, bookId);
        return commentConverter.commentToString(savedComment);
    }

    /**
     * Удаляет все комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    @ShellMethod(value = "Delete comment by book id", key = "cdel")
    public void deleteAllComments(long bookId) {
        commentService.deleteByBookId(bookId);
    }
}
