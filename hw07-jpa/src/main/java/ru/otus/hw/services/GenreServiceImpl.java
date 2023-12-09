package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.GenreDto;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.mapper.GenreMapper;
import ru.otus.hw.models.Genre;
import ru.otus.hw.repositories.GenreRepository;

import java.util.HashSet;
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

    private final GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAll() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(genreMapper::toDto).toList();
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genre with id %d not found".formatted(id)));
    }

    @Override
    public List<Genre> findAllByIds(List<Long> ids) {
        return genreRepository.findAllById(new HashSet<>(ids));
    }
}
