package ru.otus.hw.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.hw.domain.Genre;

/**
 * Репозиторий обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre getGenreByName(String name);
}
