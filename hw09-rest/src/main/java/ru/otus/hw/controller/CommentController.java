package ru.otus.hw.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.service.CommentService;

import java.util.List;

/**
 * Контроллер для обработки комментариев.
 *
 * @author Irina Ilina
 */
@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/list/{id}")
    public String commentList(@PathVariable long id, Model model) {
        List<CommentDto> commentDtoList = commentService.getByBookId(id);
        model.addAttribute("comments", commentDtoList);
        return "comment/list";
    }

}
