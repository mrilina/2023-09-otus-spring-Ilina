package ru.otus.hw.exceptions;

/**
 * Исключительная ситуация, возникающая при обработке вопросов и ответов.
 *
 * @author Irina Ilina
 */
public class QuestionReadException extends RuntimeException {

    /**
     * Конструктор.
     *
     * @param message сообщение
     * @param ex      исключение
     */
    public QuestionReadException(String message, Throwable ex) {
        super(message, ex);
    }
}
