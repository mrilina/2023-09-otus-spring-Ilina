package ru.otus.hw.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw.bookstore.domain.Book;
import ru.otus.hw.bookstore.domain.Comment;

import java.util.List;

/**
 * Интерфейс репозитория обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);
}
