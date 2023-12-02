package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
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
        return commentService.findCommentsByBookId(bookId).toString();
    }

    /**
     * Добавляет комментарий к книге.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     */
    @ShellMethod(value = "Insert comment", key = "cins")
    public void insertComment(String text, Long bookId) {
        commentService.saveComment(text, bookId);
    }

    /**
     * Обновляет комментарий к книге.
     *
     * @param id     идентификатор комментария
     * @param text   текст комментария
     * @param bookId идентификатор книги
     */
    @ShellMethod(value = "update comment", key = "cupd")
    public void updateComment(Long id, String text, Long bookId) {
        commentService.updateComment(id, text, bookId);
    }

    /**
     * Возвращает комментарий по идентификатору.
     *
     * @param id идентификатор
     * @return строковое представление комментария
     */
    @ShellMethod(value = "get comment by id", key = "cid")
    public String getCommentById(@ShellOption Long id) {
        return commentService.getCommentById(id).toString();
    }

    /**
     * Удаляет комментарий по идентификатору.
     *
     * @param id идентификатор
     */
    @ShellMethod(value = "delete comment by id", key = "cdel")
    public void deleteCommentById(@ShellOption Long id) {
        commentService.deleteCommentById(id);
    }


    /**
     * Удаляет все комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    @ShellMethod(value = "Delete comment by book id", key = "acdel")
    public void deleteAllComments(long bookId) {
        commentService.deleteByBookId(bookId);
    }

}
