package ru.otus.hw.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.BookDto;
import ru.otus.hw.domain.Author;
import ru.otus.hw.domain.Book;
import ru.otus.hw.domain.Genre;
import ru.otus.hw.dto.BookUpdateDto;

/**
 * Маппер сведений об книге.
 *
 * @author Irina Ilina
 */
@Component
public class BookMapper {

    private BookMapper() {
    }

    public static Book mapDtoToNewBook(BookUpdateDto book, Genre genre, Author author) {

        var bookBuilder = Book.builder();
        bookBuilder.title(book.getTitle());
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
