package ru.otus.hw.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Сведения о книге.
 *
 * @author Irina Ilina
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document("books")
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
     * Сведения о жанре.
     */
    @DBRef
    private Genre genre;

    /**
     * Сведения об авторе.
     */
    @DBRef
    private Author author;

    /**
     * Список комментариев к книге.
     */
    @DBRef
    private List<Comment> comments;

}
