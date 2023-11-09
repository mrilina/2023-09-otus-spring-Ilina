package ru.otus.hw.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.hw.models.Author;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Genre;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Юнит тесты для репозитория обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@DisplayName("Репозиторий на основе Jdbc для работы с авторами ")
@JdbcTest
@Import({AuthorRepositoryJdbc.class})
class AuthorRepositoryJdbcTest {

    /**
     * Репозиторий обработки сведений об авторах..
     */
    @Autowired
    private AuthorRepositoryJdbc repositoryJdbc;

    /**
     * Список авторов.
     */
    private List<Author> dbAuthors;

    @BeforeEach
    void setUp() {
        dbAuthors = getDbAuthors();
    }

    @DisplayName("должен загружать автора по id")
    @ParameterizedTest
    @MethodSource("getDbAuthors")
    void shouldReturnCorrectAuthorById(Author author) {
        var actualAuthor = repositoryJdbc.findById(author.getId());

        assertThat(actualAuthor).isPresent()
                .get()
                .isEqualTo(author);
    }

    @DisplayName("должен загружать фио автора по id")
    @ParameterizedTest
    @MethodSource("getDbAuthors")
    void shouldReturnCorrectAuthorNameById() {
        var actualAuthor = repositoryJdbc.findById(2);

        assertNotNull(actualAuthor.get());
        assertEquals("Author_2", actualAuthor.get().getFullName());
    }

    @DisplayName("должен вернуть пустую запись автора по несуществующему id")
    @ParameterizedTest
    @MethodSource("getDbAuthors")
    void shouldReturnEmptyAuthorById() {
        var actualAuthor = repositoryJdbc.findById(32);
        assertEquals(Optional.empty(), actualAuthor);
    }


    @DisplayName("должен загружать список всех авторов")
    @Test
    void shouldReturnCorrectAuthorsList() {
        var actualAuthors = repositoryJdbc.findAll();
        var expectedAuthors = dbAuthors;

        assertEquals(3, actualAuthors.size());
        assertThat(actualAuthors).containsExactlyElementsOf(expectedAuthors);
        actualAuthors.forEach(System.out::println);
    }

    /**
     * Позготавливает сведения об авторах.
     *
     * @return список сведений об авторах
     */
    private static List<Author> getDbAuthors() {
        return IntStream.range(1, 4).boxed()
                .map(id -> new Author(id, "Author_" + id))
                .toList();
    }
}