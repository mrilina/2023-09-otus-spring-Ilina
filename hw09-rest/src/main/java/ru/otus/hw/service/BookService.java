package ru.otus.hw.service;

import ru.otus.hw.dto.BookDto;

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
    List<BookDto> getAll();

    /**
     * Возвращает сведения о книге по идентификатору.
     *
     * @param id идентификатор
     * @return сведений о книге
     */
    BookDto getBookById(Long id);

    /**
     * Сохраняет сведения о книге.
     *
     * @param name       наименование
     * @param authorName сведения об авторе
     * @param genreName  сведения о жанре
     * @return сведения о книге
     */
    BookDto saveBook(String name, String authorName, String genreName);

    /**
     * Обновляет сведения о книге.
     *
     * @param name       наименование
     * @param authorName сведения об авторе
     * @param genreName  сведения о жанре
     * @return сведения о книге
     */
    BookDto updateBook(Long id, String name, String authorName, String genreName);

    /**
     * Удаление сведений о книге по идентификатору.
     *
     * @param id идентификатор
     */
    void deleteBookById(Long id);
}
