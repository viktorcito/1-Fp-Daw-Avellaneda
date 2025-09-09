package es.daw.web.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.daw.web.model.Fabricante;
import es.daw.web.model.Producto;

public class Utils {
    public static String obtenerNombreFabricante(List<Fabricante> fabricantes, int codigo) {

        // FORMA 1: IMPERATIVA
        
        for (Fabricante f: fabricantes) {
            if (f.getCodigo() == codigo)
                return f.getNombre();
        }
        return "";
        

        // FORMA 2: STREAM()
        // return fabricantes.stream()
        //         .filter(f -> f.getCodigo() == codigo)
        //         .findFirst()
        //         .get().getNombre();

    }


    public static List<Producto> getProductsByFabricantes(Connection con, String[] fabricantes) throws SQLException {
        List<Producto> productos = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT codigo, nombre, precio, codigo_fabricante FROM producto WHERE codigo_fabricante IN (");

        for (int i = 0; i < fabricantes.length; i++) {
            query.append("?");
            if (i < fabricantes.length - 1) {
                query.append(",");
            }
        }
        query.append(")");

        try (PreparedStatement ps = con.prepareStatement(query.toString())) {
            for (int i = 0; i < fabricantes.length; i++) {
                ps.setString(i + 1, fabricantes[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto p = new Producto();
                    p.setCodigo(rs.getInt("codigo"));
                    p.setNombre(rs.getString("nombre"));
                    p.setPrecio(rs.getFloat("precio"));
                    p.setCodigo_fabricante(rs.getInt("codigo_fabricante"));

                    productos.add(p);
                }
            }
        }

        return productos;
    }
}
