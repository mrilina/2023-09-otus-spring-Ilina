package ru.otus.hw.service;

import ru.otus.hw.domain.TestResult;

/**
 * Интерфейс обработки результатов тестирования.
 *
 * @author Irina Ilina
 */
public interface ResultService {

    /**
     * Показывает результаты тестирования.
     *
     * @param testResult результат тестирования
     */
    void showResult(TestResult testResult);
}
