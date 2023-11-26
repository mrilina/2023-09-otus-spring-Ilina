package ru.otus.hw.services;

import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.dto.GenreDto;

/**
 * Интерфейс сервиса преобразования сведений о модели в строковое представление.
 *
 * @author Irina Ilina
 */
public interface ConvertService {

    /**
     * Конвертирует сведения об авторе в строковое представление.
     *
     * @param author сведения об авторе
     * @return строковое представление сведений об авторе
     */
    String authorToString(AuthorDto author);

    /**
     * Конвертирует сведения о комментарии в строковое представление.
     *
     * @param comment сведения о комментарии
     * @return строковое представление сведений о комментарии
     */
    String commentToString(CommentDto comment);

    /**
     * Конвертирует сведения о жанре в строковое представление.
     *
     * @param genre сведения о жанре
     * @return строковое представление сведений о жанре
     */
    String genreToString(GenreDto genre);

    /**
     * Конвертирует сведения о книге в строковое представление.
     *
     * @param book сведения о книге
     * @return строковое представление сведений о книге
     */
    String bookToString(BookDto book);
}
