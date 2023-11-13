package ru.otus.hw.repositories;

import ru.otus.hw.models.Genre;

import java.util.List;

/**
 * Интерфейс репозитория обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
public interface GenreRepository {

    /**
     * Возвращает список всех жанров.
     *
     * @return список жанров
     */
    List<Genre> findAll();

    /**
     * Возвращает список всех жанров по списку идентификаторов.
     *
     * @param ids список идентификаторов
     * @return список жанров
     */
    List<Genre> findAllByIds(List<Long> ids);
}
