package es.daw.web.bd;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz genérica DAO
 * Desacoplar la lógica de negocio de la lógica de acceso a datos
 * @author daw1a
 * @param <T>
 */
public interface Dao<T> {
    
    public T select(int id) throws SQLException;
    
    // Añadido por el examen
    //public T select(String dato) throws SQLException;
    
    public List<T> selectAll() throws SQLException;
    
    public void insert(T t) throws SQLException;
    
    public void update(T t) throws SQLException;
    
    public void delete(T t) throws SQLException;
    
    public void delete(int id) throws SQLException;
    
    
}