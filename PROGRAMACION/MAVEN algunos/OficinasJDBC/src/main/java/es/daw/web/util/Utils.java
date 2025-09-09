package es.daw.web.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import es.daw.web.model.Empleado;
import es.daw.web.model.Oficina;


/**
 *
 * @author melola
 */
public class Utils {

    /**
     * Método que devuelve una cadena de texto con la fecha actual del sistema
     * en formato dd/MM/YYYY HH:mm:ss
     * @return 
     */
    public static String getDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        String formatoFecha = sdf.format(new Date());
        return formatoFecha;
    }
    
    /**
     * Método que devuelve un objeto oficina encontrado en una lista de oficinas
     * @param cod_oficina
     * @param oficinas
     * @return
     */
    public static Oficina getOficinaByCod(String cod_oficina,List<Oficina> oficinas){
        for (Oficina o : oficinas) {
            if (o.getCodigo_oficina().equalsIgnoreCase(cod_oficina))
                return o;
        }
        return null;
    }

    /**
     * 
     * @param cod_oficina
     * @param oficinas
     * @return
     */
    public static boolean existeOficina(String cod_oficina, List<Oficina> oficinas){
        for (Oficina oficina : oficinas) {
            if(oficina.getCodigo_oficina().equalsIgnoreCase(cod_oficina))
                return true;
        }

        return false;
    }
    

    /**
     * 
     * @param pathLog
     * @param nombreLog
     * @throws IOException 
     */
    public static void writeLog(String pathLog,String nombreLog, String mensaje) throws IOException{

        Path p = Paths.get(pathLog);

        if (!Files.exists(p)){
            Files.createDirectory(p);
        }

        Path file = Paths.get(pathLog,nombreLog);

        // también podríamos usar resolver para unir dos path

        Files.write(file, (mensaje+"\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        

    }


    public static List<Oficina> getOficinasByIds(Connection con, String[] ids) throws SQLException {
        List<Oficina> oficinas = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM oficina WHERE codigo_oficina IN (");

        for (int i = 0; i < ids.length; i++) {
            query.append("?");
            if (i < ids.length - 1) {
                query.append(",");
            }
        }
        query.append(")");

        try (PreparedStatement ps = con.prepareStatement(query.toString())) {
            for (int i = 0; i < ids.length; i++) {
                ps.setString(i + 1, ids[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Oficina oficina = new Oficina();
                    oficina.setCodigo_oficina(rs.getString("codigo_oficina"));
                    oficina.setCiudad(rs.getString("ciudad"));
                    oficina.setPais(rs.getString("pais"));
                    oficina.setTelefono(rs.getString("telefono"));
                    oficina.setLinea_direccion1(rs.getString("linea_direccion1"));
                    oficina.setLinea_direccion2(rs.getString("linea_direccion2"));
                    oficinas.add(oficina);
                }
            }
        }

        return oficinas;
    }

    public static Empleado getEmpleadoById(Connection con, String id) throws SQLException {
        Empleado empleado = null;
        String query = "SELECT * FROM empleado WHERE codigo_empleado = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setCodigo_empleado(rs.getInt("codigo_empleado"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setApellido1(rs.getString("apellido1"));
                    empleado.setApellido2(rs.getString("apellido2"));
                    empleado.setExtension(rs.getString("extension"));
                    empleado.setEmail(rs.getString("email"));
                    empleado.setPuesto(rs.getString("puesto"));
                    empleado.setCodigo_oficina(rs.getString("codigo_oficina"));
                }
            }
        }

        return empleado;
    }

    public static void actualizarEmpleado(Connection con, String id, String nombre, String apellido1, String apellido2, String extension, String email, String puesto) throws SQLException {
        String query = "UPDATE empleado SET nombre = ?, apellido1 = ?, apellido2 = ?, extension = ?, email = ?, puesto = ? WHERE codigo_empleado = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, extension);
            ps.setString(5, email);
            ps.setString(6, puesto);
            ps.setString(7, id);
            ps.executeUpdate();
        }
    }

    public static void borrarEmpleado(Connection con, String id) throws SQLException {
        String query = "DELETE FROM empleado WHERE codigo_empleado = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, id);
            ps.executeUpdate();
        }

    }
    
}
