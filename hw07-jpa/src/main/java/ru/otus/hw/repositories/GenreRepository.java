package ru.otus.hw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw.models.Genre;

/**
 * Репозиторий обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
}

