package ru.otus.hw.repositories;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.otus.hw.models.Author;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Юнит тесты для репозитория обработки сведений о книгах.
 *
 * @author Irina Ilina
 */
@DataMongoTest
class BookRepositoryTest {

    private static final int EXPECTED_NUMBER_OF_BOOKS = 9;
    private static final Long FIRST_BOOK_ID = 1L;

    private static final String NEW_BOOK_TITLE = "Book_4";

    private static final Long TEST_GENRE_ID = 1L;

    private static final Long TEST_AUTHOR_ID = 1L;

    private static final Long EXISTING_BOOK_ID = 1L;

    private static final String UPDATED_BOOK_TITLE = "Book_4_updated";

    @Autowired
    MongoTemplate mongoTemplate;

    @DisplayName("загружать книгу по id")
    @Test
    void shouldReturnCorrectBookById() {
        val optionalActualBook = mongoTemplate.findById(FIRST_BOOK_ID, Book.class);

        assertEquals("Book_4_updated", optionalActualBook.getTitle());
    }

    @DisplayName("удалять книгу по id")
    @Test
    void shouldDeleteEmployeesWithoutDepartment() {
        var existingBook = mongoTemplate.findById(1L, Book.class);
        mongoTemplate.remove(existingBook, "existingBook");
    }

    @Test
    @DisplayName("добавлять книгу в БД")
    void shouldInsertBook() {
        var newBook = new Book();
        newBook.setTitle(NEW_BOOK_TITLE);
        var testGenre = mongoTemplate.findById(TEST_GENRE_ID, Genre.class);
        newBook.setGenres(List.of(testGenre));
        var testAuthor = mongoTemplate.findById(TEST_AUTHOR_ID, Author.class);
        newBook.setAuthor(testAuthor);

        var expectedBook = mongoTemplate.insert(newBook);
        assertThat(expectedBook).isNotNull();
        assertThat(expectedBook.getId()).isGreaterThan("0");
    }

    @Test
    @DisplayName("изменять имеющуюся в БД книгу")
    void shouldUpdateBook() {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is("Title_1"));
        Update update = new Update();
        update.set("title", UPDATED_BOOK_TITLE);
        mongoTemplate.upsert(query, update, Book.class);

        var updatedBook = mongoTemplate.findById(EXISTING_BOOK_ID, Book.class);
        assertThat(updatedBook.getTitle()).isEqualTo(UPDATED_BOOK_TITLE);
    }
}