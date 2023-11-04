package ru.otus.hw.domain;

import java.util.List;

/**
 * Сведения о вопросе.
 *
 * @author Irina Ilina
 */
public record Question(String text, List<Answer> answers) {
}
