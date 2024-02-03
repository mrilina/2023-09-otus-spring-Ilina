package ru.otus.hw.service;

import ru.otus.hw.domain.Comment;

import java.util.List;

/**
 * Интерфейс сервиса обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentService {

    /**
     * Возвращает список комментариев по идентификатору книги.
     *
     * @param bookId идентификатор книги
     * @return список комментариев
     */
    List<Comment> getAllByBookId(long bookId);

}
