package ru.otus.hw.repositories;

import ru.otus.hw.models.Book;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс репозитория обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookRepository {

    /**
     * Возвращает сведения о книге по идентификатору.
     *
     * @param id идентификатор
     * @return сведения о книге
     */
    Optional<Book> findById(long id);

    /**
     * Возвращает список сведений о книгах.
     *
     * @return список книг
     */
    List<Book> findAll();

    /**
     * Сохраняет сведения о книге.
     *
     * @param book сведения о книге
     * @return сохраненные сведения о книге
     */
    Book save(Book book);

    /**
     * Удаляет сведенияы о книге.
     *
     * @param id идентификатор
     */
    void deleteById(long id);
}
