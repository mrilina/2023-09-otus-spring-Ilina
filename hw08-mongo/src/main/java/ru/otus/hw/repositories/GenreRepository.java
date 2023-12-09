package ru.otus.hw.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw.models.Genre;

/**
 * Репозиторий обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
public interface GenreRepository extends MongoRepository<Genre, String> {
}

