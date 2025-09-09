/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parkingalcala.model;

/**
 *
 * @author VSPC
 */
public class ParkingPublico extends Parking{
    private int numTrabajadoresDiscapacitados;

    public ParkingPublico(int numTrabajadoresDiscapacitados, int capacidad, String nombre, String direccion) {
        super(capacidad, nombre, direccion);
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    public void setNumTrabajadoresDiscapacitados(int numTrabajadoresDiscapacitados) {
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    
    
    
    
    @Override
    public double mostrarGananciasTotales() {
        
        return cantidadGanada + (numTrabajadoresDiscapacitados * 250);
    }
    
    
}
