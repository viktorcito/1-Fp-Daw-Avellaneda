package es.daw.examen2ev.model2;

import java.time.LocalDate;

/**
 *
 * @author melola
 */
public class Cliente implements Corporatable {
    private String nombre;
    private String direccionCompleta;
    private LocalDate fechaInicioContrato;

    public Cliente(String nombre, String direccionCompleta, LocalDate fechaInicioContrato) {
        this.nombre = nombre;
        this.direccionCompleta = direccionCompleta;
        this.fechaInicioContrato = fechaInicioContrato;
    }

    @Override
    public String obtenerRazonSocial() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", direccionCompleta='" + direccionCompleta + '\'' +
                ", fechaInicioContrato=" + fechaInicioContrato +
                '}';
    }
}
