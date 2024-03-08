package ru.otus.hw.bookstore.service;

import ru.otus.hw.bookstore.dto.CommentDto;

import java.util.List;

/**
 * Интерфейс сервиса обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentService {

    /**
     * Возвращает списрок комментариев по идентификатору книги.
     *
     * @param bookId идентификатор книги
     * @return список комментариев
     */
    List<CommentDto> getAllByBookId(long bookId);
}
