package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.services.AuthorService;

import java.util.List;

/**
 * Команды для обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@ShellComponent
public class AuthorCommands {

    /**
     * Сервис обработки сведений об авторах.
     */
    private final AuthorService authorService;

    /**
     * Возвращает строковое отображение сведений обо всех авторах.
     *
     * @return строковое отображение сведений обо всех авторах
     */
    @ShellMethod(value = "Find all authors", key = "aa")
    public String getAllAuthors() {
        List<AuthorDto> authors = authorService.findAll();
        return authors.toString();
    }
}
