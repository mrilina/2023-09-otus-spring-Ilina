package ru.otus.hw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.hw.models.Comment;

/**
 * Интерфейс репозитория обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * Удаляет все комментарии по идентификатору книги.
     *
     * @param bookId идентификатор книги
     */
    @Modifying
    @Query("Delete from Comment where book.id = :bookId")
    void deleteByBookId(@Param("bookId") long bookId);
}
