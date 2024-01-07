package ru.otus.hw.mapper;

import org.mapstruct.Mapper;
import ru.otus.hw.domain.Author;
import ru.otus.hw.dto.AuthorDto;

/**
 * Маппер сведений об авторе.
 *
 * @author Irina Ilina
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(Author author);
}
