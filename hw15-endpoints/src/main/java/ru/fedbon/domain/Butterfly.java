package ru.fedbon.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Бабочка.
 *
 * @author Irina Ilina
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Butterfly {

    /**
     * Наименование.
     */
    private final String name;
}
