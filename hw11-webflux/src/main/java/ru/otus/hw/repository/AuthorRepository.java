package ru.otus.hw.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.hw.domain.Author;

/**
 * Репозиторий обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

}
