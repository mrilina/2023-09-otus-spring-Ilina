package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сведения об авторе.
 *
 * @author Irina Ilina
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
