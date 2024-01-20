package ru.otus.hw.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw.dto.BookCreateDto;
import ru.otus.hw.dto.BookUpdateDto;
import ru.otus.hw.security.SecurityConfig;
import ru.otus.hw.security.UserDetailsServiceImpl;
import ru.otus.hw.service.AuthorService;
import ru.otus.hw.service.BookService;
import ru.otus.hw.service.CommentService;
import ru.otus.hw.service.GenreService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("Тест BookControllerSecurityTest проверяет, что ")
@WebMvcTest(controllers = {BookController.class})
@Import(SecurityConfig.class)
class BookControllerSecurityTest {

    @MockBean
    private BookService bookService;

    @MockBean
    private CommentService commentService;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private GenreService genreService;

    @MockBean
    private UserDetailsServiceImpl userService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("доступ к странице всех книг для авторизованного пользователя (ROLE_USER) должен вернуть код состояния 200")
    @Test
    @WithMockUser(roles = "USER")
    void testListAllBooksPageAuthorizedAsUser() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
    }

    @DisplayName("создание книги с ролью ADMIN должно вернуть код состояния 200")
    @Test
    @WithMockUser(roles = "ADMIN")
    void testCreateBookAuthorizedAsAdmin() throws Exception {
        var bookCreateDto = new BookCreateDto();
        bookCreateDto.setTitle("New Book Title");
        bookCreateDto.setGenreId(1L);
        bookCreateDto.setAuthorId(1L);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bookCreateDto)))
                .andExpect(status().isOk());
    }

    @DisplayName("доступ к странице редактирования с ролью ADMIN должен вернуть код состояния 200")
    @Test
    @WithMockUser(roles = "ADMIN")
    void testUpdateBookAuthorizedAsAdmin() throws Exception {
        var bookUpdateDto = new BookUpdateDto();
        bookUpdateDto.setId(1L);
        bookUpdateDto.setTitle("Updated Book Title");
        bookUpdateDto.setGenreId(1L);
        bookUpdateDto.setAuthorId(1L);

        mockMvc.perform(put("/api/books/{id}", bookUpdateDto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bookUpdateDto)))
                .andExpect(status().isOk());
    }

    @DisplayName("удаление книги с ролью ADMIN должно вернуть код состояния 200")
    @Test
    @WithMockUser(roles = "ADMIN")
    void testDeleteBookAuthorizedAsAdmin() throws Exception {
        mockMvc.perform(delete("/api/books/{id}",1))
                .andExpect(status().isOk());
    }

    @DisplayName("неавторизованный доступ к странице всех книг должен вернуть код состояния 302 и страницу авторизации")
    @Test
    @WithAnonymousUser
    void testListAllBooksPageUnauthorized() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @DisplayName("создание книги без авторизации должно вернуть код состояния 302 и страницу авторизации")
    @Test
    @WithAnonymousUser
    void testCreateBookUnauthorized() throws Exception {
        mockMvc.perform(post("/create")
                        .param("title", "New Book Title")
                        .param("genreId", "1")
                        .param("authorId", "1"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @DisplayName("обновление книги без авторизации должно вернуть код состояния 302 и страницу авторизации")
    @Test
    void testUpdateBookUnauthorized() throws Exception {
        mockMvc.perform(post("/update")
                        .param("id", "1")
                        .param("title", "Updated Book Title")
                        .param("genreId", "1")
                        .param("authorId", "1"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @DisplayName("доступ к странице редактирования без авторизации должен вернуть код состояния 302 и страницу авторизации")
    @Test
    void testEditPageAccessUnauthorized() throws Exception {
        mockMvc.perform(get("/edit").param("id", "1"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @DisplayName("доступ к странице книг автора без авторизации должен вернуть код состояния 302 и страницу авторизации")
    @Test
    void testBooksByAuthorPageUnauthorized() throws Exception {
        mockMvc.perform(get("/booksByAuthor").param("id", "1"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @DisplayName("доступ к странице книг по жанру без авторизации должен вернуть код состояния 302 и страницу авторизации")
    @Test
    void testBooksByGenrePageUnauthorized() throws Exception {
        mockMvc.perform(get("/booksByGenre").param("id", "1"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @DisplayName("удаление книги без авторизации должно вернуть код состояния 302 и страницу авторизации")
    @Test
    void testDeleteBookUnauthorized() throws Exception {
        mockMvc.perform(post("/delete").param("id", "1"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @DisplayName("удаление всех книг без авторизации должно вернуть код состояния 302 и страницу авторизации")
    @Test
    void testDeleteAllBooksUnauthorized() throws Exception {
        mockMvc.perform(post("/delete-all"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }
}