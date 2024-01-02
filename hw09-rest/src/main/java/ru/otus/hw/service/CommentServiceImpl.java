package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.domain.Comment;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.mapper.CommentMapper;
import ru.otus.hw.repository.CommentRepository;

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

    @Override
    public CommentDto getCommentById(Long id) {
        return commentMapper.map(commentRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(RuntimeException::new);
        commentRepository.delete(comment);
    }

    @Override
    @Transactional
    public List<CommentDto> getByBookId(Long id) {
        return commentRepository.findByBookId(id).stream()
                .map(commentMapper::map).toList();
    }
}
