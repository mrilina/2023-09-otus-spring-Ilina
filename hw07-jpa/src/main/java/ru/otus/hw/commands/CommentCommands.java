package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.services.CommentService;

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
     * Возвращает все комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     * @return строковое представление комментариев
     */
    @ShellMethod(value = "Find all comments by book id", key = "ac")
    public String findAllCommentsByBookId(Long bookId) {
        return commentService.findCommentsByBookId(bookId);
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
        return commentService.insertComment(text, bookId);
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
