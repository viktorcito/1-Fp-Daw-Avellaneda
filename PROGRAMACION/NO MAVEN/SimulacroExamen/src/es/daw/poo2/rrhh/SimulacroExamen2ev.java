package es.daw.poo2.rrhh;

import es.daw.poo2.rrhh.dao.EmpleadoDAO;
import es.daw.poo2.rrhh.exceptions.FormatoDNIException;
import es.daw.poo2.rrhh.model.Categorias;
import es.daw.poo2.rrhh.model.Empleado;
import es.daw.poo2.rrhh.model.EmpleadoFijo;
import es.daw.poo2.rrhh.model.EmpleadoTemporal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class SimulacroExamen2ev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // COMPLETAR CÓDIGO
        
        // ------------------------------------------------
        // Cargar la lista de empleados
        ArrayList<Empleado> empleados = new ArrayList<>();
        EmpleadoDAO dao;
        
        try {
            dao = new EmpleadoDAO();
            empleados = dao.select();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        // ------------------------------------------------
        // Añado dos empleados. Uno con DNI correcto y otro con DNI incorrecto
        System.out.println("\n* AÑADIENDO EMPLEADOS: ");
        try {
                Empleado nuevoEmpleadoCorrecto = new EmpleadoFijo(3000, "Mari", "A", "B", "11113311C", "DirDASD", 0, "email", Categorias.JUNIOR);
                Empleado nuevoEmpleadoIncorrecto = new EmpleadoFijo(3000,"Mari", "A", "B", "7776j", "dasdfasdf", 0, "email", Categorias.SENIOR);
        } catch (FormatoDNIException e) {
            System.out.println(e.getMessage());
        }
        
        // ------------------------------------------------
        // Muestro la lista de empleados en orden natural descendente
        empleados.sort(Comparator.reverseOrder());
        System.out.println("\n* LISTA DE EMPLEADOS por orden natural descendente: ");
        
        for (Empleado e : empleados) {
            System.out.println(e);
            System.out.println("Paga extra"+e.calcularFactorPagaExtra());
        }
        // ------------------------------------------------
        // Muestro la lista de empleados por apellido1, apellido2 y nombre
        
        empleados.sort( (ea,eb)-> ea.getApellido1().concat(ea.getApellido2().concat(ea.getNombre())).compareTo(eb.getApellido1().concat(eb.getApellido2().concat(eb.getNombre()))));
        
        System.out.println("\n* LISTA DE EMPLEADOS por apellido 1, 2 y nombre: ");
        empleados.forEach(System.out::println);
        
        // ------------------------------------------------
        // Eliminar de la lista aquellos empleados con fecha fin de contrato 2022-04-01
        
        System.out.println("\n* BORRANDO EMPLEADO CON FECHA FIN DE CONTRATO 2022-04-01");
        
        Iterator<Empleado> it = empleados.iterator();
        while(it.hasNext()){
            Empleado e = it.next();
            if (e instanceof EmpleadoTemporal){
                LocalDate ffc = ((EmpleadoTemporal) e).getFechaFinContrato();
                if (ffc.equals(LocalDate.of(2023, Month.MARCH, 1)))
                    it.remove();
            }
        }
        
        
        System.out.println("\n* LISTA DE EMPLEADOS actualizados:");
        empleados.forEach(System.out::println);
        // ------------------------------------------------
        
    }
    
}
