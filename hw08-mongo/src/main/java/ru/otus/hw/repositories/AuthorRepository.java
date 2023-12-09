package ru.otus.hw.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw.models.Author;

/**
 * Репозиторий обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
public interface AuthorRepository extends MongoRepository<Author, String> {
}
