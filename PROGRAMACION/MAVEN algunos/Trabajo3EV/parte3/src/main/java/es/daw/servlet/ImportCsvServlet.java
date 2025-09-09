package es.daw.servlet;

import es.daw.bd.DaoEmpleado;
import es.daw.bd.DaoDepartamento;
import es.daw.model.Empleado;
import es.daw.model.Departamento;
import es.daw.util.FileUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ImportCsvServlet", value = "/ImportCsvServlet")
@MultipartConfig
public class ImportCsvServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file"); 
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
        String filePath = getServletContext().getRealPath("/uploads") + "/" + fileName;

        // Guardar el archivo en el servidor
        filePart.write(filePath);

        // Leer y procesar el archivo
        String entityType = request.getParameter("entityType");
        if ("empleado".equals(entityType)) {
            List<Empleado> empleados = FileUtils.readEmpleadosFromFile(filePath);
            for (Empleado empleado : empleados) {
                try {
                    daoEmpleado.insert(empleado);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else if ("departamento".equals(entityType)) {
            List<Departamento> departamentos = FileUtils.readDepartamentosFromFile(filePath);
            for (Departamento departamento : departamentos) {
                try {
                    daoDepartamento.insert(departamento);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        response.sendRedirect("index.html");
    }
}

