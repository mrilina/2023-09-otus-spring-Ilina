package ru.otus.hw.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.models.Author;

/**
 * Маппер сведений об авторе.
 *
 * @author Irina Ilina
 */
@Component
public class AuthorMapper implements DtoMapper<Author, AuthorDto> {
    @Override
    public AuthorDto toDto(Author model) {
        return AuthorDto.builder()
                .id(model.getId())
                .name(model.getFullName())
                .build();
    }
}