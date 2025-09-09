package es.daw.examen2ev.model2;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * SE PROPORCIONA LA CLASE COMPLETA
 * NO DEBES MODIFICARLA
 */
public class AgenteDAO {

    private static ArrayList<Corporatable> agentes;

    public AgenteDAO(){
        
        if (agentes == null) {
            agentes = new ArrayList<>();
            
            //EMPLEADO: String DNI, String nombre, String apellidos, LocalDate fechaNacimiento, DEPARTAMENTOS departamentos
            //CLIENTE: String nombre, String direccionCompleta, LocalDate fechaInicioContrato
            agentes.add(new Empleado("11111111A","Ada", "Lovelace", LocalDate.of(2001, 05, 1), DEPARTAMENTOS.CONSULTORIA));
            agentes.add(new Empleado("11111111B","Grace", "Hoper", LocalDate.of(2001, 03, 1), DEPARTAMENTOS.CONTABILIDAD));
            agentes.add(new Cliente("InnovateTech Solutions","Calle de la Innovación, 123",LocalDate.of(2024, 01, 1)));
            agentes.add(new Empleado("21111111A","Elon", "Musk", LocalDate.of(2001, 01, 1), DEPARTAMENTOS.DESARROLLO));
            agentes.add(new Empleado("11111111C","Steve", "Jobs", LocalDate.of(2001, 06, 1)));
            agentes.add(new Cliente("Quantum Dynamics Innovations","Plaza de la Fantasía, 789",LocalDate.of(2024, 01, 8)));
            agentes.add(new Cliente("Fusion Innovations Group","Avenida de los Sueños, 456",LocalDate.of(2023, 06, 1)));
        }
        
    }
    
    /**
     * Método que devuelte la colección de agentes
     * @return 
     */
    public ArrayList<Corporatable> select() {
        return new ArrayList<>(agentes);

    }

}
