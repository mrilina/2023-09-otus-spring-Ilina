package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сведения о комментарии.
 *
 * @author Irina Ilina
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * Текст.
     */
    private String text;

    /**
     * Идентификатор книги.
     */
    private Long bookId;
}