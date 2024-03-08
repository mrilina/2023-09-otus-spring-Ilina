package ru.otus.hw.bookstore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.bookstore.dto.GenreDto;
import ru.otus.hw.bookstore.mapper.GenreMapper;
import ru.otus.hw.bookstore.repository.GenreRepository;
import ru.otus.hw.bookstore.service.GenreService;


import java.util.List;

/**
 * Сервис обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    /**
     * Репозиторий обработки сведений о жанрах.
     */
    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @Override
    public List<GenreDto> getAll(Sort sort) {
        return genreRepository.findAll(sort)
                .stream()
                .map(GenreMapper::mapGenreToDto)
                .toList();
    }

}
