package ru.otus.hw.client.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.hw.client.dto.BookDto;


import java.util.Collections;
import java.util.List;

/**
 * Клиент сервиса.
 *
 * @author Irina Ilina
 */
@FeignClient(value = "bookstore-service")
public interface BookServiceClient {

    @CircuitBreaker(name = "bookstore-service", fallbackMethod = "fallbackGetAll")
    @GetMapping("/api/books")
    List<BookDto> getAll(Sort sort);

    default List<BookDto> fallbackGetAll(Throwable throwable) {
        return Collections.emptyList();
    }
}

