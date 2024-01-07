package ru.otus.hw.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.hw.domain.Genre;

/**
 * Репозиторий обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

}
