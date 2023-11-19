package ru.otus.hw.repositories;

import ru.otus.hw.models.Comment;

/**
 * Интерфейс репозитория обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentRepository {

    /**
     * Сохраняет сведения о комментарии.
     *
     * @param comment сведения о комментарии
     * @return сохраненные сведения о комментарии
     */
    Comment save(Comment comment);

    /**
     * Удаляет все комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    void deleteByBookId(long bookId);
}
