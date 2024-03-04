package ru.otus.hw.util;

/**
 * Сообщения об ошибках.
 *
 * @author Irina Ilina
 */
public class ErrorMessage {
    public static final String GENRE_NOT_FOUND = "Не найден жанр с идентификатором %s";

    public static final String AUTHOR_NOT_FOUND = "Не найден автор с идентификатором %s";

    public static final String BOOK_NOT_FOUND = "Не найдена книга с идентификатором %s";

    public static final String COMMENT_NOT_FOUND = "Не найден комментарий с идентификатором %s";

    public static final String USER_NOT_FOUND = "Не найден пользователь с именем %s";

    private ErrorMessage() {
    }
}
