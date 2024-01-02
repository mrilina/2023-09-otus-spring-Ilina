package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.domain.Genre;
import ru.otus.hw.dto.GenreDto;
import ru.otus.hw.mapper.GenreMapper;
import ru.otus.hw.repository.GenreRepository;

import java.util.List;
import java.util.stream.StreamSupport;

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

    /**
     * Маппер сведений о жанре.
     */
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAll() {
        return StreamSupport.stream(genreRepository.findAll().spliterator(), false)
                .map(genreMapper::map).toList();
    }

    @Override
    public Genre geGenreById(Long id) {
        return genreRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Genre getGenreByName(String name) {
        return genreRepository.getGenreByName(name);
    }
}
