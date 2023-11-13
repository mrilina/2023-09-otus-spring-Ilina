package ru.otus.hw.services;

import ru.otus.hw.models.Book;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookService {

    /**
     * Возвращает сведения о книге по идентификатору.
     *
     * @param id идентификатор
     * @return сведений о книге
     */
    Optional<Book> findById(long id);

    /**
     * Возвращает список книг.
     *
     * @return список книг
     */
    List<Book> findAll();

    /**
     * Сохраняет сведения о книге.
     *
     * @param title     наименование
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов жанров
     * @return сведения о книге
     */
    Book insert(String title, long authorId, List<Long> genresIds);

    /**
     * Обновляет сведения о книге.
     *
     * @param title     наименование
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов жанров
     * @return сведения о книге
     */
    Book update(long id, String title, long authorId, List<Long> genresIds);

    /**
     * Удаление сведений о книге по идентификатору.
     *
     * @param id идентификатор
     */
    void deleteById(long id);
}
