package ru.otus.hw.services;

import ru.otus.hw.dto.BookDto;

import java.util.List;

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
    BookDto findById(long id);

    /**
     * Возвращает строковое представление сведений о книге.
     *
     * @param id идентификатор
     * @return строковое представление
     */
    String getById(long id);

    /**
     * Возвращает список книг.
     *
     * @return список книг
     */
    List<BookDto> findAll();

    /**
     * Возвращает строковое представление обо всех книгах.
     *
     * @return строковое представление
     */
    String getAll();

    /**
     * Сохраняет сведения о книге.
     *
     * @param title     наименование
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов жанров
     * @return сведения о книге
     */
    BookDto insert(String title, long authorId, List<Long> genresIds);

    /**
     * Возвращает строковое представление о сохраненной книге.
     *
     * @param title     наименование
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов жанров
     * @return строковое представление
     */
    String insertBook(String title, long authorId, List<Long> genresIds);

    /**
     * Обновляет сведения о книге.
     *
     * @param title     наименование
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов жанров
     * @return сведения о книге
     */
    BookDto update(long id, String title, long authorId, List<Long> genresIds);

    /**
     * Возвращает строковое представление об обновленных сведениях о книге.
     *
     * @param title     наименование
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов жанров
     * @return строковое представление
     */
    String updateBook(long id, String title, long authorId, List<Long> genresIds);


    /**
     * Удаление сведений о книге по идентификатору.
     *
     * @param id идентификатор
     */
    void deleteById(long id);
}
