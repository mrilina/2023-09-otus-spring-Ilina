package ru.otus.hw.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LocalizedIOServiceImpl implements LocalizedIOService {

    /**
     * Сервис считывания сообщений пользователю.
     */
    @Qualifier("localizedMessagesServiceImpl")
    @NonNull
    private final LocalizedMessagesService localizedMessagesService;

    /**
     * Сервис ввода/вывода
     */
    @Qualifier("streamsIOService")
    @NonNull
    private final IOService ioService;

    /**
     * Выводит строку.
     *
     * @param s строка
     */
    @Override
    public void printLine(String s) {
        ioService.printLine(s);
    }

    /**
     * Выводит форматированную строку.
     *
     * @param s    строка
     * @param args аргументы
     */
    @Override
    public void printFormattedLine(String s, Object... args) {
        ioService.printFormattedLine(s, args);
    }

    /**
     * Считывает строку.
     *
     * @return строка
     */
    @Override
    public String readString() {
        return ioService.readString();
    }

    /**
     * Считывает строку с подсказкой.
     *
     * @param prompt подсказка
     * @return строка
     */
    @Override
    public String readStringWithPrompt(String prompt) {
        return ioService.readStringWithPrompt(prompt);
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
        return ioService.readIntForRange(min, max, errorMessage);
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
        return ioService.readIntForRangeWithPrompt(min, max, prompt, errorMessage);
    }

    /**
     * Выводит строку.
     *
     * @param code текстовый код
     */
    @Override
    public void printLineLocalized(String code) {
        ioService.printLine(localizedMessagesService.getMessage(code));
    }

    /**
     * Выводит форматированную строку.
     *
     * @param code текстовый код
     * @param args аргументы строки
     */
    @Override
    public void printFormattedLineLocalized(String code, Object... args) {
        ioService.printLine(localizedMessagesService.getMessage(code, args));
    }

    /**
     * Считывает строку с подсказкой.
     *
     * @param promptCode код подсказки
     * @return строка
     */
    @Override
    public String readStringWithPromptLocalized(String promptCode) {
        return ioService.readStringWithPrompt(localizedMessagesService.getMessage(promptCode));
    }

    /**
     * Считывает целое число.
     *
     * @param min              минимальное значение
     * @param max              максимальное значение
     * @param errorMessageCode код сообщения об ошибке
     * @return целое число
     */
    @Override
    public int readIntForRangeLocalized(int min, int max, String errorMessageCode) {
        return ioService.readIntForRange(min, max, localizedMessagesService.getMessage(errorMessageCode));
    }

    /**
     * Считывает целое число с подсказкой.
     *
     * @param min              минимальное значение
     * @param max              максимальное значение
     * @param promptCode       код подсказки
     * @param errorMessageCode код сообщения об ошибке
     * @return целое число
     */
    @Override
    public int readIntForRangeWithPromptLocalized(int min, int max, String promptCode, String errorMessageCode) {
        return ioService.readIntForRangeWithPrompt(min, max,
                localizedMessagesService.getMessage(promptCode),
                localizedMessagesService.getMessage(errorMessageCode)
        );
    }

    /**
     * Возвращает сообщение.
     *
     * @param code код сообщения
     * @param args аргументы
     * @return сообщение
     */
    @Override
    public String getMessage(String code, Object... args) {
        return localizedMessagesService.getMessage(code, args);
    }
}
