package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сведения о жанре.
 *
 * @author Irina Ilina
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {

    /**
     * Идентификатор.
     */
    private String id;

    /**
     * Наименование.
     */
    private String name;
}
