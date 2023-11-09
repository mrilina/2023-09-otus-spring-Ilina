package ru.otus.hw.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сведения об авторе.
 *
 * @author Irina Ilina
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    /**
     * Идентификатор.
     */
    private long id;

    /**
     * ФИО.
     */
    private String fullName;
}
