package ru.otus.hw.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Интеграционные тесты для класса Student.
 *
 * @author Irina Ilina
 */
public class StudentTest {

    @DisplayName("Корректное создание объекта студент")
    @Test
    public void createStudentTest() {
        Student student = new Student("Oleg", "Nesterov");

        Assertions.assertEquals("Oleg", student.firstName());
        Assertions.assertEquals("Oleg Nesterov", student.getFullName());
    }
}
