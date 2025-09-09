package es.daw.bd;

import es.daw.model.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDepartamento implements Dao<Departamento> {
    private Connection con;

    public DaoDepartamento(String dbSettingsPropsFilePath) throws SQLException {
        con = DBConnection.getConnection(dbSettingsPropsFilePath);
    }

    @Override
    public Departamento select(int id) throws SQLException {
        String query = "SELECT * FROM departamento WHERE codigo = ?";
        Departamento departamento = null;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    departamento = new Departamento();
                    departamento.setCodigo(rs.getInt("codigo"));
                    departamento.setNombre(rs.getString("nombre"));
                    departamento.setPresupuesto(rs.getDouble("presupuesto"));
                    departamento.setGastos(rs.getDouble("gastos"));
                }
            }
        }
        return departamento;
    }

    @Override
    public List<Departamento> selectAll() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        String query = "SELECT * FROM departamento";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setCodigo(rs.getInt("codigo"));
                d.setNombre(rs.getString("nombre"));
                d.setPresupuesto(rs.getDouble("presupuesto"));
                d.setGastos(rs.getDouble("gastos"));
                departamentos.add(d);
            }
        }
        return departamentos;
    }

    @Override
    public void insert(Departamento d) throws SQLException {
        String query = "INSERT INTO departamento (nombre, presupuesto, gastos) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, d.getNombre());
            ps.setDouble(2, d.getPresupuesto());
            ps.setDouble(3, d.getGastos());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Departamento d) throws SQLException {
        String query = "UPDATE departamento SET nombre = ?, presupuesto = ?, gastos = ? WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, d.getNombre());
            ps.setDouble(2, d.getPresupuesto());
            ps.setDouble(3, d.getGastos());
            ps.setInt(4, d.getCodigo());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Departamento d) throws SQLException {
        delete(d.getCodigo());
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM departamento WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
