package ru.otus.hw.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.GenreDto;
import ru.otus.hw.models.Genre;

/**
 * Маппер сведений о жанре.
 *
 * @author Irina Ilina
 */
@Component
public class GenreMapper implements DtoMapper<Genre, GenreDto> {
    @Override
    public GenreDto toDto(Genre model) {
        return GenreDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}