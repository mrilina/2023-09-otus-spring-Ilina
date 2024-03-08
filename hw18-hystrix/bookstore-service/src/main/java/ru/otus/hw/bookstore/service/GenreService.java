package ru.otus.hw.bookstore.service;

import org.springframework.data.domain.Sort;
import ru.otus.hw.bookstore.dto.GenreDto;


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
    List<GenreDto> getAll(Sort sort);

}
