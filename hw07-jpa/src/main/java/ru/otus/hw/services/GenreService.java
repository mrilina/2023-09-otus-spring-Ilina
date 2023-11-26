package ru.otus.hw.services;

import ru.otus.hw.dto.GenreDto;

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
    List<GenreDto> findAll();

    /**
     * Возвращает строковое представление списка жанров.
     *
     * @return строковое представление
     */
    String getAll();

    /**
     * Возвращает список жанров по идентификаторам.
     *
     * @param ids список идентификаторов жанров
     * @return список жанров
     */
    List<GenreDto> findAllByIds(List<Long> ids);

    /**
     * Возвращает строковое представление списка жанров по идентификаторам.
     *
     * @param ids список идентификаторов жанров
     * @return строковое представление
     */
    String getAllByIds(List<Long> ids);
}
