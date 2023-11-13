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
import ru.otus.hw.models.Genre;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Юнит тесты для репозитория обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@DisplayName("Репозиторий на основе Jdbc для работы с жанрами ")
@JdbcTest
@Import({GenreRepositoryJdbc.class})
class GenreRepositoryJdbcTest {

    /**
     * Репозиторий обработки сведений о жанрах.
     */
    @Autowired
    private GenreRepositoryJdbc repositoryJdbc;

    /**
     * Список жанров.
     */
    private List<Genre> dbGenres;

    @BeforeEach
    void setUp() {
        dbGenres = getDbGenres();
    }

    @DisplayName("должен загружать список жанров по id")
    @ParameterizedTest
    @MethodSource("getDbGenres")
    void shouldReturnCorrectGenreById() {
        var genres = repositoryJdbc.findAllByIds(Arrays.asList(2L));

        assertNotNull(genres);
        assertEquals(1, genres.size());
        assertEquals("Genre_2", genres.get(0).getName());
    }

    @DisplayName("должен загружать жанры по id")
    @ParameterizedTest
    @MethodSource("getDbGenres")
    void shouldReturnCorrectGenresByIds() {
        var genres = repositoryJdbc.findAllByIds(Arrays.asList(2L, 5L));

        assertNotNull(genres);
        assertEquals(2, genres.size());
    }

    @DisplayName("должен вернуть пустой список жанров несуществующему id")
    @ParameterizedTest
    @MethodSource("getDbGenres")
    void shouldReturnEmptyGenresByIds() {
        var genres = repositoryJdbc.findAllByIds(Arrays.asList(23L, 54L));
        assertEquals(0, genres.size());
    }


    @DisplayName("должен загружать список всех жанров")
    @Test
    void shouldReturnCorrectGenresList() {
        var actualGenres = repositoryJdbc.findAll();
        var expectedGenres = dbGenres;

        assertNotNull(actualGenres);
        assertEquals(6, actualGenres.size());
        assertThat(actualGenres).containsExactlyElementsOf(expectedGenres);
        actualGenres.forEach(System.out::println);
    }

    /**
     * Подготавливает список жанров.
     *
     * @return список жанров
     */
    private static List<Genre> getDbGenres() {
        return IntStream.range(1, 7).boxed()
                .map(id -> new Genre(id, "Genre_" + id))
                .toList();
    }
}