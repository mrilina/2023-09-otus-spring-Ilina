package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;

import static ru.otus.hw.utils.QuestionUtils.DOT_SPACE_DELIMETER;

/**
 * Сервис тестирования.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    /**
     * Сервис ввода/вывода.
     */
    private final IOService ioService;

    /**
     * DAO (data access object).
     */
    private final QuestionDao questionDao;

    /**
     * Подготавливает вопросы и запускает тесты.
     */
    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");

        var questions = questionDao.findAll();
        for (var question : questions) {
            ioService.printLine(question.text());

            var answers = question.answers();
            for (int i = 0; i < answers.size(); i++) {
                Answer answer = answers.get(i);
                ioService.printLine((i + 1) + DOT_SPACE_DELIMETER + answer.text());
            }
            ioService.printLine("");
        }
    }
}
