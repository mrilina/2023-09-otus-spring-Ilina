package ru.otus.hw.domain;

/**
 * Сведения о студенте.
 *
 * @author Irina Ilina
 */
public record Student(String firstName, String lastName) {
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
