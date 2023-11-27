package modele.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    void create(T donnees) throws SQLException;
    void update(T donnees) throws SQLException;
    void delete(T donnees) throws SQLException;
    T findById(String... id) throws SQLException;
    List<T> findAll() throws SQLException;
}
