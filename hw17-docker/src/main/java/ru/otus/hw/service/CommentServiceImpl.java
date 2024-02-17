package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.exception.DataNotFoundException;
import ru.otus.hw.mapper.CommentMapper;
import ru.otus.hw.repository.BookRepository;
import ru.otus.hw.repository.CommentRepository;
import ru.otus.hw.util.ErrorMessage;

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
