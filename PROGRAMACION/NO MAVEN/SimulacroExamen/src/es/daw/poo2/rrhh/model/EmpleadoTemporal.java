/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.rrhh.model;

import es.daw.poo2.rrhh.exceptions.FormatoDNIException;
import es.daw.poo2.rrhh.util.Utilidades;
import java.time.LocalDate;

/**
 *
 * @author VSPC
 */
public class EmpleadoTemporal extends Empleado {
    
    private LocalDate fechaFinContrato;

    public EmpleadoTemporal(LocalDate fechaFinContrato, String nombre, String apellido1, String apellido2, String DNI, String domicilioCompleto, int movil, String email, Categorias categoria) throws FormatoDNIException {
        super(nombre, apellido1, apellido2, DNI, domicilioCompleto, movil, email, categoria);
        this.fechaFinContrato = fechaFinContrato;
    }

    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    
    
    
    
    @Override
    public int calcularFactorPagaExtra() {
        return Utilidades.calculaDiasEntreFechas(getFechaInicioContrato(), getFechaFinContrato());
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("EmpleadoTemporal{" + "fechaFinContrato=").append(fechaFinContrato);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
}
