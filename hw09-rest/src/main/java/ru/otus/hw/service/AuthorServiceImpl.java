package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.domain.Author;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.mapper.AuthorMapper;
import ru.otus.hw.repository.AuthorRepository;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Сервис обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    /**
     * Репозиторий обработки сведений об авторах.
     */
    private final AuthorRepository authorRepository;

    /**
     * Маппер сведений об авторе.
     */
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> getAll() {
        return StreamSupport.stream(authorRepository.findAll().spliterator(), false)
                .map(authorMapper::map).toList();
    }

    @Override
    public Author getAuthorByName(String name) {
        return authorRepository.getAuthorByName(name);
    }
}
