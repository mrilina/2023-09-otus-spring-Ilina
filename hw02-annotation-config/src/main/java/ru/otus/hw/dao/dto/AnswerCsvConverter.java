package ru.otus.hw.dao.dto;

import com.opencsv.bean.AbstractCsvConverter;
import ru.otus.hw.domain.Answer;

/**
 * Конвертер ответов на вопрос.
 *
 * @author Irina Ilina
 */
public class AnswerCsvConverter extends AbstractCsvConverter {

    /**
     * Выполняет конвертацию ответов на вопрос из строки.
     *
     * @param value входная строка
     * @return объект вопроса
     */
    @Override
    public Object convertToRead(String value) {
        var valueArr = value.split("%");
        return new Answer(valueArr[0], Boolean.parseBoolean(valueArr[1]));
    }
}
