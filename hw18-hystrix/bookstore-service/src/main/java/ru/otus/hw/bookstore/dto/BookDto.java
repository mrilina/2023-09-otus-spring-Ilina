package ru.otus.hw.bookstore.dto;

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
public class BookDto {

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
     * Сведения об авторе.
     */
    @NotBlank
    private String author;

    /**
     * Сведения о жанре.
     */
    @NotBlank
    private String genre;

}
