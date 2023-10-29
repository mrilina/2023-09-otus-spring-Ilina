package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис по запуску процесса тестирования.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class TestRunnerServiceImpl implements TestRunnerService {

    /**
     * Сервис тестирования.
     */
    private final TestService testService;

    /**
     * Сервис обработки данных о студенте.
     */
    private final StudentService studentService;

    /**
     * Сервис обработки результатов тестирования.
     */
    private final ResultService resultService;

    /**
     * Запускает процесс тестирования.
     */
    @Override
    public void run() {
        var student = studentService.determineCurrentStudent();
        var testResult = testService.executeTestFor(student);
        resultService.showResult(testResult);
    }
}
