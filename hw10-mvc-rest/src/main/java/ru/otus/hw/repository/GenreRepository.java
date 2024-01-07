package ru.otus.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.otus.hw.domain.Genre;

/**
 * Репозиторий обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Modifying
    @Query("delete from Genre")
    void deleteAll();
}
