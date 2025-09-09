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

import es.daw.bd.DaoDepartamento;
import es.daw.model.Departamento;

@WebServlet(name = "DepartamentoServlet", value = "/DepartamentoServlet")
public class DepartamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DaoDepartamento daoDepartamento;

    @Override
    public void init() {
        try {
            daoDepartamento = new DaoDepartamento(getServletContext().getRealPath("/JDBC.properties"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("listar".equals(action)) {
            listarDepartamentos(response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "crear":
                crearDepartamento(request, response);
                break;
            case "borrar":
                borrarDepartamento(request, response);
                break;
            case "actualizar":
                actualizarDepartamento(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
        }
    }

    private void listarDepartamentos(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            List<Departamento> departamentos = daoDepartamento.selectAll();
            for (Departamento d : departamentos) {
                out.println("<p>" + d + "</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al listar los departamentos");
        }
    }

    private void crearDepartamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String ubicacion = request.getParameter("ubicacion");
        Departamento departamento = new Departamento(nombre, ubicacion);
        try {
            daoDepartamento.insert(departamento);
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al crear el departamento");
        }
    }

    private void borrarDepartamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            daoDepartamento.delete(id);
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al borrar el departamento");
        }
    }

    private void actualizarDepartamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String ubicacion = request.getParameter("ubicacion");
        Departamento departamento = new Departamento(id, nombre, ubicacion);
        try {
            daoDepartamento.update(departamento);
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el departamento");
        }
    }
}

