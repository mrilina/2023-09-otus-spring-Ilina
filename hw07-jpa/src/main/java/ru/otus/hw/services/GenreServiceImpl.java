package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.models.Genre;
import ru.otus.hw.repositories.GenreRepository;

import java.util.HashSet;
import java.util.List;

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

    @Transactional(readOnly = true)
    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findAllByIds(List<Long> ids) {
        return genreRepository.findAllById(new HashSet<>(ids));
    }
}
