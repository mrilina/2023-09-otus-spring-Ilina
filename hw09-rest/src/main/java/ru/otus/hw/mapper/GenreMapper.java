package ru.otus.hw.mapper;

import org.mapstruct.Mapper;
import ru.otus.hw.domain.Genre;
import ru.otus.hw.dto.GenreDto;

/**
 * Маппер сведений о жанре.
 *
 * @author Irina Ilina
 */
@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto map(Genre genre);
}
