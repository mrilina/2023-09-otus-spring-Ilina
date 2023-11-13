package ru.otus.hw.services;

import ru.otus.hw.models.Genre;

import java.util.List;

/**
 * Интерфейс сервиса обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
public interface GenreService {

    /**
     * Возвращает список жанров.
     *
     * @return список жанров
     */
    List<Genre> findAll();


    /**
     * Возвращает список жанров по идентификаторам.
     *
     * @param ids список идентификаторов жанров
     * @return список жанров
     */
    List<Genre> findAllByIds(List<Long> ids);
}
