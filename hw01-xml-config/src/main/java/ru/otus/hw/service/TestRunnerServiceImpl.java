package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;

/**
 * Сервис по запуску процесса тестирования.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
public class TestRunnerServiceImpl implements TestRunnerService {

    /**
     * Сервис тестирования.
     */
    private final TestService testService;

    /**
     * Запускает процесс тестирования.
     */
    @Override
    public void run() {
        testService.executeTest();
    }
}
