package ru.otus.hw.service;

import org.springframework.data.domain.Sort;
import ru.otus.hw.dto.BookCreateDto;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.BookUpdateDto;

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
     * @param bookDto сведения о книге
     * @return сведения о книге
     */
    BookDto create(BookCreateDto bookDto);

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
     * @param sort направление сортировки
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
     * Возвращает список книг по идентификатору жанра.
     *
     * @param genreId идентификатор сведений о жанре
     * @return список книг
     */
    List<BookDto> getAllByGenreId(long genreId);

    /**
     * Возвращает список книг по идентификатору автора.
     *
     * @param authorId идентификатор сведений об авторе
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
