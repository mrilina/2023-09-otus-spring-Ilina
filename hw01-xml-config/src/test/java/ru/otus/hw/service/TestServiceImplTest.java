package ru.otus.hw.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw.exceptions.QuestionReadException;
import ru.otus.hw.service.TestServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Юнит тесты TestService.
 *
 * @author Irina Ilina
 */
public class TestServiceImplTest {

    @DisplayName("Корректный вызов метода executeTest")
    @Test
    void testExecuteTestCorrect() {
        var testService = mock(TestServiceImpl.class);
        doNothing().when(testService).executeTest();
        testService.executeTest();
        verify(testService, times(1)).executeTest();
    }

    @DisplayName("Exception при вызове метода executeTest")
    @Test
    void testExecuteTestException() {
        var testService = mock(TestServiceImpl.class);
        doThrow(QuestionReadException.class).when(testService).executeTest();
        assertThrows(QuestionReadException.class, testService::executeTest);
    }
}
