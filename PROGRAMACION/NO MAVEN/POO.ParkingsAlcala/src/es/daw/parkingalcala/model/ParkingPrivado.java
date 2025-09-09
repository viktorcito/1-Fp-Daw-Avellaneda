/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parkingalcala.model;

/**
 *
 * @author VSPC
 */
public class ParkingPrivado extends Parking{
    private int numSocios;

    public ParkingPrivado(int numSocios, int capacidad, String nombre, String direccion) {
        super(capacidad, nombre, direccion);
        this.numSocios = numSocios;
    }

    public void setNumSocios(int numSocios) {
        this.numSocios = numSocios;
    }

    
    
    
    @Override
    public double mostrarGananciasTotales() {
        return cantidadGanada / numSocios;
    }
    
    
    
    
}
