package ru.otus.hw.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сведения о книге.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookCreateDto {

    /**
     * Наименование.
     */
    @NotBlank
    private String title;

    /**
     * Идентификатор сведений об жанре.
     */
    @NotNull
    private Long genreId;

    /**
     * Идентификатор сведений об авторе.
     */
    @NotNull
    private Long authorId;
}
