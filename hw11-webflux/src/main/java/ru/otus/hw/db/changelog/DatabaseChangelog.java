package ru.otus.hw.db.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import com.mongodb.client.MongoDatabase;
import ru.otus.hw.domain.Author;
import ru.otus.hw.domain.Book;
import ru.otus.hw.domain.Comment;
import ru.otus.hw.domain.Genre;

import java.util.List;

@ChangeLog(order = "001")
public class DatabaseChangelog {

    private final Author author1 = new Author("65721548456e6853487f2f31", "Author_1");

    private final Author author2 = new Author("65721548456e6853487f2f32", "Author_2");

    private final Author author3 = new Author("65721548456e6853487f2f33", "Author_3");

    private final Genre genre1 = new Genre("65721548456e6853487f2f21", "Genre_1");

    private final Genre genre2 = new Genre("65721548456e6853487f2f22", "Genre_2");

    private final Genre genre3 = new Genre("65721548456e6853487f2f23", "Genre_3");

    private final Book book1 = new Book("65721548456e6853487f2f41", "Title_1", genre1, author1, null);

    private final Book book2 = new Book("65721548456e6853487f2f42", "Title_2", genre1, author3, null);

    private final Book book3 = new Book("65721548456e6853487f2f43", "Title_3", genre3, author3, null);

    private final Comment comment1 = new Comment("65721548456e6853487f2f51", "Comment1", book1);

    private final Comment comment2 = new Comment("65721548456e6853487f2f52", "Comment2", book2);

    private final Comment comment3 = new Comment("65721548456e6853487f2f53", "Comment3", book3);

    private final Comment comment4 = new Comment("65721548456e6853487f2f54", "Comment4", book3);


    @ChangeSet(order = "000", id = "dropDB", author = "author", runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "001", id = "insertAuthors", author = "author")
    public void insertAuthors(MongockTemplate mongockTemplate) {
        mongockTemplate.insertAll(List.of(author1, author2, author3));
    }

    @ChangeSet(order = "002", id = "insertGenres", author = "author")
    public void insertGenres(MongockTemplate mongockTemplate) {
        mongockTemplate.insertAll(List.of(genre1, genre2, genre3));
    }

    @ChangeSet(order = "003", id = "insertBook", author = "author")
    public void insertBooks(MongockTemplate mongockTemplate) {
        mongockTemplate.insertAll(List.of(book1, book2, book3));
    }

    @ChangeSet(order = "004", id = "insertComment", author = "author")
    public void insertComments(MongockTemplate mongockTemplate) {
        mongockTemplate.insertAll(List.of(comment1, comment2, comment3, comment4));
    }
}
