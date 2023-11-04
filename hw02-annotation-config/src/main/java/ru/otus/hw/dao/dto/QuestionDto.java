package ru.otus.hw.dao.dto;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Данные вопроса.
 *
 * @author Irina Ilina
 */
@Data
public class QuestionDto {

    /**
     * Текст вопроса.
     */
    @CsvBindByPosition(position = 0)
    private String text;

    /**
     * Список ответов на вопрос.
     */
    @CsvBindAndSplitByPosition(position = 1, collectionType = ArrayList.class, elementType = Answer.class,
            converter = AnswerCsvConverter.class, splitOn = "\\|")
    private List<Answer> answers;

    /**
     * Преобразует данные в доменный объект вопроса.
     *
     * @return доменный объект вопроса
     */
    public Question toDomainObject() {
        return new Question(text, answers);
    }
}
