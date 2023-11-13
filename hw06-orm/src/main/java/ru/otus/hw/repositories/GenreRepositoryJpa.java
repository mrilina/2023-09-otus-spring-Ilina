package ru.otus.hw.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.otus.hw.models.Genre;

import java.util.List;

/**
 * Репозиторий обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@Repository
public class GenreRepositoryJpa implements GenreRepository {

    @PersistenceContext
    private final EntityManager em;

    /**
     * Конструктор.
     *
     * @param em менеджер сущностей
     */
    public GenreRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Genre> findAll() {
        var query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }

    @Override
    public List<Genre> findAllByIds(List<Long> ids) {
        var q = em.createQuery("select g from Genre g where g.id IN :ids", Genre.class);
        q.setParameter("ids", ids);
        return q.getResultList();
    }
}
