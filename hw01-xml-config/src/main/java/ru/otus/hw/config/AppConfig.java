package ru.otus.hw.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@Data
public class AppConfig implements TestFileNameProvider {

    /**
     * Имя файла с вопросами.
     */
    private String testFileName;

    @Override
    public String getTestFileName() {
        return testFileName;
    }
}
