package ru.otus.hw.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.Locale;
import java.util.Map;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
@Data
@ConfigurationProperties(prefix = "test")
public class AppConfig implements TestConfig, TestFileNameProvider, LocaleConfig {

    /**
     * Количество верно отвеченных вопросов для прохождения тестирования.
     */
    private final int rightAnswersCountToPass;

    /**
     * Локаль.
     */
    private final Locale locale;

    /**
     * Файлы с вопросами и вариантами ответов для разных локалей.
     */
    private final Map<String, String> fileNameByLocaleTag;

    /**
     * Конструктор.
     *
     * @param rightAnswersCountToPass количество верно отвеченных вопросов для прохождения тестирования
     * @param locale                  локаль
     * @param fileNameByLocaleTag     файлы с вопросами и вариантами ответов для разных локалей
     */
    @ConstructorBinding
    public AppConfig(int rightAnswersCountToPass, String locale, Map<String, String> fileNameByLocaleTag) {
        this.rightAnswersCountToPass = rightAnswersCountToPass;
        this.locale = Locale.forLanguageTag(locale);
        this.fileNameByLocaleTag = fileNameByLocaleTag;
    }

    @Override
    public int getRightAnswersCountToPass() {
        return rightAnswersCountToPass;
    }

    @Override
    public String getTestFileName() {
        return fileNameByLocaleTag.get(locale.toLanguageTag());
    }
}
