package ru.otus.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw.domain.Book;
import ru.otus.hw.domain.Comment;

import java.util.List;

/**
 * Интерфейс репозитория обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);
}
