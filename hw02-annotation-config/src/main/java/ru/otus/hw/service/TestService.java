package ru.otus.hw.service;

import ru.otus.hw.domain.Student;
import ru.otus.hw.domain.TestResult;

/**
 * Интерфейс сервиса тестирования.
 *
 * @author Irina Ilina
 */
public interface TestService {

    /**
     * Подготавливает вопросы и запускает тесты.
     *
     * @param student сведения о студенте
     * @return результат тестирования
     */
    TestResult executeTestFor(Student student);
}
