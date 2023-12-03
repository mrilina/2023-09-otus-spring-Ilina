package ru.otus.hw.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw.models.Comment;

import java.util.List;

/**
 * Интерфейс репозитория обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByBookId(String id);


    /**
     * Удаляет все комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    void deleteByBookId(String bookId);
}