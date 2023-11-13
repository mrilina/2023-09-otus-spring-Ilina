package ru.otus.hw.repositories;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.hw.models.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Репозиторий обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@Repository
public class AuthorRepositoryJdbc implements AuthorRepository {

    /**
     * Шаблонный класс с базовым набором операций JDBC.
     */
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    /**
     * Конструктор.
     *
     * @param namedParameterJdbcOperations шаблонный класс с базовым набором операций JDBC
     */
    public AuthorRepositoryJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public List<Author> findAll() {
        return namedParameterJdbcOperations.query("select id, full_name from authors", new AuthorRowMapper());
    }

    @Override
    public Optional<Author> findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        try {
            return Optional.ofNullable(namedParameterJdbcOperations.queryForObject(
                    "select id, full_name from authors where id = :id", params, new AuthorRowMapper())
            );
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    /**
     * Класс для отображения строк ResultSet для каждой строки сведений об авторе.
     *
     * @author Irina Ilina
     */
    private static class AuthorRowMapper implements RowMapper<Author> {

        /**
         * Возвращает сведения об авторе из ResultSet.
         *
         * @param rs результирующий набор данных
         * @param i индекс
         * @return сведения об авторе
         * @throws SQLException исключительная ситуация
         */
        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            return new Author(rs.getLong(1), rs.getString(2));
        }
    }
}
