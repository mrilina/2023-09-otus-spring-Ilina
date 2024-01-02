package ru.otus.hw.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.hw.domain.Author;

/**
 * Репозиторий обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author getAuthorByName(String name);
}
