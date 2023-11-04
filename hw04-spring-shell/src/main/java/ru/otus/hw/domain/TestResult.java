package ru.otus.hw.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Результаты тестирования.
 *
 * @author Irina Ilina
 */
@Data
public class TestResult {

    /**
     * Сведения о студенте.
     */
    private final Student student;

    /**
     * Список вопросов с вариантами ответа.
     */
    private final List<Question> answeredQuestions;

    /**
     * Количество правильных ответов.
     */
    private int rightAnswersCount;

    /**
     * Конструктор.
     *
     * @param student сведения о студенте
     */
    public TestResult(Student student) {
        this.student = student;
        this.answeredQuestions = new ArrayList<>();
    }

    /**
     * Подсчитывается количество верных ответов.
     *
     * @param question      вопрос
     * @param isRightAnswer признак верного ответа
     */
    public void applyAnswer(Question question, boolean isRightAnswer) {
        answeredQuestions.add(question);
        if (isRightAnswer) {
            rightAnswersCount++;
        }
    }
}
