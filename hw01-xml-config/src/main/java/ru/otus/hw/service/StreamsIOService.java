package ru.otus.hw.service;

import java.io.PrintStream;

/**
 * Сервис ввода/вывода.
 *
 * @author Irina Ilina
 */
public class StreamsIOService implements IOService {

    /**
     * Сервис вывода на консоль.
     */
    private final PrintStream printStream;

    /**
     * Конструктор.
     *
     * @param printStream сервис вывода на консоль
     */
    public StreamsIOService(PrintStream printStream) {

        this.printStream = printStream;
    }

    /**
     * Выводит строку.
     *
     * @param s строка
     */
    @Override
    public void printLine(String s) {
        printStream.println(s);
    }

    /**
     * Выводит форматированную строку.
     *
     * @param s    строка
     * @param args аргументы
     */
    @Override
    public void printFormattedLine(String s, Object... args) {
        printStream.printf(s + "%n", args);
    }
}
