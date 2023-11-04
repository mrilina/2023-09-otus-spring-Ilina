package ru.otus.hw.service;

import ru.otus.hw.domain.Student;

/**
 * Интерфейс обработки данных о студенте.
 *
 * @author Irina Ilina
 */
public interface StudentService {

    /**
     * Возвращает сведения о студенте.
     *
     * @return сведения о студенте
     */
    Student determineCurrentStudent();
}
