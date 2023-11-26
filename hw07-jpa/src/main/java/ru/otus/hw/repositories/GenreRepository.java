package ru.otus.hw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.hw.models.Genre;

import java.util.List;
import java.util.Set;

/**
 * Репозиторий обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {

    /**
     * Возвращает список всех жанров по списку идентификаторов.
     *
     * @param ids список идентификаторов
     * @return список жанров
     */
    @Query("select g from Genre g where g.id IN :ids")
    List<Genre> findAllById(@Param("ids") Set<Long> ids);
}
