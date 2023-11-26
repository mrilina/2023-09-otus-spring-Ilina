package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.mapper.AuthorMapper;
import ru.otus.hw.repositories.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    /**
     * Репозиторий обработки сведений об авторах.
     */
    private final AuthorRepository authorRepository;

    /**
     * Маппер сведений об авторе.
     */
    private final AuthorMapper authorMapper;

    /**
     * Сервис преобразования сведений о модели в строковое представление.
     */
    private final ConvertService convertService;

    @Override
    public List<AuthorDto> findAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDto)
                .toList();
    }

    @Override
    public String getAll() {
        return findAll().stream()
                .map(convertService::authorToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }
}
