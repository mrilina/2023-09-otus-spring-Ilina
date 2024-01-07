package ru.otus.hw.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.GenreDto;
import ru.otus.hw.service.AuthorService;
import ru.otus.hw.service.BookService;
import ru.otus.hw.service.GenreService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @MockBean
    private BookService bookService;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private GenreService genreService;

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnViewWithBookList() throws Exception {
        List<BookDto> dummyDtoBooks = getDummyDtoBooks();

        when(bookService.getAll()).thenReturn(dummyDtoBooks);

        mvc.perform(get("/book/list"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", dummyDtoBooks))
                .andExpect(view().name("book/list"));

        verify(bookService, times(1)).getAll();
    }

    @Test
    void shouldReturnViewForBookEdit() throws Exception {
        BookDto dummyDtoBook = getDummyDtoBooks().get(0);
        List<GenreDto> dummyDtoGenres = getDummyDtoGenres();
        List<AuthorDto> dummyDtoAuthors = getDummyDtoAuthors();

        when(bookService.getBookById(anyLong())).thenReturn(dummyDtoBook);
        when(authorService.getAll()).thenReturn(dummyDtoAuthors);
        when(genreService.getAll()).thenReturn(dummyDtoGenres);

        mvc.perform(get("/book").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attribute("book", dummyDtoBook))
                .andExpect(model().attributeExists("authors"))
                .andExpect(model().attribute("authors", dummyDtoAuthors))
                .andExpect(model().attributeExists("genres"))
                .andExpect(model().attribute("genres", dummyDtoGenres))
                .andExpect(view().name("book/edit"));

        verify(bookService, times(1)).getBookById(anyLong());
        verify(authorService, times(1)).getAll();
        verify(genreService, times(1)).getAll();
    }

    @Test
    void shouldReturnViewForBookCreate() throws Exception {
        List<GenreDto> dummyDtoGenres = getDummyDtoGenres();
        List<AuthorDto> dummyDtoAuthors = getDummyDtoAuthors();

        when(authorService.getAll()).thenReturn(dummyDtoAuthors);
        when(genreService.getAll()).thenReturn(dummyDtoGenres);

        mvc.perform(get("/book/create"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attributeExists("authors"))
                .andExpect(model().attribute("authors", dummyDtoAuthors))
                .andExpect(model().attributeExists("genres"))
                .andExpect(model().attribute("genres", dummyDtoGenres))
                .andExpect(view().name("book/create"));

        verify(authorService, times(1)).getAll();
        verify(genreService, times(1)).getAll();
    }

    @Test
    void shouldDeleteBookAndRedirectToBookList() throws Exception {
        long bookId = 1L;
        doNothing().when(bookService).deleteBookById(bookId);

        mvc.perform(post("/book/{id}", bookId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/book/list"));

        verify(bookService, times(1)).deleteBookById(bookId);
    }

    @Test
    void shouldCreateBookAndRedirectToBookList() throws Exception {
        BookDto dummyDtoBook = getDummyDtoBooks().get(0);
        when(bookService.saveBook(anyString(), anyString(), anyString())).thenReturn(dummyDtoBook);
        mvc.perform(post("/book").flashAttr("bookDto", dummyDtoBook))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/book/list"));
        verify(bookService, times(1)).saveBook(dummyDtoBook.getName(), dummyDtoBook.getAuthor(),
                dummyDtoBook.getGenre());
    }

    @Test
    void shouldUpdateBookAndRedirectToBookList() throws Exception {
        BookDto dummyDtoBook = getDummyDtoBooks().get(0);
        when(bookService.updateBook(any(Long.class), anyString(), anyString(), anyString())).thenReturn(dummyDtoBook);

        mvc.perform(post("/book")
                        .param("id", "1")
                        .flashAttr("bookDto", dummyDtoBook))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/book/list"));

        verify(bookService, times(1)).updateBook(dummyDtoBook.getId(), dummyDtoBook.getName(),
                dummyDtoBook.getAuthor(), dummyDtoBook.getGenre());
    }

    private List<BookDto> getDummyDtoBooks() {
        return List.of(
                new BookDto(1L, "Evgeniy Onegin",
                        getDummyDtoGenres().get(0).getName(),
                        getDummyDtoAuthors().get(0).getName()
                ),
                new BookDto(2L, "The Government Inspector",
                        getDummyDtoGenres().get(1).getName(),
                        getDummyDtoAuthors().get(1).getName()
                )
        );
    }

    private List<GenreDto> getDummyDtoGenres() {
        return List.of(
                new GenreDto(1L, "Novel"),
                new GenreDto(2L, "Play")
        );
    }

    private List<AuthorDto> getDummyDtoAuthors() {
        return List.of(
                new AuthorDto(1L, "Pushkin"),
                new AuthorDto(2L, "Gogol")
        );
    }

}