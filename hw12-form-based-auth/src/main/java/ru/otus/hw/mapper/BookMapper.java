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

    /**
     * Маппер сведений о кгиге в доменный объект.
     *
     * @param bookDto сведения о книге
     * @param genre   жанр
     * @param author  автор
     * @return сведения о книге
     */
    public static Book mapDtoToNewBook(BookCreateDto bookDto, Genre genre, Author author) {
        var bookBuilder = Book.builder();
        bookBuilder.title(bookDto.getTitle());
        bookBuilder.genre(genre);
        bookBuilder.author(author);

        return bookBuilder.build();
    }

    /**
     * Маппер сведений о кгиге из доменного объекта в dto.
     *
     * @param book сведения о книге
     * @return сведения о книге
     */
    public static BookDto mapBookToDto(Book book) {
        var bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthorId(book.getAuthor().getId());
        bookDto.setGenreId(book.getGenre().getId());

        return bookDto;
    }
}
