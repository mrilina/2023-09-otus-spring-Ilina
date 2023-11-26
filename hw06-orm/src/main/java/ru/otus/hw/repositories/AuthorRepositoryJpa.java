package ru.otus.hw.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import ru.otus.hw.models.Author;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@Component
public class AuthorRepositoryJpa implements AuthorRepository {

    @PersistenceContext
    private final EntityManager em;

    /**
     * Конструктор.
     *
     * @param em менеджер сущностей
     */
    public AuthorRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Author> findAll() {
        var query = em.createQuery("select a from Author a order by a.id", Author.class);
        return query.getResultList();
    }

    @Override
    public Optional<Author> findById(long id) {
        return Optional.ofNullable(em.find(Author.class, id));
    }
}
