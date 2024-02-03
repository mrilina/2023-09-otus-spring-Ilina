package ru.otus.hw.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.domain.Comment;

/**
 * Маппер сведений о комментарии.
 *
 * @author Irina Ilina
 */
@Component
public class CommentMapper {

    private CommentMapper() {
    }

    public static CommentDto mapCommentToDto(Comment comment) {

        var commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setText(comment.getText());
        commentDto.setBookId(comment.getBook().getId());

        return commentDto;
    }
}
