package ru.otus.hw.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Юнит тесты для сервиса StudentService.
 *
 * @author Irina Ilina
 */
@DisplayName("Unit тесты сервиса обработки данных о студенте")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = StudentServiceImpl.class)
public class StudentServiceImplTest {

    /**
     * Сервис локализации.
     */
    @MockBean
    private LocalizedIOService localizedIOService;

    /**
     * Сервис обработки данных о студенте.
     */
    @Autowired
    private StudentService studentService;

    @DisplayName("Корректный вызов метода executeTestFor")
    @Test
    void testExecuteTestCorrect() {
        when(localizedIOService.readStringWithPromptLocalized("StudentService.input.first.name")).thenReturn("Petr");
        when(localizedIOService.readStringWithPromptLocalized("StudentService.input.last.name")).thenReturn("Ivanov");

        var testResult = studentService.determineCurrentStudent();
        assertThat(testResult).isNotNull();
        assertEquals("Petr", testResult.firstName());
        assertEquals("Ivanov", testResult.lastName());
    }
}
