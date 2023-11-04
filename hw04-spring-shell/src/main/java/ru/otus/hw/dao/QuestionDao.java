package ru.otus.hw.dao;

import ru.otus.hw.domain.Question;

import java.util.List;

/**
 * Интерфейс DAO (data access object).
 *
 * @author Irina Ilina
 */
public interface QuestionDao {

    /**
     * Считывает вопросы и ответы к ним.
     *
     * @return список вопросов
     */
    List<Question> findAll();
}
