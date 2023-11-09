package ru.otus.hw.repositories;

import ru.otus.hw.models.Author;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс репозитория обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
public interface AuthorRepository {

    /**
     * Возвращает сведений обо всех авторах.
     *
     * @return список авторов
     */
    List<Author> findAll();

    /**
     * Возвращает сведений об авторе по идентификатору.
     *
     * @param id идентификатор
     * @return автор
     */
    Optional<Author> findById(long id);
}
