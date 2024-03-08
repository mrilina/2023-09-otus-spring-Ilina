package ru.otus.hw.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сведения о жанре.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenreDto {

    /**
     * Идентификатор.
     */
    @NotNull
    private Long id;

    /**
     * Наименование.
     */
    @NotBlank
    private String name;

}
