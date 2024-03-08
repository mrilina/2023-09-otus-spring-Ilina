package ru.otus.hw.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.otus.hw.bookstore.domain.Book;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findById(long id);

    List<Book> findAll();

    List<Book> findAllByGenreId(long id);

    List<Book> findAllByAuthorId(long id);

    @Modifying
    @Query("delete from Book")
    void deleteAll();
}
