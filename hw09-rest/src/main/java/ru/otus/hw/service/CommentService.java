package ru.otus.hw.service;

import ru.otus.hw.domain.Comment;
import ru.otus.hw.dto.CommentDto;

import java.util.List;

/**
 * Интерфейс сервиса обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentService {

    /**
     * Возвращает комментарий по идентификатору.
     *
     * @param id идентификатор
     * @return комментарий
     */
    CommentDto getCommentById(Long id);

    /**
     * Сохраняет сведения о комментарии.
     *
     * @param comment комментарий
     */
    void saveComment(Comment comment);

    /**
     * Обновляет сведения о комментарии.
     *
     * @param comment комментарий
     */
    void updateComment(Comment comment);

    /**
     * Удаляет комментарии по идентификатору книги.
     *
     * @param id идентификатор книги
     */
    void deleteCommentById(Long id);

    /**
     * Возвращает списрок комментариев по идентификатору книги.
     *
     * @param id идентификатор книги
     * @return список комментариев
     */
    List<CommentDto> getByBookId(Long id);
}
