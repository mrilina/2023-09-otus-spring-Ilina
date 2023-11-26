package ru.otus.hw.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Сведения об авторе.
 *
 * @author Irina Ilina
 */
@Builder
@Getter
@ToString
public class AuthorDto {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * ФИО.
     */
    private String name;
}