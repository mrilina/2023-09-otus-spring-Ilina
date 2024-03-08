package ru.otus.hw.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BookStoreServiceApplication {

    /**
     * Основная программа.
     *
     * @param args входные параметры
     */
    public static void main(String[] args) {
        SpringApplication.run(BookStoreServiceApplication.class, args);
    }
}
