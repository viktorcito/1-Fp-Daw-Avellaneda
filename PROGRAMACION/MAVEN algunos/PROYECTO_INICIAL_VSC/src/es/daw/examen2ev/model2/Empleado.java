package es.daw.examen2ev.model2;

import java.time.LocalDate;

/**
 *
 * @author melola
 */
public class Empleado implements Corporatable, Comparable<Empleado>{
    private String DNI;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private DEPARTAMENTOS departamentos;
    public Empleado(String dNI, String nombre, String apellidos, LocalDate fechaNacimiento,
            DEPARTAMENTOS departamentos) {
                this.DNI = DNI;
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.fechaNacimiento = fechaNacimiento;
                this.departamento = departamento;
    }
    


    @Override
    public String obtenerRazonSocial() {
        return apellidos + ", " + nombre + " " + dni;
    }

    @Override
    public int compareTo(Empleado o) {
        return this.dni.compareTo(o.dni);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", departamento=" + departamento +
                '}';
    }
}

    




