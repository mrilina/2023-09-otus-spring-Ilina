package ru.otus.hw.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.BookCreateDto;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.domain.Author;
import ru.otus.hw.domain.Book;
import ru.otus.hw.domain.Genre;

/**
 * Маппер сведений об книге.
 *
 * @author Irina Ilina
 */
@Component
public class BookMapper {

    /**
     * Конструктор.
     */
    private BookMapper() {
    }

    public static Book mapDtoToNewBook(BookCreateDto bookCreateDto, Genre genre, Author author) {

        var bookBuilder = Book.builder();
        bookBuilder.title(bookCreateDto.getTitle());
        bookBuilder.genre(genre);
        bookBuilder.author(author);

        return bookBuilder.build();
    }

    public static BookDto mapBookToDto(Book book) {

        var bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor().getName());
        bookDto.setGenre(book.getGenre().getName());

        return bookDto;
    }

}
