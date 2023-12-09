package ru.otus.hw.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ru.otus.hw.mapper.BookMapper;
import ru.otus.hw.models.Author;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Genre;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.repositories.AuthorRepository;
import ru.otus.hw.repositories.BookRepository;
import ru.otus.hw.repositories.GenreRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
@DisplayName("Проверка работы сервиса книг")
@SpringBootTest(classes = {BookServiceImpl.class})
class BookServiceImplTest {

    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private GenreRepository genreRepository;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private GenreService genreService;

    static List<Book> expectedBooks = new ArrayList<>();
    static List<BookDto> expectedBooksDto = new ArrayList<>();

    @BeforeAll
    static void setExpectedBooks() {
        expectedBooks = List.of(
                new Book(0L, "TestBook1",
                        new Author(0L, "TestAuthor1"),
                        List.of(new Genre(0L, "TestGenre1")),
                        null),
                new Book(2L, "TestBook2",
                        new Author(2L, "TestAuthor2"),
                        List.of(new Genre(2L, "TestGenre2")),
                        null),
                new Book(3L, "TestBook3",
                        new Author(3L, "TestAuthor3"),
                        List.of(new Genre(3L, "TestGenre3")),
                        null)
        );

        expectedBooksDto = expectedBooks.stream()
                .map(new BookMapper()::toDto)
                .toList();
    }

    @DisplayName("должен загружать список всех книг")
    @Test
    void shouldReturnCorrectBooksList() {
        doReturn(expectedBooks).when(bookRepository).findAll();
        var actualBooks = bookService.findAll();

        assertEquals(3, actualBooks.size());
    }
}
