package ru.otus.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw.domain.User;

import java.util.Optional;

/**
 * Репозиторий обработки сведений о пользователях.
 *
 * @author Irina Ilina
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
