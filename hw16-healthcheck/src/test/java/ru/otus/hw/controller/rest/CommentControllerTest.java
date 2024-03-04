package ru.otus.hw.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw.controller.CommentController;
import ru.otus.hw.mapper.CommentMapper;
import ru.otus.hw.domain.Author;
import ru.otus.hw.domain.Book;
import ru.otus.hw.domain.Comment;
import ru.otus.hw.domain.Genre;
import ru.otus.hw.service.CommentService;


import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Тест CommentController должен")
@WebMvcTest(controllers = {CommentController.class})
class CommentControllerTest {

    @MockBean
    private CommentService commentService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("возвращать корректный список комментариев для конкретной книги")
    @Test
    void shouldReturnCorrectCommentsListByBookId() throws Exception {
        var expectedBook = new Book(1L, "firstBook",
                new Author(1L, "firstAuthor"),
                new Genre(1L, "firstGenre"),
                null);
        var expectedComments = List.of(
                new Comment(1L, "firstComment", expectedBook),
                new Comment(1L, "secondComment", expectedBook)
        );

        var expectedCommentsDto = expectedComments.stream()
                .map(CommentMapper::mapCommentToDto)
                .toList();

        given(commentService.getAllByBookId(expectedBook.getId())).willReturn(expectedCommentsDto);
        var expectedResult = expectedComments.stream()
                .map(CommentMapper::mapCommentToDto)
                .collect(Collectors.toList());

        mockMvc.perform(get("/api/books/{id}/comments", expectedBook.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
        verify(commentService, times(1)).getAllByBookId(expectedBook.getId());
    }
}