package ru.otus.hw.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw.models.Book;

/**
 * Репозиторий обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookRepository extends MongoRepository<Book, String> {
}
