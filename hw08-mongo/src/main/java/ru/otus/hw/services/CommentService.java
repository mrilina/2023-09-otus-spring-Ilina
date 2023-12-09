package ru.otus.hw.services;

import ru.otus.hw.dto.CommentDto;

import java.util.List;

/**
 * Интерфейс сервиса обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentService {

    /**
     * Возвращает сведения о комментарии.
     *
     * @param id идентификатор комментария
     * @return сведения о комментарии
     */
    CommentDto getCommentById(String id);

    /**
     * Сохраняет сведения о комментарии.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     */
    void saveComment(String text, String bookId);

    /**
     * Обновляет сведения о комментарии.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     */
    void updateComment(String id, String text, String bookId);

    /**
     * Удаляет сведения о комментарии по идентификатору.
     *
     * @param id идентификатор комментария
     */
    void deleteCommentById(String id);

    /**
     * Возвращает комментарии по идентификатору книги.
     *
     * @param id идентификатор книги
     * @return список комментариев
     */
    List<CommentDto> findCommentsByBookId(String id);

    /**
     * Удаляет комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    void deleteByBookId(String bookId);
}
