package ru.otus.hw.service;

import ru.otus.hw.domain.Author;
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
    List<AuthorDto> getAll();

    /**
     * Возвращает автора по его имени.
     *
     * @return сведения об авторе
     */
    Author getAuthorByName(String name);
}
