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
}
