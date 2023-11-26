package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.GenreDto;
import ru.otus.hw.mapper.GenreMapper;
import ru.otus.hw.repositories.GenreRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    /**
     * Репозиторий обработки сведений о жанрах.
     */
    private final GenreRepository genreRepository;

    /**
     * Маппер сведений о жанре.
     */
    private final GenreMapper genreMapper;

    /**
     * Сервис преобразования сведений о модели в строковое представление.
     */
    private final ConvertService convertService;

    @Override
    public List<GenreDto> findAll() {
        return genreRepository.findAll().stream()
                .map(genreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public String getAll() {
        return findAll().stream()
                .map(convertService::genreToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }

    @Override
    public List<GenreDto> findAllByIds(List<Long> ids) {
        return genreRepository.findAllById(new HashSet<>(ids)).stream()
                .map(genreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public String getAllByIds(List<Long> ids) {
        return findAllByIds(ids).stream()
                .map(convertService::genreToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }
}
