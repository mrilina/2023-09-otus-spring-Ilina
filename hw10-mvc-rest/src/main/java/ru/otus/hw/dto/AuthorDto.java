package ru.otus.hw.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сведения об авторе.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDto {

    /**
     * Идентификатор.
     */
    @NotNull
    private Long id;

    /**
     * ФИО.
     */
    @NotBlank
    private String name;
}
