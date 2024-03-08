package ru.otus.hw.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotNull
    private Long id;

    /**
     * Текст.
     */
    @NotBlank
    private String text;

    /**
     * Идентификатор книги.
     */
    @NotNull
    private Long bookId;
}
