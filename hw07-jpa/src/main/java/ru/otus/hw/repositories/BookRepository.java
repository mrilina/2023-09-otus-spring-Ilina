package ru.otus.hw.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw.models.Book;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = {"author", "genres"})
    Optional<Book> findById(Long id);

    @EntityGraph(attributePaths = {"author", "genres"})
    List<Book> findAll();
}
