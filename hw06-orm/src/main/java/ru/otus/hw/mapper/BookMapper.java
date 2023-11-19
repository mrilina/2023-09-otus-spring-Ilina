package ru.otus.hw.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.dto.GenreDto;
import ru.otus.hw.models.Book;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/**
 * Маппер сведений об книге.
 *
 * @author Irina Ilina
 */
@Component
public class BookMapper implements DtoMapper<Book, BookDto> {
    @Override
    public BookDto toDto(Book model) {
        return isNull(model) ? null : BookDto.builder()
                .id(model.getId())
                .name(model.getTitle())
                .genres(isNull(model.getGenres()) ? null : model.getGenres().stream().map(
                        g -> GenreDto.builder()
                        .id(g.getId())
                        .name(g.getName())
                        .build()).collect(Collectors.toList()))
                .author(AuthorDto.builder()
                        .id(model.getAuthor().getId())
                        .name(model.getAuthor().getFullName())
                        .build())
                .comments(isNull(model.getComments()) ? null : model.getComments().stream().map(m -> CommentDto.builder()
                        .id(m.getId())
                        .comment(m.getText())
                        .build()).collect(Collectors.toList()))
                .build();
    }
}