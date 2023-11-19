package ru.otus.hw.services;

import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.models.Comment;

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
     * Сохраняет сведения о комментарии.
     *
     * @param text   текст комментария
     * @param bookId идентификатор книги
     * @return сведения о комментарии
     */
    Comment insert(String text, long bookId);

    /**
     * Удаляет комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    void deleteByBookId(long bookId);
}
