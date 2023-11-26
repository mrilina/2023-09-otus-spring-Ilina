package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.mapper.BookMapper;
import ru.otus.hw.mapper.CommentMapper;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Comment;
import ru.otus.hw.repositories.BookRepository;
import ru.otus.hw.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    /**
     * Репозиторий обработки сведений о комментариях.
     */
    private final CommentRepository commentRepository;

    /**
     * Репозиторий обработки сведений о книгах.
     */
    private final BookRepository bookRepository;

    /**
     * Маппер сведений о книгах.
     */
    private final BookMapper bookMapper;

    /**
     * Маппер сведений о комментарии.
     */
    private final CommentMapper commentMapper;

    /**
     * Сервис преобразования сведений о модели в строковое представление.
     */
    private final ConvertService convertService;

    @Transactional
    @Override
    public List<CommentDto> findAllByBookId(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Book with id %d not found".
                        formatted(bookId)
                ));
        return bookMapper.toDto(book).getComments();
    }

    @Transactional
    @Override
    public String findCommentsByBookId(Long bookId) {
        List<CommentDto> commentDtos = findAllByBookId(bookId);
        return commentDtos.stream()
                .map(convertService::commentToString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }

    @Transactional
    @Override
    public CommentDto insert(String text, Long bookId) {
        var book = bookRepository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Book with id %d not found".
                        formatted(bookId)
                ));

        Comment comment = new Comment();
        comment.setText(text);
        comment.setBook(book);
        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Transactional
    @Override
    public String insertComment(String text, Long bookId) {
        CommentDto comment = insert(text, bookId);
        return convertService.commentToString(comment);
    }

    @Transactional
    @Override
    public void deleteByBookId(long id) {
        commentRepository.deleteByBookId(id);
    }
}
