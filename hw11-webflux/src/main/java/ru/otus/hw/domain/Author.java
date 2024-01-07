package ru.otus.hw.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Сведения об авторе.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document("authors")
public class Author {

    /**
     * Идентификатор.
     */
    @Id
    private String id;

    /**
     * ФИО.
     */
    private String name;
}
