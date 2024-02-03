package ru.fedbon.service;

import ru.fedbon.domain.Butterfly;
import ru.fedbon.domain.Caterpillar;

/**
 * Интерфейс трансформации из гусеницы в бабочку.
 *
 * @author Irina Ilina
 */
public interface ButterflyTransformer {
    Butterfly transform(Caterpillar caterpillar);
}
