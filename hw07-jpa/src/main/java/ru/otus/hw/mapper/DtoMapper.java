package ru.otus.hw.mapper;

/**
 * Базовый маппер.
 *
 * @author Irina Ilina
 */
public interface DtoMapper<E, D> {
    D toDto(E model);
}
