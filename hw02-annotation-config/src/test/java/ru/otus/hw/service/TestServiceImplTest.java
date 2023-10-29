package ru.otus.hw.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;
import ru.otus.hw.domain.Student;
import ru.otus.hw.exceptions.QuestionReadException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * Юнит тесты для сервиса TestService.
 *
 * @author Irina Ilina
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class TestServiceImplTest {

    /**
     * DAO вопросов.
     */
    @Mock
    QuestionDao questionDao;

    /**
     * Сервис ввода/вывода.
     */
    @Mock
    IOService ioService;

    /**
     * Сервис тестирования.
     */
    @InjectMocks
    TestServiceImpl testService;

    /**
     * Список вопросов.
     */
    List<Question> questions;

    /**
     * Сведения о студенте.
     */
    Student student;

    @BeforeAll
    void setUp() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("6", true));
        answers.add(new Answer("5", false));
        answers.add(new Answer("7", false));
        Question question1 = new Question("How many continents?", answers);
        answers = new ArrayList<>();
        answers.add(new Answer("8", true));
        answers.add(new Answer("7", false));
        answers.add(new Answer("6", false));
        Question question2 = new Question("How many days are in week?", answers);
        questions = Arrays.asList(question1, question2);
        student = new Student("Ivan", "Ivanov");
    }


    @DisplayName("Корректный вызов метода executeTestFor")
    @Test
    void testExecuteTestCorrect() {
        given(questionDao.findAll()).willReturn(questions);

        var testResult = testService.executeTestFor(new Student("Ivan", "Ivanov"));
        assertThat(testResult).isNotNull();
        assertEquals(2, testResult.getAnsweredQuestions().size());
    }

    @DisplayName("Exception при вызове метода executeTestFor")
    @Test
    void testExecuteTestException() {
        var testService = mock(TestServiceImpl.class);
        doThrow(QuestionReadException.class).when(testService).executeTestFor(any());
        assertThrows(QuestionReadException.class, () -> testService.executeTestFor(new Student("Ivan", "Ivanov")));
    }
}
