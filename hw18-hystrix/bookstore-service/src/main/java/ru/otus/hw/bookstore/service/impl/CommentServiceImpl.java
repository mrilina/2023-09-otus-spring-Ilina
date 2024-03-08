package ru.otus.hw.bookstore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.bookstore.dto.CommentDto;
import ru.otus.hw.bookstore.exception.DataNotFoundException;
import ru.otus.hw.bookstore.mapper.CommentMapper;
import ru.otus.hw.bookstore.repository.BookRepository;
import ru.otus.hw.bookstore.repository.CommentRepository;
import ru.otus.hw.bookstore.service.CommentService;
import ru.otus.hw.bookstore.util.ErrorMessage;

import java.util.List;

import static java.lang.String.format;

/**
 * Сервис обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    /**
     * Репозиторий обработки сведений о книгах.
     */
    private final BookRepository bookRepository;

    /**
     * Репозиторий обработки сведений о комментариях.
     */
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    @Override
    public List<CommentDto> getAllByBookId(long bookId) {
        var book = bookRepository.findById(bookId)
                .orElseThrow(() -> new DataNotFoundException(format(ErrorMessage.BOOK_NOT_FOUND, bookId)));
        return commentRepository.findAllByBook(book)
                .stream()
                .map(CommentMapper::mapCommentToDto)
                .toList();
    }
}
