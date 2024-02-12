package ru.fedbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.fedbon.service.ApplicationRunner;

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
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        ctx.getBean(ApplicationRunner.class).run();
    }
}
