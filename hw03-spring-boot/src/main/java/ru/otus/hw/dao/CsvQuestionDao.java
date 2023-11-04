package ru.otus.hw.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.dao.dto.QuestionDto;
import ru.otus.hw.dao.dto.QuestionDtoConverter;
import ru.otus.hw.domain.Question;
import ru.otus.hw.exceptions.QuestionReadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static ru.otus.hw.utils.QuestionUtils.QUESTIONS_COUNT;

/**
 * Считывание вопросов из входного файла с помощью парсера OpenCsv.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@Component
public class CsvQuestionDao implements QuestionDao {

    /**
     * Конфигурация приложения.
     */
    private final TestFileNameProvider fileNameProvider;

    /**
     * Конвертер данных вопросов.
     */
    private final QuestionDtoConverter questionDtoConverter;

    /**
     * Считывает вопросы и ответы к ним.
     *
     * @return список вопросов
     */
    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream("/" + fileNameProvider.getTestFileName());
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<QuestionDto> questionDtoList = questionDtoConverter.convert(reader);
            int i = 0;
            while (i < QUESTIONS_COUNT) {
                questions.add(questionDtoList.get(i).toDomainObject());
                i++;
            }
        } catch (IOException e) {
            throw new QuestionReadException("An error occured while reading file with questions", e);
        }

        return questions;
    }
}
