package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.converters.BookConverter;
import ru.otus.hw.services.BookService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Команды для обработки сведений о книге.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@ShellComponent
public class BookCommands {

    /**
     * Сервис обработки сведений о книгах.
     */
    private final BookService bookService;

    /**
     * Конвертер сведений о книге.
     */
    private final BookConverter bookConverter;

    /**
     * Возвращает строковое отображение сведений обо всех книгах.
     *
     * @return строковое отображение сведений обо всех книгах
     */
    @ShellMethod(value = "Find all books", key = "ab")
    public String findAllBooks() {
        return bookService.findAll().stream()
                .map(bookConverter::bookToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }

    /**
     * Возвращает строковое отображение сведений о книге.
     *
     * @param id идентификатор книги
     * @return строковое отображение сведений о книге
     */
    @ShellMethod(value = "Find book by id", key = "bbid")
    public String findBookById(long id) {
        return bookService.findById(id)
                .map(bookConverter::bookToString)
                .orElse("Book with id %d not found".formatted(id));
    }

    /**
     * Сохраняет сведения о книге.
     *
     * @param title     наименование книги
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов сведений о жанрах
     * @return строковое отображение сведений о книге
     * <p>
     * bins aaaaaaaaaaaaa 1 1,6//bins aaaaaaaaaaaaa 1 1,6
     */
    @ShellMethod(value = "Insert book", key = "bins")
    public String insertBook(String title, long authorId, List<Long> genresIds) {
        var savedBook = bookService.insert(title, authorId, genresIds);
        return bookConverter.bookToString(savedBook);
    }

    /**
     * Обновляет сведения о книге.
     *
     * @param id        идентификатор книги
     * @param title     наименование книги
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов сведений о жанрах
     * @return строковое отображение сведений о книге
     * <p>
     * bupd 4 dfasdfasdfasd 3 2,5
     */
    @ShellMethod(value = "Update book", key = "bupd")
    public String updateBook(long id, String title, long authorId, List<Long> genresIds) {
        var savedBook = bookService.update(id, title, authorId, genresIds);
        return bookConverter.bookToString(savedBook);
    }

    /**
     * Производит удаление сведений о книге по идентификатору.
     *
     * @param id идентификатор книги
     */
    @ShellMethod(value = "Delete book by id", key = "bdel")
    public void updateBook(long id) {
        bookService.deleteById(id);
    }
}
