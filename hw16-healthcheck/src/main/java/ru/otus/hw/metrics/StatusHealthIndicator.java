package ru.otus.hw.metrics;

import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.otus.hw.service.BookService;

/**
 * HealthCheck индикатор.
 *
 * @author Irina Ilina
 */
@Component
@AllArgsConstructor
public class StatusHealthIndicator implements HealthIndicator {

    /**
     * Сервис обработки сведений о книгах.
     */
    private final BookService bookService;

    @Override
    public Health health() {
        try {
            var books = bookService.getAll(Sort.unsorted());
            boolean isEmpty = books.isEmpty();
            if (isEmpty) {
                return Health
                        .status(Status.DOWN)
                        .withDetail("message", "There are no books in the library, check if everything is in order!")
                        .build();
            } else {
                return Health
                        .status(Status.UP)
                        .withDetail("message", "Everything is all right")
                        .build();
            }
        } catch (Exception e) {
            return Health
                    .status(Status.DOWN)
                    .withDetail("message", "Error retrieving data from database: " + e.getMessage())
                    .build();
        }
    }
}
