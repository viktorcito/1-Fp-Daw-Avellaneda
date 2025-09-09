package es.daw.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import es.daw.bd.DaoEmpleado;
import es.daw.model.Empleado;

@WebServlet(name = "EmpleadoServlet", value = "/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DaoEmpleado daoEmpleado;

    @Override
    public void init() {
        try {
            daoEmpleado = new DaoEmpleado(getServletContext().getRealPath("/JDBC.properties"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("listar".equals(action)) {
            listarEmpleados(response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "crear":
                crearEmpleado(request, response);
                break;
            case "borrar":
                borrarEmpleado(request, response);
                break;
            case "actualizar":
                actualizarEmpleado(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
        }
    }

    private void listarEmpleados(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            List<Empleado> empleados = daoEmpleado.selectAll();
            for (Empleado e : empleados) {
                out.println("<p>" + e + "</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al listar los empleados");
        }
    }

    private void crearEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        int departamentoId = Integer.parseInt(request.getParameter("departamento_id"));
        Empleado empleado = new Empleado(nombre, apellido1, apellido2, departamentoId);
        try {
            daoEmpleado.insert(empleado);
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al crear el empleado");
        }
    }

    private void borrarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            daoEmpleado.delete(id);
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al borrar el empleado");
        }
    }

    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        int departamentoId = Integer.parseInt(request.getParameter("departamento_id"));
        Empleado empleado = new Empleado(id, nombre, apellido1, apellido2, departamentoId);
        try {
            daoEmpleado.update(empleado);
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el empleado");
        }
    }
}
