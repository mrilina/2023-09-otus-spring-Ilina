package ru.fedbon.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Гусеница.
 *
 * @author Irina Ilina
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Caterpillar {

    /**
     * Наименоваение.
     */
    private final String name;
}
