package ru.otus.hw.domain.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Сведения о жанре.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("genres")
public class GenreDocument {

    /**
     * Идентификатор.
     */
    @Id
    private String id;

    /**
     * Наименование.
     */
    private String name;
}
