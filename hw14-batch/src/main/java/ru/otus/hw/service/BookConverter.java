package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.hw.domain.jpa.Author;
import ru.otus.hw.domain.jpa.Book;
import ru.otus.hw.domain.jpa.Genre;
import ru.otus.hw.domain.mongo.AuthorDocument;
import ru.otus.hw.domain.mongo.BookDocument;
import ru.otus.hw.domain.mongo.GenreDocument;

/**
 * Конвертер обработки сведений о книгах.
 *
 * @author Irina Ilina
 */

@Service
@RequiredArgsConstructor
public class BookConverter implements Converter<Book, BookDocument> {

    private final Converter<Author, AuthorDocument> authorConverter;

    private final Converter<Genre, GenreDocument> genreConverter;


    @Override
    public BookDocument convert(Book book) {
        var genre = book.getGenre();
        var author = book.getAuthor();
        return new BookDocument(String.valueOf(book.getId()),
                        book.getTitle(),
                genreConverter.convert(genre),
                authorConverter.convert(author));
    }
}
