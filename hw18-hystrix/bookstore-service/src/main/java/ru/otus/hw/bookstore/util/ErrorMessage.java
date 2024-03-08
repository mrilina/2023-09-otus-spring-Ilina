package ru.otus.hw.bookstore.util;

/**
 * Сообщения об ошибках.
 *
 * @author Irina Ilina
 */
public class ErrorMessage {
    public static final String GENRE_NOT_FOUND = "Не найден жанр с идентификатором %s";

    public static final String AUTHOR_NOT_FOUND = "Не найден автор с идентификатором %s";

    public static final String BOOK_NOT_FOUND = "Не найдена книга с идентификатором %s";

    private ErrorMessage() {
    }
}
