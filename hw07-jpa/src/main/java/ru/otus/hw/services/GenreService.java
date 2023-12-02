package ru.otus.hw.services;

import ru.otus.hw.dto.GenreDto;
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
    List<GenreDto> getAll();

    /**
     * Возвращает список жанров по идентификаторам.
     *
     * @param id список идентификаторов жанров
     * @return список жанров
     */
    Genre getGenreById(Long id);

    /**
     * Возвращает список жанров по идентификаторам.
     *
     * @param ids список идентификаторов жанров
     * @return список жанров
     */
    List<Genre> findAllByIds(List<Long> ids);
}
