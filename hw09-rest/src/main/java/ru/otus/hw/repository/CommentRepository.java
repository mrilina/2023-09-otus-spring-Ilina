package ru.otus.hw.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.hw.domain.Comment;

import java.util.List;

/**
 * Интерфейс репозитория обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByBookId(Long id);

}
