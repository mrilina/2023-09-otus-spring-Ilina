package ru.otus.hw.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Сведения о комментарии.
 *
 * @author Irina Ilina
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection =  "comments")
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
