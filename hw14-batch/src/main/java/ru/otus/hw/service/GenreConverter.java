package ru.otus.hw.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.hw.domain.jpa.Genre;
import ru.otus.hw.domain.mongo.GenreDocument;

/**
 * Конвертер обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */

@Service
public class GenreConverter implements Converter<Genre, GenreDocument> {

    @Override
    public GenreDocument convert(Genre genre) {
        return new GenreDocument(String.valueOf(genre.getId()), genre.getName());
    }
}
