package ru.otus.hw.exception;

/**
 * Исключительная ситуация, возникающая в случае не найденной сущности.
 *
 * @author Irina Ilina
 */
public class DataNotFoundException extends RuntimeException {

    /**
     * Конструктор.
     *
     * @param message сообщение
     */
    public DataNotFoundException(String message) {
        super(message);
    }
}
