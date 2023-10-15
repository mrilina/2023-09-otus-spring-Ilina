package ru.otus.hw.domain;

/**
 * Сведения о студенте.
 *
 * @author Irina Ilina
 */
public record Student(String firstName, String lastName) {

    /**
     * Возвращает полное имя студента.
     *
     * @return полное имя студента
     */
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
