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
    CommentDto getCommentById(Long id);

    /**
     * Сохраняет сведения о комментарии.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     */
    void saveComment(String text, Long bookId);

    /**
     * Обновляет сведения о комментарии.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     */
    void updateComment(Long id, String text, Long bookId);

    /**
     * Удаляет сведения о комментарии по идентификатору.
     *
     * @param id идентификатор комментария
     */
    void deleteCommentById(Long id);

    /**
     * Возвращает комментарии по идентификатору книги.
     *
     * @param id идентификатор книги
     * @return список комментариев
     */
    List<CommentDto> findCommentsByBookId(Long id);

    /**
     * Удаляет комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    void deleteByBookId(long bookId);
}
