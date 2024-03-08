package ru.otus.hw.bookstore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.bookstore.dto.AuthorDto;
import ru.otus.hw.bookstore.mapper.AuthorMapper;
import ru.otus.hw.bookstore.repository.AuthorRepository;
import ru.otus.hw.bookstore.service.AuthorService;


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

    @Transactional(readOnly = true)
    @Override
    public List<AuthorDto> getAll(Sort sort) {
        return authorRepository.findAll(sort)
                .stream()
                .map(AuthorMapper::mapAuthorToDto)
                .toList();
    }

}
