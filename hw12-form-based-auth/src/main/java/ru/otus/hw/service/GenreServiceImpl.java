package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.domain.Genre;
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
    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }
}
