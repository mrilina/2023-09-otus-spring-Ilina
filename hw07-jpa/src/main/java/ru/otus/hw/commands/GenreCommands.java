package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.services.GenreService;

/**
 * Команды для обработки сведений о жанре.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@ShellComponent
public class GenreCommands {

    /**
     * Сервис обработки сведений о жанрах.
     */
    private final GenreService genreService;

    /**
     * Возвращает строковое отображение сведений обо всех жанрах.
     *
     * @return строковое отображение сведений обо всех жанрах
     */
    @ShellMethod(value = "Find all genres", key = "ag")
    public String findAllGenres() {
        return genreService.getAll().toString();
    }

}
