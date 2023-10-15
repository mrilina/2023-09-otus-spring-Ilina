package ru.otus.hw.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;
import ru.otus.hw.domain.Student;
import ru.otus.hw.domain.TestResult;
import ru.otus.hw.exceptions.QuestionReadException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Юнит тесты для сервиса TestService.
 *
 * @author Irina Ilina
 */
public class TestServiceImplTest {

    /**
     * Результаты тестирования.
     */
    private static TestResult testResult;

    /**
     * Сведения о студенте.
     */
    @Mock
    private static Student student;

    @BeforeAll
    public static void init() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("6", true));
        answers.add(new Answer("5", false));
        answers.add(new Answer("7", false));
        Question question = new Question("How many continents?", answers);
        testResult = new TestResult(student);
        testResult.setRightAnswersCount(1);
        testResult.applyAnswer(question, true);
    }

    @DisplayName("Корректный вызов метода executeTestFor")
    @Test
    void testExecuteTestCorrect() {
        var testService = mock(TestServiceImpl.class);
        when(testService.executeTestFor(student)).thenReturn(testResult);
        assertEquals(2, testService.executeTestFor(student).getRightAnswersCount());
        assertEquals(1, testService.executeTestFor(student).getAnsweredQuestions().size());
    }

    @DisplayName("Exception при вызове метода executeTestFor")
    @Test
    void testExecuteTestException() {
        var testService = mock(TestServiceImpl.class);
        doThrow(QuestionReadException.class).when(testService).executeTestFor(student);
        assertThrows(QuestionReadException.class, () -> testService.executeTestFor(student));
    }
}
