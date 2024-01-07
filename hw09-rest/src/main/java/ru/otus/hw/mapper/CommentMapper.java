package ru.otus.hw.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.otus.hw.domain.Comment;
import ru.otus.hw.dto.CommentDto;

/**
 * Маппер сведений о комментарии.
 *
 * @author Irina Ilina
 */
@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", source = "book.id")
    CommentDto map(Comment comment);
}
