package es.daw.web.bd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * DBConnection: esta es la clase que me va a permitir conectar a la B.D
 *
 * @author daw1a
 */
public class DBConnection {

    private static Connection con = null;

    private DBConnection() {
    }

    /**
     * Método para obtener la conexión
     * @return
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {

        if (con == null) {
            
            Properties props = new Properties();
            String dbSettingsPropsFilePath = "ExamenJDBC.properties"; 
            
            try {
                FileReader fReader = new FileReader(dbSettingsPropsFilePath);
                props.load(fReader);
                con = DriverManager.getConnection(props.getProperty("url"), props);
            } catch (FileNotFoundException ex) {
                throw new SQLException("No se encuentra el fichero de propiedades");
            } catch (IOException ex) {
                throw new SQLException("Error cargando el fichero de propiedades");
            }
        }
        return con;
    }

    /**
     * Método para cerrar la conexión
     * @throws SQLException 
     */
    public static void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
