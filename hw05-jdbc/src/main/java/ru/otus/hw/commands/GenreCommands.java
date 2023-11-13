package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.converters.GenreConverter;
import ru.otus.hw.services.GenreService;

import java.util.stream.Collectors;

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
     * Конвертер сведений о жанре.
     */
    private final GenreConverter genreConverter;

    /**
     * Возвращает строковое отображение сведений обо всех жанрах.
     *
     * @return строковое отображение сведений обо всех жанрах
     */
    @ShellMethod(value = "Find all genres", key = "ag")
    public String findAllGenres() {
        return genreService.findAll().stream()
                .map(genreConverter::genreToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }
}
