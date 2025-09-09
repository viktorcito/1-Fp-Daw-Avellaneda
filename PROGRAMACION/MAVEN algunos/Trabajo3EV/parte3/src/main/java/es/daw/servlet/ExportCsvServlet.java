package es.daw.servlet;

import es.daw.bd.DaoEmpleado;
import es.daw.bd.DaoDepartamento;
import es.daw.model.Empleado;
import es.daw.model.Departamento;
import es.daw.util.FileUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ExportCsvServlet", value = "/ExportCsvServlet")
public class ExportCsvServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DaoEmpleado daoEmpleado;
    private DaoDepartamento daoDepartamento;

    @Override
    public void init() {
        try {
            daoEmpleado = new DaoEmpleado(getServletContext().getRealPath("/JDBC.properties"));
            daoDepartamento = new DaoDepartamento(getServletContext().getRealPath("/JDBC.properties"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String entityType = request.getParameter("entityType");
        String filePath = getServletContext().getRealPath("/downloads") + "/" + entityType + ".csv";

        if ("empleado".equals(entityType)) {
            try {
                List<Empleado> empleados = daoEmpleado.selectAll();
                FileUtils.writeEmpleadosToFile(filePath, empleados);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("departamento".equals(entityType)) {
            try {
                List<Departamento> departamentos = daoDepartamento.selectAll();
                FileUtils.writeDepartamentosToFile(filePath, departamentos);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + entityType + ".csv\"");
        response.getWriter().write(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath))));
    }
}

