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

/**
 * Сведения о комментарии.
 *
 * @author Irina Ilina
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document("comments")
public class Comment {

    /**
     * Идентификатор.
     */
    @Id
    private String id;

    /**
     * Текст.
     */
    private String text;

    /**
     * Сведения о книге.
     */
    @DBRef
    private Book book;
}
