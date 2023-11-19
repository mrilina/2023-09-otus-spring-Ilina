package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Сведения о книге.
 *
 * @author Irina Ilina
 */
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * Наименование.
     */
    private String name;

    /**
     * Автор.
     */
    private AuthorDto author;

    /**
     * Список жанров.
     */
    private List<GenreDto> genres;

    /**
     * Список комментариев к книге.
     */
    private List<CommentDto> comments;
}