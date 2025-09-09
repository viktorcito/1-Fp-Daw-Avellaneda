package es.daw.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import es.daw.web.bd.DBConnection;
import es.daw.web.util.Utils;
import es.daw.web.model.Producto;

@WebServlet(name = "Dao3Servlet", value = "/Dao3Servlet")
public class Dao3Servlet extends HttpServlet {
    
    private String pathProperties = "";

    @Override
    public void init() {
        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:" + pathProperties);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] fabricantesSeleccionados = request.getParameterValues("fabricantes");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Connection con = null;

        try {
            // Inicializar conexión a la base de datos
            con = DBConnection.getConnection(pathProperties);

            // Obtener productos de los fabricantes seleccionados
            List<Producto> productos = Utils.getProductsByFabricantes(con, fabricantesSeleccionados);

            // Generar una única tabla con todos los productos de los fabricantes seleccionados
            out.println("<h2>Todos los productos de los fabricantes seleccionados:</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Producto</th><th>Fabricante</th><th>Precio</th></tr>");
            for (Producto producto : productos) {
                out.println("<tr><td>" + producto.getNombre() + "</td><td>" + producto.getCodigo_fabricante() + "</td><td>" + producto.getPrecio() + "</td></tr>");
            }
            out.println("</table>");

            // Agrupar productos por fabricante y generar tablas separadas
            Map<Integer, List<Producto>> productosPorFabricante = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCodigo_fabricante));

            for (String fabricante : fabricantesSeleccionados) {
                int codigoFabricante = Integer.parseInt(fabricante);
                List<Producto> productosDelFabricante = productosPorFabricante.get(codigoFabricante);
                
                if (productosDelFabricante != null && !productosDelFabricante.isEmpty()) {
                    out.println("<h2>Productos del fabricante " + codigoFabricante + ":</h2>");
                    out.println("<table border='1'>");
                    out.println("<tr><th>Producto</th><th>Precio</th></tr>");
                    for (Producto producto : productosDelFabricante) {
                        out.println("<tr><td>" + producto.getNombre() + "</td><td>" + producto.getPrecio() + "</td></tr>");
                    }
                    out.println("</table>");
                } else {
                    out.println("<h2>No hay productos para el fabricante " + codigoFabricante + ".</h2>");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error al obtener los productos: " + e.getMessage() + "</p>");
        } finally {
            // Cerrar conexión a la base de datos si está abierta
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        out.close();
    }

    @Override
    public void destroy() {
    }
}

