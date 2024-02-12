package ru.otus.hw.domain.mongo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Сведения о книге.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document("books")
public class BookDocument {

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
     * Жанр.
     */
    @DBRef
    private GenreDocument genreDocument;

    /**
     * Автор.
     */
    @DBRef
    private AuthorDocument authorDocument;
}
