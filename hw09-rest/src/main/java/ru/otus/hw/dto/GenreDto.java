package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сведения о жанре.
 *
 * @author Irina Ilina
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * Наименование.
     */
    private String name;
}
