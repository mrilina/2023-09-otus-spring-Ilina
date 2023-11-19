package ru.otus.hw.converters;

import org.springframework.stereotype.Component;
import ru.otus.hw.models.Genre;

/**
 * Конвертер сведений о жанре.
 *
 * @author Irina Ilina
 */
@Component
public class GenreConverter {

    /**
     * Конвертирует сведения о жанре в строковое представление.
     *
     * @param genre сведения о жанре
     * @return строковое представление сведений о жанре
     */
    public String genreToString(Genre genre) {
        return "Id: %d, Name: %s".formatted(genre.getId(), genre.getName());
    }
}
