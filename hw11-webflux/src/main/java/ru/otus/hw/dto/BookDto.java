package ru.otus.hw.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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
    @NotBlank
    private String id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) &&
                Objects.equals(title, bookDto.title) &&
                Objects.equals(author, bookDto.author) &&
                Objects.equals(genre, bookDto.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre);
    }

}
