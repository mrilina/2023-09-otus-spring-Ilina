package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.config.TestConfig;
import ru.otus.hw.domain.TestResult;

/**
 * Сервис обработки результатов тестирования.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    /**
     * Конфигурация приложения.
     */
    private final TestConfig testConfig;

    /**
     * Сервис ввода/вывода
     */
    private final IOService ioService;

    /**
     * Показывает результаты тестирования.
     *
     * @param testResult результат тестирования
     */
    @Override
    public void showResult(TestResult testResult) {
        ioService.printLine("");
        ioService.printLine("Test results: ");
        ioService.printFormattedLine("Student: %s", testResult.getStudent().getFullName());
        ioService.printFormattedLine("Answered questions count: %d", testResult.getAnsweredQuestions().size());
        ioService.printFormattedLine("Right answers count: %d", testResult.getRightAnswersCount());

        if (testResult.getRightAnswersCount() >= testConfig.getRightAnswersCountToPass()) {
            ioService.printLine("Congratulations! You passed test!");
            return;
        }
        ioService.printLine("Sorry. You fail test.");
    }
}
