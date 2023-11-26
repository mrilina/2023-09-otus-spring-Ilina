package ru.otus.hw.services;

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
    List<Author> findAll();
}
