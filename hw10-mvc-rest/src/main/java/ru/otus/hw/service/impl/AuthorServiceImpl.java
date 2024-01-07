package ru.otus.hw.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.AuthorDto;
import ru.otus.hw.mapper.AuthorMapper;
import ru.otus.hw.repository.AuthorRepository;
import ru.otus.hw.service.AuthorService;

import java.util.List;

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

    @Override
    public List<AuthorDto> getAll(Sort sort) {
        return authorRepository.findAll(sort)
                .stream()
                .map(AuthorMapper::mapAuthorToDto)
                .toList();
    }

}
