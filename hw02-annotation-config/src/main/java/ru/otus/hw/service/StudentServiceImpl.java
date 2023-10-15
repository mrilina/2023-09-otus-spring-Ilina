package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.domain.Student;

/**
 * Сервис обработки данных о студенте.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    /**
     * Сервис ввода/вывода.
     */
    private final IOService ioService;

    /**
     * Возвращает сведения о студенте.
     *
     * @return сведения о студенте
     */
    @Override
    public Student determineCurrentStudent() {
        var firstName = ioService.readStringWithPrompt("Please input your first name");
        var lastName = ioService.readStringWithPrompt("Please input your last name");
        return new Student(firstName, lastName);
    }
}
