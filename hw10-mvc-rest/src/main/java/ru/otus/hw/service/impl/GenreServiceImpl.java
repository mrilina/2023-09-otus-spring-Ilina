package ru.otus.hw.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.GenreDto;
import ru.otus.hw.mapper.GenreMapper;
import ru.otus.hw.repository.GenreRepository;
import ru.otus.hw.service.GenreService;

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

    @Override
    public List<GenreDto> getAll(Sort sort) {
        return genreRepository.findAll(sort)
                .stream()
                .map(GenreMapper::mapGenreToDto)
                .toList();
    }

}
