package ru.otus.hw.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Сведения о комментарии.
 *
 * @author Irina Ilina
 */
@Builder
@Getter
@ToString
public class CommentDto {

    /**
     * Идентификатор.
     */
    private Long id;

    /**
     * Текст.
     */
    private String comment;
}