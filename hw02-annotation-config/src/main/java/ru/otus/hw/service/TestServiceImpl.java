package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Student;
import ru.otus.hw.domain.TestResult;

import java.util.List;

/**
 * Сервис тестирования.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    /**
     * Сервис ввода/вывода.
     */
    private final IOService ioService;

    /**
     * Подготавливает вопросы и запускает тесты.
     */
    private final QuestionDao questionDao;

    /**
     * Подготавливает вопросы и запускает тесты.
     *
     * @param student сведения о студенте
     * @return результат тестирования
     */

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        for (var question : questions) {
            ioService.printLine(question.text());
            var answers = question.answers();
            for (Answer answer : answers) {
                ioService.printLine(answer.text());
            }
            ioService.printLine("");
            String studentAnswer = ioService.readStringWithPrompt("Please give your answer");
            ioService.printLine("");
            var isAnswerValid = checkAnswer(answers, studentAnswer);
            testResult.applyAnswer(question, isAnswerValid);
        }
        return testResult;
    }

    /**
     * Определяет правильность ответа на вопрос.
     *
     * @param answers       ответы на вопрос
     * @param studentAnswer ответ студента
     * @return признак правильности ответа на вопрос
     */
    private boolean checkAnswer(List<Answer> answers, String studentAnswer) {
        var isAnswerValid = false;
        int answerCounter = 0;
        while (!isAnswerValid && answerCounter < answers.size()) {
            Answer answer = answers.get(answerCounter);
            if (answer.text().equalsIgnoreCase(studentAnswer) && answer.isCorrect()) {
                isAnswerValid = true;
            }
            answerCounter++;
        }
        return isAnswerValid;
    }
}
