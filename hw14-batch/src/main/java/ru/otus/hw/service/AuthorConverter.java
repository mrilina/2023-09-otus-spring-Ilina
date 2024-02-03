package ru.otus.hw.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.hw.domain.jpa.Author;
import ru.otus.hw.domain.mongo.AuthorDocument;

/**
 * Конвертер обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@Service
public class AuthorConverter implements Converter<Author, AuthorDocument> {

    @Override
    public AuthorDocument convert(Author author) {
        return new AuthorDocument(String.valueOf(author.getId()),author.getName());
    }
}
