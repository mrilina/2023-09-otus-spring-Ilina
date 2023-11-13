package ru.otus.hw.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сведения о жанре.
 *
 * @author Irina Ilina
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    /**
     * Идентификатор.
     */
    private long id;

    /**
     * Наименование.
     */
    private String name;
}
