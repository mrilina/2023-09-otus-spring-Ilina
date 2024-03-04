package ru.otus.hw.service;

import org.springframework.data.domain.Sort;
import ru.otus.hw.dto.AuthorDto;


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
     * @param sort направление сортировки
     * @return список авторов
     */
    List<AuthorDto> getAll(Sort sort);

}
