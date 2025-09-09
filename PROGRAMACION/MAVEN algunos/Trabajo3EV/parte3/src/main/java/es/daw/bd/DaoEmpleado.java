package es.daw.bd;

import es.daw.model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEmpleado implements Dao<Empleado> {
    private Connection con;

    public DaoEmpleado(String dbSettingsPropsFilePath) throws SQLException {
        con = DBConnection.getConnection(dbSettingsPropsFilePath);
    }

    @Override
    public Empleado select(int id) throws SQLException {
        String query = "SELECT * FROM empleado WHERE codigo = ?";
        Empleado empleado = null;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setCodigo(rs.getInt("codigo"));
                    empleado.setNif(rs.getString("nif"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setApellido1(rs.getString("apellido1"));
                    empleado.setApellido2(rs.getString("apellido2"));
                    empleado.setCodigo_departamento(rs.getInt("codigo_departamento"));
                }
            }
        }
        return empleado;
    }

    @Override
    public List<Empleado> selectAll() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setCodigo(rs.getInt("codigo"));
                e.setNif(rs.getString("nif"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));
                e.setCodigo_departamento(rs.getInt("codigo_departamento"));
                empleados.add(e);
            }
        }
        return empleados;
    }

    @Override
    public void insert(Empleado t) throws SQLException {
        String query = "INSERT INTO empleado (nif, nombre, apellido1, apellido2, codigo_departamento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, t.getNif());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido1());
            ps.setString(4, t.getApellido2());
            ps.setInt(5, t.getCodigo_departamento());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Empleado t) throws SQLException {
        String query = "UPDATE empleado SET nif = ?, nombre = ?, apellido1 = ?, apellido2 = ?, codigo_departamento = ? WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, t.getNif());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido1());
            ps.setString(4, t.getApellido2());
            ps.setInt(5, t.getCodigo_departamento());
            ps.setInt(6, t.getCodigo());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Empleado t) throws SQLException {
        delete(t.getCodigo());
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM empleado WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

