package ru.otus.hw.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ClientServiceApplication {

    /**
     * Основная программа.
     *
     * @param args входные параметры
     */
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);

        System.out.println("http://localhost:8081");
    }
}
