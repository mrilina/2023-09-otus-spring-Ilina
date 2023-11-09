package ru.otus.hw.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Сведения о книге.
 *
 * @author Irina Ilina
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    /**
     * Сведения о книге.
     */
    private long id;

    /**
     * Наименование.
     */
    private String title;

    /**
     * Автор.
     */
    private Author author;

    /**
     * Список жанров.
     */
    private List<Genre> genres;
}
