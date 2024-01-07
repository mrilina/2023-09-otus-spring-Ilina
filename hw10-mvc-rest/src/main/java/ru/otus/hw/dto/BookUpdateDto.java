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
public class BookUpdateDto {

    /**
     * Идентификатор.
     */
    @NotNull
    private Long id;

    /**
     * Наименование.
     */
    @NotBlank
    private String title;

    /**
     * Идентификатор сведений об авторе.
     */
    @NotNull
    private Long authorId;

    /**
     * Идентификатор сведений о жанре.
     */
    @NotNull
    private Long genreId;
}
