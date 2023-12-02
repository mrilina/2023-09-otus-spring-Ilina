package ru.otus.hw.services;

import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.models.Author;

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
     * @return список авторов
     */
    List<AuthorDto> findAll();

    /**
     * Возвращает сведения об авторе.
     *
     * @param id идентификатор
     * @return сведения об автора
     */
    Author geAuthorById(Long id);
}
