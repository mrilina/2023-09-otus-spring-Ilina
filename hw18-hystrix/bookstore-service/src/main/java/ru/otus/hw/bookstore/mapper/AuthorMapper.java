package ru.otus.hw.bookstore.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.bookstore.dto.AuthorDto;
import ru.otus.hw.bookstore.domain.Author;

/**
 * Маппер сведений об авторе.
 *
 * @author Irina Ilina
 */
@Component
public class AuthorMapper {

    private AuthorMapper() {
    }

    public static AuthorDto mapAuthorToDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }
}
