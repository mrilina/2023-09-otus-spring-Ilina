package ru.otus.hw.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.hw.models.Author;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
class AuthorRepositoryTest {

    private static final int EXPECTED_AUTHORS_COUNT = 3;
    private static final long EXISTING_AUTHOR_ID = 1L;

    Author expectedAuthor1 = new Author("1", "Author_1");
    Author expectedAuthor2 = new Author("2", "Author_2");
    Author expectedAuthor3 = new Author("3", "Author_3");

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    @DisplayName("возвращать ожидаемого автора по его идентификатору")
    void shouldReturnExpectedAuthorById() {
        var expectedAuthor = mongoTemplate.findById(EXISTING_AUTHOR_ID, Author.class);
        assertEquals(expectedAuthor1, expectedAuthor);
    }

    @Test
    @DisplayName("возвращать ожидаемый список авторов")
    void shouldReturnExpectedAuthorList() {
        var authors = mongoTemplate.findAll(Author.class);
        assertEquals(EXPECTED_AUTHORS_COUNT, authors.size());
        assertThat(authors).containsExactlyInAnyOrder(expectedAuthor1, expectedAuthor2, expectedAuthor3);
    }
}