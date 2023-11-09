package ru.otus.hw.service;

/**
 * Интерфейс сервиса локализации.
 *
 * @author Irina Ilina
 */
public interface LocalizedIOService extends LocalizedMessagesService, IOService {

    /**
     * Выводит строку.
     *
     * @param code текстовый код
     */
    void printLineLocalized(String code);

    /**
     * Выводит форматированную строку.
     *
     * @param code текстовый код
     * @param args аргументы строки
     */
    void printFormattedLineLocalized(String code, Object... args);

    /**
     * Считывает строку с подсказкой.
     *
     * @param promptCode код подсказки
     * @return строка
     */
    String readStringWithPromptLocalized(String promptCode);

    /**
     * Считывает целое число.
     *
     * @param min              минимальное значение
     * @param max              максимальное значение
     * @param errorMessageCode код сообщения об ошибке
     * @return целое число
     */
    int readIntForRangeLocalized(int min, int max, String errorMessageCode);

    /**
     * Считывает целое число с подсказкой.
     *
     * @param min              минимальное значение
     * @param max              максимальное значение
     * @param promptCode       код подсказки
     * @param errorMessageCode код сообщения об ошибке
     * @return целое число
     */
    int readIntForRangeWithPromptLocalized(int min, int max, String promptCode, String errorMessageCode);
}
