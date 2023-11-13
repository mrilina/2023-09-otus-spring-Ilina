package ru.otus.hw.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Comment;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Тест BookCommentRepositoryJpa должен")
@DataJpaTest
@Import(value = {CommentRepositoryJpa.class})
class CommentRepositoryJpaTest {

    private static final String NEW_COMMENT_TEXT = "Новый комментарий";

    private static final String UPDATED_COMMENT_TEXT = "Обновленный комментарий";

    private static final long TEST_BOOK_ID = 1;

    private static final long EXISTING_COMMENT_ID = 1;

    @Autowired
    private TestEntityManager testEntityManager;

    /**
     * Репозиторий обработки сведений о комментариях.
     */
    @Autowired
    private CommentRepositoryJpa commentRepositoryJpa;

    @DisplayName("добавлять комментарий в БД")
    @Test
    void shouldInsertBookComment() {
        var expectedComment = new Comment();
        expectedComment.setText(NEW_COMMENT_TEXT);
        var testBook = testEntityManager.find(Book.class, TEST_BOOK_ID);
        expectedComment.setBook(testBook);

        commentRepositoryJpa.save(expectedComment);
        assertThat(expectedComment.getId()).isGreaterThan(0);

        var actualComment = testEntityManager.find(Comment.class, expectedComment.getId());

        assertThat(actualComment)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(expectedComment);
    }

    @DisplayName("изменять имеющийся в БД комментарий без отключения объекта комментария от контекста")
    @Test
    void shouldUpdateBookComment() {
        var comment = testEntityManager.find(Comment.class, EXISTING_COMMENT_ID);
        comment.setText(UPDATED_COMMENT_TEXT);
        testEntityManager.flush();
        var updatedComment = testEntityManager.find(Comment.class, EXISTING_COMMENT_ID);

        assertThat(updatedComment.getText()).isEqualTo(UPDATED_COMMENT_TEXT);
    }

    @DisplayName("возвращать ожидаемые комментарии по идентификатору ниги")
    @Test
    void shouldReturnExpectedCommentByBookId() {
        var comments = commentRepositoryJpa.findAllByBookId(TEST_BOOK_ID);
        assertNotNull(comments);
        assertEquals(2, comments.size());
        assertEquals("Comment_2", comments.get(1).getText());
    }

    @DisplayName("удалять комментарии по идентификатору книги")
    @Test
    void shouldDeleteBookCommentById() {
        var comments = commentRepositoryJpa.findAllByBookId(TEST_BOOK_ID);
        assertNotNull(comments);
        commentRepositoryJpa.deleteByBookId(TEST_BOOK_ID);

        comments = commentRepositoryJpa.findAllByBookId(TEST_BOOK_ID);
        assertTrue(comments.isEmpty());
    }
}