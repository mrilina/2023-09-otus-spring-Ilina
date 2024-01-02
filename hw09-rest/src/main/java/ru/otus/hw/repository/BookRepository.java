package ru.otus.hw.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.hw.domain.Book;

/**
 * Репозиторий обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
