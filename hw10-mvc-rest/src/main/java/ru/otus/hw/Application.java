package ru.otus.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
@SpringBootApplication
public class Application {

    /**
     * Основная программа.
     *
     * @param args входные параметры
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
