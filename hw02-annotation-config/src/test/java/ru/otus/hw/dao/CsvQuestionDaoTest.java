package ru.otus.hw.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.hw.Application;
import ru.otus.hw.domain.Question;
import ru.otus.hw.exceptions.QuestionReadException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * Интеграционные тесты для класса CsvQuestionDao.
 *
 * @author Irina Ilina
 */
@DisplayName("Дао для работы с вопросами для тестирования")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class)
public class CsvQuestionDaoTest {

    /**
     * Интерфейс DAO.
     */
    @Autowired
    private QuestionDao csvQuestionDao;

    @DisplayName("Корректное получение списка вопросов и ответов")
    @Test
    public void findAllTest() {
        List<Question> questions = csvQuestionDao.findAll();
        assertNotNull(questions);
        assertEquals(5, questions.size());
        assertEquals(4, questions.get(2).answers().size());
        assertEquals("How many letters are in the English alphabet?", questions.get(1).text());
    }

    @DisplayName("Исключительная ситуация при получении списка вопросов и ответов")
    @Test
    public void findAllExceptionTest() {
        var dao = mock(QuestionDao.class);
        doThrow(QuestionReadException.class).when(dao).findAll();
        assertThrows(QuestionReadException.class, dao::findAll);
    }
}
