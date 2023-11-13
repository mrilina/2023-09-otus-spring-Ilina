package ru.otus.hw.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.hw.models.Author;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест AuthorRepositoryJpa должен")
@DataJpaTest
@Import(value = {AuthorRepositoryJpa.class})
class AuthorRepositoryJpaTest {

    private static final int EXPECTED_AUTHORS_COUNT = 3;

    private static final long EXISTING_AUTHOR_ID = 1L;

    @Autowired
    private TestEntityManager testEntityManager;

    /**
     * Репозиторий обработки сведений об авторах.
     */
    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    @Test
    @DisplayName("возвращать ожидаемого автора по его идентификатору")
    void shouldReturnExpectedAuthorById() {
        var expectedAuthor = testEntityManager.find(Author.class, EXISTING_AUTHOR_ID);
        var optionalActualAuthor = authorRepositoryJpa.findById(EXISTING_AUTHOR_ID);

        assertThat(optionalActualAuthor)
                .isPresent()
                .get()
                .usingRecursiveComparison()
                .isEqualTo(expectedAuthor);
    }

    @Test
    @DisplayName("возвращать ожидаемый список авторов")
    void shouldReturnExpectedAuthorList() {
        var authors = authorRepositoryJpa.findAll();

        assertThat(authors).isNotNull().hasSize(EXPECTED_AUTHORS_COUNT)
                .allMatch(author -> !author.getFullName().isEmpty())
                .containsOnlyOnce(testEntityManager.find(Author.class, EXISTING_AUTHOR_ID));
    }
}