package ru.otus.hw.service;

/**
 * Интерфейс сервиса считывания сообщений пользователю.
 *
 * @author Irina Ilina
 */
public interface LocalizedMessagesService {

    /**
     * Возвращает сообщение.
     *
     * @param code код сообщения
     * @param args аргументы
     * @return сообщение
     */
    String getMessage(String code, Object... args);
}
