package ru.otus.hw.bookstore.service;

import org.springframework.data.domain.Sort;
import ru.otus.hw.bookstore.dto.AuthorDto;


import java.util.List;

/**
 * Интерфейс сервиса обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
public interface AuthorService {

    /**
     * Возвращает всех авторов.
     *
     * @param sort сортировка
     * @return список авторов
     */
    List<AuthorDto> getAll(Sort sort);
}
