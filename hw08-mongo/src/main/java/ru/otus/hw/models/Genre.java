package ru.otus.hw.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Сведения о жанре.
 *
 * @author Irina Ilina
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection =  "genres")
public class Genre {

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
