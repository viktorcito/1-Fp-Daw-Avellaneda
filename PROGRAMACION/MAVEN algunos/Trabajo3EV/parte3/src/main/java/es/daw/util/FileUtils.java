package es.daw.util;

import es.daw.model.Departamento;
import es.daw.model.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<Empleado> readEmpleadosFromFile(String filePath) throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Empleado empleado = new Empleado();
                empleado.setNif(data[0]);
                empleado.setNombre(data[1]);
                empleado.setApellido1(data[2]);
                empleado.setApellido2(data[3]);
                empleado.setCodigo_departamento(Integer.parseInt(data[4]));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    public static void writeEmpleadosToFile(String filePath, List<Empleado> empleados) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Empleado empleado : empleados) {
                bw.write(empleado.getNif() + "," + empleado.getNombre() + "," + empleado.getApellido1() + "," + empleado.getApellido2() + "," + empleado.getCodigo_departamento());
                bw.newLine();
            }
        }
    }

    public static List<Departamento> readDepartamentosFromFile(String filePath) throws IOException {
        List<Departamento> departamentos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Departamento departamento = new Departamento();
                departamento.setNombre(data[0]);
                departamento.setPresupuesto(Double.parseDouble(data[1]));
                departamento.setGastos(Double.parseDouble(data[2]));
                departamentos.add(departamento);
            }
        }
        return departamentos;
    }

    public static void writeDepartamentosToFile(String filePath, List<Departamento> departamentos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Departamento departamento : departamentos) {
                bw.write(departamento.getNombre() + "," + departamento.getPresupuesto() + "," + departamento.getGastos());
                bw.newLine();
            }
        }
    }
}

