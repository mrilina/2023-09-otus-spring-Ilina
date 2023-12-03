package ru.otus.hw.db;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import ru.otus.hw.models.Author;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Genre;
import ru.otus.hw.models.Comment;

import java.util.List;

@ChangeLog
public class DatabaseChangelog {
    private Author readyAuthor1;

    private Author readyAuthor2;

    private Author readyAuthor3;

    private Genre readyGenre1;

    private Genre readyGenre2;

    private Genre readyGenre3;

    private Book readyBook;

    @ChangeSet(order = "001", id = "authors", author = "Author")
    public void addAuthors(MongockTemplate mongoTemplate) {
        Author author1 = new Author();
        author1.setFullName("Author_1");
        author1.setId("1");
        readyAuthor1 = mongoTemplate.save(author1);

        Author author2 = new Author();
        author2.setFullName("Author_2");
        author2.setId("2");
        readyAuthor2 = mongoTemplate.save(author2);

        Author author3 = new Author();
        author3.setFullName("Author_3");
        author3.setId("3");
        readyAuthor3 = mongoTemplate.save(author3);
    }

    @ChangeSet(order = "002", id = "genres", author = "Author")
    public void addGenres(MongockTemplate mongoTemplate) {
        Genre genre1 = new Genre();
        genre1.setName("Genre_1");
        genre1.setId("1");
        readyGenre1 = mongoTemplate.save(genre1);

        Genre genre2 = new Genre();
        genre2.setName("Genre_2");
        genre2.setId("2");
        readyGenre2 = mongoTemplate.save(genre2);

        Genre genre3 = new Genre();
        genre3.setName("Genre_3");
        genre3.setId("3");
        readyGenre3 = mongoTemplate.save(genre3);
    }

    @ChangeSet(order = "003", id = "books", author = "Author")
    public void addBooks(MongockTemplate mongoTemplate) {
        Book book = new Book();
        book.setTitle("Title_1");
        book.setAuthor(readyAuthor2);
        book.setGenres(List.of(readyGenre3));
        book.setId("1");
        readyBook = mongoTemplate.save(book);
    }

    @ChangeSet(order = "004", id = "comments", author = "Author")
    public void addComments(MongockTemplate mongoTemplate) {
        Comment comment = new Comment();
        comment.setText("Comment_1");
        comment.setBook(readyBook);
        comment.setId("1");

        mongoTemplate.save(comment);

        readyBook.setComments(List.of(comment));

        mongoTemplate.save(readyBook);
    }
}
