package ru.otus.hw.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.hw.models.Genre;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тест GenreRepository должен")
@DataJpaTest
class GenreRepositoryTest {

    private static final int EXPECTED_GENRES_COUNT = 6;

    private static final long EXISTING_GENRE_ID = 1L;

    private static final String UPDATED_GENRE_NAME = "Genre_01_updated";

    @Autowired
    private TestEntityManager testEntityManager;

    /**
     * Репозиторий обработки сведений о жанрах.
     */
    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("изменять имеющийся в БД жанр")
    void shouldUpdateGenre() {
        var genre = testEntityManager.find(Genre.class, EXISTING_GENRE_ID);
        genre.setName(UPDATED_GENRE_NAME);
        testEntityManager.flush();
        var updatedGenre = testEntityManager.find(Genre.class, EXISTING_GENRE_ID);

        assertThat(updatedGenre.getName()).isEqualTo(UPDATED_GENRE_NAME);
    }

    @Test
    @DisplayName("возвращать ожидаемый жанр по идентификатору")
    void shouldReturnExpectedGenreByIds() {
        var genres = genreRepository.findAllById(Set.of(1L, 3L));

        assertNotNull(genres);
        assertEquals(2, genres.size());
        assertEquals("Genre_3", genres.get(1).getName());
    }

    @Test
    @DisplayName("возвращать ожидаемый список жанров")
    void shouldReturnExpectedGenresList() {
        var genres = genreRepository.findAll();

        assertThat(genres).isNotNull().hasSize(EXPECTED_GENRES_COUNT)
                .allMatch(genre -> !genre.getName().isEmpty())
                .containsOnlyOnce(testEntityManager.find(Genre.class, EXISTING_GENRE_ID));
    }

}