package ru.otus.hw.bookstore.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.bookstore.dto.GenreDto;
import ru.otus.hw.bookstore.domain.Genre;

/**
 * Маппер сведений о жанре.
 *
 * @author Irina Ilina
 */
@Component
public class GenreMapper {

    private GenreMapper() {
    }

    public static GenreDto mapGenreToDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }
}

