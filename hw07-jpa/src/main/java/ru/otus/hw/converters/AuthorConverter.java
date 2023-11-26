package ru.otus.hw.converters;

import org.springframework.stereotype.Component;
import ru.otus.hw.models.Author;

/**
 * Конвертер сведений об авторе.
 *
 * @author Irina Ilina
 */
@Component
public class AuthorConverter {

    /**
     * Конвертирует сведения об авторе в строковое представление.
     *
     * @param author сведения об авторе
     * @return строковое представление сведений об авторе
     */
    public String authorToString(Author author) {
        return "Id: %d, FullName: %s".formatted(author.getId(), author.getFullName());
    }
}
