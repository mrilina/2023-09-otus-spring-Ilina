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
    private final LocalizedIOService ioService;

    /**
     * Возвращает сведения о студенте.
     *
     * @return сведения о студенте
     */
    @Override
    public Student determineCurrentStudent() {
        var firstName = ioService.readStringWithPromptLocalized("StudentService.input.first.name");
        var lastName = ioService.readStringWithPromptLocalized("StudentService.input.last.name");
        return new Student(firstName, lastName);
    }
}
