package ru.otus.hw.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.dao.dto.QuestionDto;
import ru.otus.hw.domain.Question;
import ru.otus.hw.exceptions.QuestionReadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static ru.otus.hw.utils.QuestionUtils.COLON_SEPARATOR;
import static ru.otus.hw.utils.QuestionUtils.QUESTIONS_COUNT;

/**
 * Считывание вопросов из входного файла с помощью парсера OpenCsv.
 *
 * @author Irina Ilina
 */
@Repository
@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {

    /**
     * Конфигурация приложения.
     */
    private final TestFileNameProvider fileNameProvider;

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

            List<QuestionDto> questionDtoList = new CsvToBeanBuilder<QuestionDto>(reader)
                    .withSkipLines(1)
                    .withType(QuestionDto.class)
                    .withSeparator(COLON_SEPARATOR)
                    .build()
                    .parse();

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
