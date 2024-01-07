package ru.otus.hw.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * Сведения об авторе.
 *
 * @author Irina Ilina
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDto {

    /**
     * Идентификатор.
     */
    @NotBlank
    private String id;

    /**
     * ФИО.
     */
    @NotBlank
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(id, authorDto.id) && Objects.equals(name, authorDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
