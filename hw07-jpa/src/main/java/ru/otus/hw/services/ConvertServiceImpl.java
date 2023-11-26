package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.dto.GenreDto;

import java.util.stream.Collectors;

/**
 * Сервис преобразования сведений о модели в строковое представление.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class ConvertServiceImpl implements ConvertService {

    public String authorToString(AuthorDto author) {
        return "Id: %d, FullName: %s".formatted(author.getId(), author.getName());
    }

    public String commentToString(CommentDto comment) {
        return "Id: %d, Text: %s".formatted(comment.getId(), comment.getComment());
    }

    public String genreToString(GenreDto genre) {
        return "Id: %d, Name: %s".formatted(genre.getId(), genre.getName());
    }

    public String bookToString(BookDto book) {
        var genresString = book.getGenres().stream()
                .map(this::genreToString)
                .map("{%s}"::formatted)
                .collect(Collectors.joining(", "));
        return "Id: %d, title: %s, author: {%s}, genres: [%s]".formatted(
                book.getId(),
                book.getName(),
                authorToString(book.getAuthor()),
                genresString);
    }
}
