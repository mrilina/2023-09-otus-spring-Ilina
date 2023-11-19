package ru.otus.hw.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Сведения о жанре.
 *
 * @author Irina Ilina
 */
@Builder
@Getter
@ToString
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