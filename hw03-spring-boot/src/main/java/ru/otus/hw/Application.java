package ru.otus.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.otus.hw.config.AppConfig;
import ru.otus.hw.service.TestRunnerService;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
@EnableConfigurationProperties(AppConfig.class)
@SpringBootApplication
public class Application {

    /**
     * Основная программа.
     *
     * @param args входные параметры
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        var testRunnerService = context.getBean(TestRunnerService.class);
        testRunnerService.run();
    }
}