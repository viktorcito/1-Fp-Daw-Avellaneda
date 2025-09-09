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

import es.daw.web.bd.DBConnection;
import es.daw.web.util.Utils;
import es.daw.web.model.Empleado;

@WebServlet(name = "Servlet4", value = "/Servlet4")
public class Servlet4 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String pathProperties = "";

    @Override
    public void init() {
        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:" + pathProperties);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String codigoEmpleado = request.getParameter("codigoEmpleado");
        String operacion = request.getParameter("operacion");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Connection con = null;

        try {
            con = DBConnection.getConnection(pathProperties);
            Empleado empleado = Utils.getEmpleadoById(con, codigoEmpleado);

            if (empleado == null) {
                out.println("<p>Error: El empleado con código " + codigoEmpleado + " no existe.</p>");
                return;
            }

            if ("actualizar".equals(operacion)) {
                String nombre = request.getParameter("nombre");
                String apellido1 = request.getParameter("apellido1");
                String apellido2 = request.getParameter("apellido2");
                String extension = request.getParameter("extension");
                String email = request.getParameter("email");
                String puesto = request.getParameter("puesto");
                Utils.actualizarEmpleado(con, codigoEmpleado, nombre, apellido1, apellido2, extension, email, puesto);
                out.println("<p>Empleado actualizado correctamente.</p>");
            } else if ("borrar".equals(operacion)) {
                Utils.borrarEmpleado(con, codigoEmpleado);
                out.println("<p>Empleado borrado correctamente.</p>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error al realizar la operación: " + e.getMessage() + "</p>");
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

