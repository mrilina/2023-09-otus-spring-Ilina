package ru.otus.hw.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.models.Comment;

/**
 * Маппер сведений о комментарии.
 *
 * @author Irina Ilina
 */
@Component
public class CommentMapper implements DtoMapper<Comment, CommentDto> {

    @Override
    public CommentDto toDto(Comment model) {
        return CommentDto.builder()
                .id(model.getId())
                .text(model.getText())
                .build();
    }
}