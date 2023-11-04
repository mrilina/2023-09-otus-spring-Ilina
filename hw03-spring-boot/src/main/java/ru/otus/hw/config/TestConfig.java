package ru.otus.hw.config;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
public interface TestConfig {

    /**
     * Возвращает количество правильных ответов, чтобы тест считался пройденным.
     *
     * @return количество правильных ответов
     */
    int getRightAnswersCountToPass();
}
