package ru.otus.hw.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Сведения о книге.
 *
 * @author Irina Ilina
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "books")
public class Book {

    /**
     * Идентификатор.
     */
    @Id
    private String id;

    /**
     * Наименование.
     */
    private String title;

    /**
     * Автор.
     */
    @DBRef
    private Author author;

    /**
     * Список жанров.
     */
    @DBRef
    private List<Genre> genres;

    /**
     * Список комментариев к книге.
     */
    @DBRef
    private List<Comment> comments;
}
