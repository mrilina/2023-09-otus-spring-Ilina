package ru.otus.hw.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.hw.domain.Book;
import ru.otus.hw.domain.Comment;

/**
 * Интерфейс репозитория обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {

    Flux<Comment> findAllByBook(Book book);
}
