package ru.otus.hw.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.hw.models.Book;

import java.util.stream.Collectors;

/**
 * Конвертер сведений о книге.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@Component
public class BookConverter {

    /**
     * Конвертер сведений об авторе.
     */
    private final AuthorConverter authorConverter;

    /**
     * Конвертер сведений о жанре.
     */
    private final GenreConverter genreConverter;

    /**
     * Конвертирует сведения о книге в строковое представление.
     *
     * @param book сведения о книге
     * @return строковое представление сведений о книге
     */
    public String bookToString(Book book) {
        var genresString = book.getGenres().stream()
                .map(genreConverter::genreToString)
                .map("{%s}"::formatted)
                .collect(Collectors.joining(", "));
        return "Id: %d, title: %s, author: {%s}, genres: [%s]".formatted(
                book.getId(),
                book.getTitle(),
                authorConverter.authorToString(book.getAuthor()),
                genresString);
    }
}
