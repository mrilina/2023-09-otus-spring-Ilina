package ru.otus.hw.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.hw.models.Comment;

/**
 * Репозиторий обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
@Component
@RequiredArgsConstructor
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == 0) {
            em.persist(comment);
            return comment;
        }
        return em.merge(comment);
    }

    @Override
    public void deleteByBookId(long bookId) {
        em.createQuery("delete from Comment c where c.book.id = :bookId")
                .setParameter("bookId", bookId)
                .executeUpdate();
    }
}
