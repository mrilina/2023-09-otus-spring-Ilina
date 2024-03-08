package ru.otus.hw.client.dto;

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
     * Сведения о жанре.
     */
    @NotNull
    private Long genreId;

    /**
     * Сведения об авторе.
     */
    @NotNull
    private Long authorId;
}
