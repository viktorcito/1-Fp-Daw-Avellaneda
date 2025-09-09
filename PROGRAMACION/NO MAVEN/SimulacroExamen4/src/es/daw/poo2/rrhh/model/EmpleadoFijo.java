/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.rrhh.model;

/**
 *
 * @author VSPC
 */
public class EmpleadoFijo extends Empleado{
    private float importePlanPensiones;

    public EmpleadoFijo(float importePlanPensiones, String nombre, String apellido1, String apellido2, String DNI, String domicilioCompleto, int movil, String email, Categorias categoria) {
        super(nombre, apellido1, apellido2, DNI, domicilioCompleto, movil, email, categoria);
        this.importePlanPensiones = importePlanPensiones;
    }

    public float getImportePlanPensiones() {
        return importePlanPensiones;
    }

    public void setImportePlanPensiones(float importePlanPensiones) {
        this.importePlanPensiones = importePlanPensiones;
    }

    @Override
    public int CalcularFactorPagaExtra() {
        
    }
    
    
    
}
