package ru.otus.hw.bookstore.service;

import org.springframework.data.domain.Sort;
import ru.otus.hw.bookstore.dto.BookCreateDto;
import ru.otus.hw.bookstore.dto.BookDto;
import ru.otus.hw.bookstore.dto.BookUpdateDto;


import java.util.List;

/**
 * Интерфейс сервиса обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookService {

    /**
     * Сохраняет сведения о книге.
     *
     * @param bookCreateDto сведения о книге
     * @return сведения о книге
     */
    BookDto create(BookCreateDto bookCreateDto);

    /**
     * Обновляет сведения о книге.
     *
     * @param bookUpdateDto сведения о книге
     * @return сведения о книге
     */
    BookDto update(BookUpdateDto bookUpdateDto);

    /**
     * Возвращает список книг.
     *
     * @param sort сортировка
     * @return список книг
     */
    List<BookDto> getAll(Sort sort);

    /**
     * Возвращает сведения о книге по идентификатору.
     *
     * @param id идентификатор
     * @return сведений о книге
     */
    BookDto getById(long id);

    /**
     * Возвращает список книг по идентификатору жанра
     *
     * @param genreId идентификатор жанра
     * @return список книг
     */
    List<BookDto> getAllByGenreId(long genreId);

    /**
     * Возвращает список книг по идентификатору автора
     *
     * @param authorId идентификатор автора
     * @return список книг
     */
    List<BookDto> getAllByAuthorId(long authorId);

    /**
     * Удаляет сведения о книге по идентификатору.
     *
     * @param id идентификатор
     */
    void deleteById(long id);

    /**
     * Удаляет сведения обо всех книгах.
     */
    void deleteAll();

}
