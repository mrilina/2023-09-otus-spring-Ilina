package ru.otus.hw.converters;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.models.Comment;

/**
 * Конвертер сведений о комментарии.
 *
 * @author Irina Ilina
 */
@Component
public class CommentConverter {

    /**
     * Конвертирует сведения о комментарии в строковое представление.
     *
     * @param comment сведения о комментарии
     * @return строковое представление сведений о комментарии
     */
    public String commentToString(Comment comment) {
        return "Id: %d, Text: %s".formatted(comment.getId(), comment.getText());
    }

    /**
     * Конвертирует сведения о комментарии в строковое представление.
     *
     * @param comment сведения о комментарии
     * @return строковое представление сведений о комментарии
     */
    public String commentToString(CommentDto comment) {
        return "Id: %d, Text: %s".formatted(comment.getId(), comment.getComment());
    }
}
