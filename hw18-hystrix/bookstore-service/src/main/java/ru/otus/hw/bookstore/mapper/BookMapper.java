package ru.otus.hw.bookstore.mapper;

import org.springframework.stereotype.Component;
import ru.otus.hw.bookstore.dto.BookCreateDto;
import ru.otus.hw.bookstore.dto.BookDto;
import ru.otus.hw.bookstore.domain.Author;
import ru.otus.hw.bookstore.domain.Book;
import ru.otus.hw.bookstore.domain.Genre;

/**
 * Маппер сведений об книге.
 *
 * @author Irina Ilina
 */
@Component
public class BookMapper {

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
