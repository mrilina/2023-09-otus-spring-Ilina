package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.converters.AuthorConverter;
import ru.otus.hw.services.AuthorService;

import java.util.stream.Collectors;

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
     * Конвертер сведений об авторе.
     */
    private final AuthorConverter authorConverter;

    /**
     * Возвращает строковое отображение сведений обо всех авторах.
     *
     * @return строковое отображение сведений обо всех авторах
     */
    @ShellMethod(value = "Find all authors", key = "aa")
    public String findAllAuthors() {
        return authorService.findAll().stream()
                .map(authorConverter::authorToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }
}
