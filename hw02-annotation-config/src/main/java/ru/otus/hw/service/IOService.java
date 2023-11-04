package ru.otus.hw.service;

/**
 * Интерфейс сервиса ввода/вывода.
 *
 * @author Irina Ilina
 */
public interface IOService {

    /**
     * Выводит строку.
     *
     * @param s строка
     */
    void printLine(String s);

    /**
     * Выводит форматированную строку.
     *
     * @param s    строка
     * @param args аргументы
     */
    void printFormattedLine(String s, Object... args);

    /**
     * Считывает строку.
     *
     * @return строка
     */
    String readString();

    /**
     * Считывает строку с подсказкой.
     *
     * @param prompt подсказка
     * @return строка
     */
    String readStringWithPrompt(String prompt);

    /**
     * Считывает целое число.
     *
     * @param min          минимальное значение
     * @param max          максимальное значение
     * @param errorMessage сообщение об ошибке
     * @return целое число
     */
    int readIntForRange(int min, int max, String errorMessage);

    /**
     * Считывает целое число с подсказкой.
     *
     * @param min          минимальное значение
     * @param max          максимальное значение
     * @param prompt       подсказка
     * @param errorMessage сообщение об ошибке
     * @return целое число
     */
    int readIntForRangeWithPrompt(int min, int max, String prompt, String errorMessage);
}
