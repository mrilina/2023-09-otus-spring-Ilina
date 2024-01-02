package ru.otus.hw.service;

import ru.otus.hw.domain.Genre;
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
    List<GenreDto> getAll();

    /**
     * Возвращает сведения о жанре по идентификатору.
     *
     * @param id идентификатор жанра
     * @return сведения о жанре
     */
    Genre geGenreById(Long id);

    /**
     * Возвращает сведения о жанре по наименованию.
     *
     * @param name наименования жанра
     * @return сведения о жанре
     */
    Genre getGenreByName(String name);
}
