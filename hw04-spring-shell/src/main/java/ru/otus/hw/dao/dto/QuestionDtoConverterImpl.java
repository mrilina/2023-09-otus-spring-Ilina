package ru.otus.hw.dao.dto;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.util.List;

import static ru.otus.hw.utils.QuestionUtils.COLON_SEPARATOR;

/**
 * Конвертер данных вопросов.
 *
 * @author Irina Ilina
 */
@Service
public class QuestionDtoConverterImpl implements QuestionDtoConverter {

    /**
     * Преобразует входной поток в список вопросов.
     *
     * @param reader входной потом данных
     * @return список данных вопросов
     */
    @Override
    public List<QuestionDto> convert(BufferedReader reader) {
        return new CsvToBeanBuilder<QuestionDto>(reader)
                .withSkipLines(1)
                .withType(QuestionDto.class)
                .withSeparator(COLON_SEPARATOR)
                .build()
                .parse();
    }
}
