package ru.otus.hw.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * Сведения о комментарии.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {

    /**
     * Идентификатор.
     */
    @NotBlank
    private String id;

    /**
     * Текст.
     */
    @NotBlank
    private String text;

    /**
     * Идентификатор книги.
     */
    @NotBlank
    private String bookId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var commentDto = (CommentDto) o;
        return Objects.equals(id, commentDto.id) && Objects.equals(text, commentDto.text) &&
                Objects.equals(bookId, commentDto.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, bookId);
    }
}
