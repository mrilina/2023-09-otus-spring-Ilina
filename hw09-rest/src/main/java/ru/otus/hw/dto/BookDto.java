package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сведения о книге.
 *
 * @author Irina Ilina
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * Наименование.
     */
    private String name;

    /**
     * Сведения об авторе.
     */
    private String author;

    /**
     * Сведения о жанре.
     */
    private String genre;
}
