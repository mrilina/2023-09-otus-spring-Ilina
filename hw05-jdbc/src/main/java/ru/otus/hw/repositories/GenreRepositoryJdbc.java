package ru.otus.hw.repositories;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.otus.hw.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Репозиторий обработки сведений о жанрах.
 *
 * @author Irina Ilina
 */
@Repository
public class GenreRepositoryJdbc implements GenreRepository {

    /**
     * Шаблонный класс с базовым набором операций JDBC.
     */
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    /**
     * Конструктор.
     *
     * @param namedParameterJdbcOperations шаблонный класс с базовым набором операций JDBC
     */
    public GenreRepositoryJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public List<Genre> findAll() {
        return namedParameterJdbcOperations.query("select id, name from genres", new GnreRowMapper());
    }

    @Override
    public List<Genre> findAllByIds(List<Long> ids) {
        SqlParameterSource parameters = new MapSqlParameterSource("ids", ids);
        List<Genre> genres = namedParameterJdbcOperations.query(
                "select id, name from genres where id in (:ids)",
                parameters,
                (rs, rowNum) -> new Genre(rs.getInt("id"), rs.getString("name")));
        return genres;
    }

    /**
     * Класс для отображения строк ResultSet для каждой строки сведений о жанре.
     *
     * @author Irina Ilina
     */
    private static class GnreRowMapper implements RowMapper<Genre> {

        /**
         * Возвращает сведения о жанре из ResultSet.
         *
         * @param rs результирующий набор данных
         * @param i  индекс
         * @return сведения об жанре
         * @throws SQLException исключительная ситуация
         */
        @Override
        public Genre mapRow(ResultSet rs, int i) throws SQLException {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Genre(id, name);
        }
    }
}
