package ru.otus.hw.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.otus.hw.models.Comment;

import java.util.List;

/**
 * Репозиторий обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
@Repository
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private final EntityManager em;

    /**
     * Конструктор.
     *
     * @param em менеджер сущностей
     */
    public CommentRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Comment> findAllByBookId(Long bookId) {
        var q = em.createQuery("select c from Comment c join fetch c.book as b where b.id = :bookId",
                Comment.class);
        q.setParameter("bookId", bookId);
        return q.getResultList();
    }

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
