package ru.otus.hw.services;

import ru.otus.hw.dto.BookDto;
import ru.otus.hw.models.Book;

import java.util.List;

/**
 * Интерфейс сервиса обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookService {

    /**
     * Возвращает список книг.
     *
     * @return список книг
     */
    List<BookDto> findAll();

    /**
     * Возвращает сведения о книге по идентификатору.
     *
     * @param id идентификатор
     * @return сведений о книге
     */
    BookDto findBookById(Long id);

    /**
     * Возвращает сведения о книге по идентификатору.
     *
     * @param id идентификатор
     * @return сведений о книге
     */
    Book getBookById(Long id);

    /**
     * Сохраняет сведения о книге.
     *
     * @param name      наименование
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов жанров
     */
    void insert(String name, Long authorId, List<Long> genresIds);

    /**
     * Обновляет сведения о книге.
     *
     * @param name      наименование
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов жанров
     */
    Book update(Long id, String name, Long authorId, List<Long> genresIds);

    /**
     * Удаление сведений о книге по идентификатору.
     *
     * @param id идентификатор
     */
    void deleteBookById(Long id);
}
