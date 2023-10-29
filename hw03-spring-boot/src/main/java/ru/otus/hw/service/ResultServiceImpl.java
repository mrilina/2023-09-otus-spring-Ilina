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
     * Сервис локализованного ввода/вывода.
     */
    private final LocalizedIOService ioService;

    /**
     * Показывает результаты тестирования.
     *
     * @param testResult результат тестирования
     */
    @Override
    public void showResult(TestResult testResult) {
        ioService.printLine("");
        ioService.printLineLocalized("ResultService.test.results");
        ioService.printFormattedLineLocalized("ResultService.student",
                testResult.getStudent().getFullName());
        ioService.printFormattedLineLocalized("ResultService.answered.questions.count",
                testResult.getAnsweredQuestions().size());
        ioService.printFormattedLineLocalized("ResultService.right.answers.count",
                testResult.getRightAnswersCount());

        if (testResult.getRightAnswersCount() >= testConfig.getRightAnswersCountToPass()) {
            ioService.printLineLocalized("ResultService.passed.test");
            return;
        }
        ioService.printLineLocalized("ResultService.fail.test");
    }
}
