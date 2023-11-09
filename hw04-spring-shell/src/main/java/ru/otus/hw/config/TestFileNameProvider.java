package ru.otus.hw.config;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
public interface TestFileNameProvider {

    /**
     * Возвращает имя файла с вопросами.
     *
     * @return имя файла
     */
    String getTestFileName();
}
