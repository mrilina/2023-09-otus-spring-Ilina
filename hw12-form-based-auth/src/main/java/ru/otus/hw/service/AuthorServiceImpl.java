package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.domain.Author;
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

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

}
