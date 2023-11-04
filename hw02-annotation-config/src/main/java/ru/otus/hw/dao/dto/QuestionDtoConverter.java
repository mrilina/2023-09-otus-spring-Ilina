package ru.otus.hw.dao.dto;

import java.io.BufferedReader;
import java.util.List;

/**
 * Конвертер данных вопросов.
 *
 * @author Irina Ilina
 */
public interface QuestionDtoConverter {

    /**
     * Преобразует входной поток в список вопросов.
     *
     * @param reader входной потом данных
     * @return список данных вопросов
     */
    List<QuestionDto> convert(BufferedReader reader);
}
