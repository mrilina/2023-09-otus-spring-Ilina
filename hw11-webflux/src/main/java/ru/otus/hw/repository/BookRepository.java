package ru.otus.hw.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.hw.domain.Book;

/**
 * Репозиторий обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    Flux<Book> findAllByGenreId(String genreId);

    Flux<Book> findAllByAuthorId(String authorId);
}
