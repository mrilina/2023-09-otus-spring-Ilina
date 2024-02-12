package ru.fedbon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.fedbon.domain.Caterpillar;

import java.util.List;

/**
 * Запуск процесса трансформации из гусеницы в бабочку.
 *
 * @author Irina Ilina
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationRunner {

    private final ButterflyTransformGateway butterflyTransformGateway;

    public void run() {
        var butterflies = butterflyTransformGateway.process(
                List.of(new Caterpillar("YKSI"),
                        new Caterpillar("KAKSI"),
                        new Caterpillar("KOLME"),
                        new Caterpillar("NELJA"),
                        new Caterpillar("VIISI"))
        );
        log.info(butterflies.toString());
    }

}
