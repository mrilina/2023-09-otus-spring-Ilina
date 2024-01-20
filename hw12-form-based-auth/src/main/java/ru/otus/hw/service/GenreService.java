package ru.otus.hw.service;

import org.springframework.data.domain.Sort;
import ru.otus.hw.domain.Genre;

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
     * @param sort направление сортировки
     * @return список жанров
     */
    List<Genre> getAll(Sort sort);
}