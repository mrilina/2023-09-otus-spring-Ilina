package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.dto.CommentDto;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.mapper.DtoMapper;
import ru.otus.hw.models.Book;
import ru.otus.hw.models.Comment;
import ru.otus.hw.repositories.BookRepository;
import ru.otus.hw.repositories.CommentRepository;

import java.util.List;

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

    private final DtoMapper<Book, BookDto> bookMapper;

    @Transactional(readOnly = true)
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
    public Comment insert(String text, long bookId) {
        var book = bookRepository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Book with id %d not found".
                        formatted(bookId)
                ));

        Comment comment = new Comment();
        comment.setText(text);
        comment.setBook(book);
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void deleteByBookId(long id) {
        commentRepository.deleteByBookId(id);
    }
}
