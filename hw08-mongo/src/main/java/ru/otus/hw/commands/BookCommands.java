package ru.otus.hw.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw.services.BookService;

import java.util.List;

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
     * Возвращает строковое отображение сведений обо всех книгах.
     *
     * @return строковое отображение сведений обо всех книгах
     */
    @ShellMethod(value = "Find all books", key = "ab")
    public String findAllBooks() {
        return bookService.findAll().toString();
    }

    /**
     * Возвращает строковое отображение сведений о книге.
     *
     * @param id идентификатор книги
     * @return строковое отображение сведений о книге
     */
    @ShellMethod(value = "Find book by id", key = "bbid")
    public String findBookById(String id) {
        return bookService.findBookById(id).toString();
    }

    /**
     * Сохраняет сведения о книге.
     *
     * @param title     наименование книги
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов сведений о жанрах
     */
    @ShellMethod(value = "Insert book", key = "bins")
    public void insertBook(String title, String authorId, List<String> genresIds) {
        bookService.insert(title, authorId, genresIds);
    }

    /**
     * Обновляет сведения о книге.
     *
     * @param id        идентификатор книги
     * @param title     наименование книги
     * @param authorId  идентификатор сведений об авторе
     * @param genresIds список идентификаторов сведений о жанрах
     */
    @ShellMethod(value = "Update book", key = "bupd")
    public void updateBook(String id, String title, String authorId, List<String> genresIds) {
        bookService.update(id, title, authorId, genresIds);
    }

    /**
     * Производит удаление сведений о книге по идентификатору.
     *
     * @param id идентификатор книги
     */
    @ShellMethod(value = "Delete book by id", key = "bdel")
    public void deleteBookById(@ShellOption String id) {
        bookService.deleteBookById(id);
    }

}
