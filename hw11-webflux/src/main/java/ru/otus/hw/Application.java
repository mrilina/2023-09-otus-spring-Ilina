package ru.otus.hw;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
@EnableMongock
@EnableReactiveMongoRepositories
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
