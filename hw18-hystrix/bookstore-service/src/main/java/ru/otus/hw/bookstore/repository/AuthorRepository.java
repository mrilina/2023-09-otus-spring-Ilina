package ru.otus.hw.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.otus.hw.bookstore.domain.Author;

/**
 * Репозиторий обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Modifying
    @Query("delete from Author")
    void deleteAll();
}
