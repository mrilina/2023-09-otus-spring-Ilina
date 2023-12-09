package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.mapper.CommentMapper;
import ru.otus.hw.models.Comment;
import ru.otus.hw.repositories.CommentRepository;

import java.util.List;

/**
 * Сервис обработки сведений о комментариях.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    /**
     * Репозиторий обработки сведений о комментариях.
     */
    private final CommentRepository commentRepository;

    /**
     * Маппер сведений о комментарии.
     */
    private final CommentMapper commentMapper;

    /**
     * Сервис обработки сведений о книгах.
     */
    private final BookService bookService;

    @Override
    public CommentDto getCommentById(Long id) {
        return commentMapper.toDto(commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment with id %d not found".formatted(id))));
    }

    @Transactional
    @Override
    public void saveComment(String text, Long bookId) {
        Comment comment = new Comment(null, text, bookService.getBookById(bookId));
        commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void updateComment(Long id, String text, Long bookId) {
        Comment comment = new Comment(id, text, bookService.getBookById(bookId));
        commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void deleteCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment with id %d not found".formatted(id)));
        commentRepository.delete(comment);
    }

    @Override
    public List<CommentDto> findCommentsByBookId(Long id) {
        return commentRepository.findByBookId(id).stream()
                .map(commentMapper::toDto).toList();
    }

    @Transactional
    @Override
    public void deleteByBookId(long id) {
        commentRepository.deleteByBookId(id);
    }
}
