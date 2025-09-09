package es.daw.web;


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

import es.daw.web.bd.DBConnection;
import es.daw.web.util.Utils;
import es.daw.web.model.Oficina;

@WebServlet(name = "Dao4Servlet", value = "/Dao4Servlet")
public class Dao4Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String pathProperties = "";

    @Override
    public void init() {
        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:" + pathProperties);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] oficinasSeleccionadas = request.getParameterValues("oficinas");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Connection con = null;

        try {
            con = DBConnection.getConnection(pathProperties);
            List<Oficina> oficinas = Utils.getOficinasByIds(con, oficinasSeleccionadas);

            for (Oficina oficina : oficinas) {
                out.println("<h2>Informe de la Oficina " + oficina.getCodigo_oficina() + ":</h2>");
                out.println("<p>Ciudad: " + oficina.getCiudad() + "</p>");
                out.println("<p>Pais: " + oficina.getPais() + "</p>");
                out.println("<p>Telefono: " + oficina.getTelefono() + "</p>");
                out.println("<p>Dirección: " + oficina.getLinea_direccion1() + " " + oficina.getLinea_direccion2() + "</p>");
                // Aquí puedes añadir más detalles según sea necesario
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error al obtener los informes: " + e.getMessage() + "</p>");
        } finally {
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
