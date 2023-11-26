package ru.otus.hw.exceptions;

/**
 * Исключительная ситуация, возникающая в случае не найденной сущности.
 *
 * @author Irina Ilina
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * Конструктор.
     *
     * @param message сообщение
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
