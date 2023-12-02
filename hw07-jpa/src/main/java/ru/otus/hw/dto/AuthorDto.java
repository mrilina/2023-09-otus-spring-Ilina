package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сведения об авторе.
 *
 * @author Irina Ilina
 */
@Data
@Builder
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
