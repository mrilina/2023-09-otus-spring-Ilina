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
     * Возвращает комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     * @return список комментариев
     */
    List<CommentDto> findAllByBookId(Long bookId);


    /**
     * Возвращает строковое представление комментариев по идентификатору книги.
     *
     * @param bookId идентификатор книги
     * @return строковое представление комментариев
     */
    String findCommentsByBookId(Long bookId);

    /**
     * Сохраняет сведения о комментарии.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     * @return сведения о комментарии
     */
    CommentDto insert(String text, Long bookId);

    /**
     * Возвращает строковое представление о сохраненном комментарии.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     * @return строковое представление
     */
    String insertComment(String text, Long bookId);

    /**
     * Удаляет комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    void deleteByBookId(long bookId);
}
