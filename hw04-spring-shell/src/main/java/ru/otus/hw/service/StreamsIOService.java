package ru.otus.hw.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Сервис ввода/вывода.
 *
 * @author Irina Ilina
 */
@Service
public class StreamsIOService implements IOService {

    /**
     * Количество попыток ответа.
     */
    private static final int MAX_ATTEMPTS = 10;

    /**
     * Сервис вывода на консоль.
     */
    private final PrintStream printStream;

    /**
     * Сканнер.
     */
    private final Scanner scanner;

    /**
     * Конструктор.
     *
     * @param printStream сервис вывода на консоль
     */
    public StreamsIOService(@Value("#{T(System).out}") PrintStream printStream,
                            @Value("#{T(System).in}") InputStream inputStream) {

        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
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

    /**
     * Считывает строку.
     *
     * @return строка
     */
    @Override
    public String readString() {
        return scanner.nextLine();
    }

    /**
     * Считывает строку с подсказкой.
     *
     * @param prompt подсказка
     * @return строка
     */
    @Override
    public String readStringWithPrompt(String prompt) {
        printLine(prompt);
        return scanner.nextLine();
    }

    /**
     * Считывает целое число.
     *
     * @param min          минимальное значение
     * @param max          максимальное значение
     * @param errorMessage сообщение об ошибке
     * @return целое число
     */
    @Override
    public int readIntForRange(int min, int max, String errorMessage) {
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            try {
                var stringValue = scanner.nextLine();
                int intValue = Integer.parseInt(stringValue);
                if (intValue < min || intValue > max) {
                    throw new IllegalArgumentException();
                }
                return intValue;
            } catch (IllegalArgumentException e) {
                printLine(errorMessage);
            }
        }
        throw new IllegalArgumentException("Error during reading int value");
    }

    /**
     * Считывает целое число с подсказкой.
     *
     * @param min          минимальное значение
     * @param max          максимальное значение
     * @param prompt       подсказка
     * @param errorMessage сообщение об ошибке
     * @return целое число
     */
    @Override
    public int readIntForRangeWithPrompt(int min, int max, String prompt, String errorMessage) {
        printLine(prompt);
        return readIntForRange(min, max, errorMessage);
    }
}
