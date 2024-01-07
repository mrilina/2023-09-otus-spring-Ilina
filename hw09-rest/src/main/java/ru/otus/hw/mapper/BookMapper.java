package ru.otus.hw.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.otus.hw.domain.Book;
import ru.otus.hw.dto.BookDto;

/**
 * Маппер сведений об книге.
 *
 * @author Irina Ilina
 */
@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", source = "book.id")
    @Mapping(target = "name", source = "book.name")
    @Mapping(target = "author", source = "author.name")
    @Mapping(target = "genre", source = "genre.name")
    BookDto map(Book book);
}
