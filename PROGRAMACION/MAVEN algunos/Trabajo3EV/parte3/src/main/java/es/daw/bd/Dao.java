package es.daw.bd;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    T select(int id) throws SQLException;

    List<T> selectAll() throws SQLException;

    void insert(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

    void delete(int id) throws SQLException;
}
