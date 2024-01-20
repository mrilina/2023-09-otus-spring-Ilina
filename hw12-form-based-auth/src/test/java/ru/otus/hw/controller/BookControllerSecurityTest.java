package ru.otus.hw.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw.security.SecurityConfig;
import ru.otus.hw.security.UserDetailsServiceImpl;
import ru.otus.hw.service.AuthorService;
import ru.otus.hw.service.BookService;
import ru.otus.hw.service.CommentService;
import ru.otus.hw.service.GenreService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @DisplayName("создание книги с авторизацией должно вернуть успешный код состояния")
    @Test
    @WithMockUser(username = "testUser")
    void testCreateBookAuthorized() throws Exception {
        mockMvc.perform(post("/create")
                        .param("title", "New Book Title")
                        .param("genreId", "1")
                        .param("authorId", "1"))
                .andExpect(redirectedUrl("/books"));
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

    @DisplayName("обновление книги с авторизацией должно вернуть успешный код состояния")
    @Test
    @WithMockUser(username = "testUser")
    void testUpdateBookAuthorized() throws Exception {
        mockMvc.perform(post("/update")
                        .param("id", "1")
                        .param("title", "Updated Book Title")
                        .param("genreId", "1")
                        .param("authorId", "1"))
                .andExpect(redirectedUrl("/books"));
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
        mockMvc.perform(get("/books-by-author").param("id", "1"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @DisplayName("доступ к странице книг по жанру без авторизации должен вернуть код состояния 302 и страницу авторизации")
    @Test
    void testBooksByGenrePageUnauthorized() throws Exception {
        mockMvc.perform(get("/books-by-genre").param("id", "1"))
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