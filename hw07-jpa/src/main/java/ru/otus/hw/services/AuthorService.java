package ru.otus.hw.services;

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
     * @return список авторов
     */
    List<AuthorDto> findAll();


    /**
     * Возвращает строковое представление обо всех авторах.
     *
     * @return строковое представление
     */
    String getAll();
}
