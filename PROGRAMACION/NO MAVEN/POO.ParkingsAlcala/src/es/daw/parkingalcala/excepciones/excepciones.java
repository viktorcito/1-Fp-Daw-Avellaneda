/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parkingalcala.excepciones;

/**
 *
 * @author VSPC
 */
public class excepciones extends Exception {
    private String nombreParking;
    private int numPlazasOcupadas;

    public excepciones(String nombreParking, int numPlazasOcupadas) {
        this.nombreParking = nombreParking;
        this.numPlazasOcupadas = numPlazasOcupadas;
    }

    public String getNombreParking() {
        return nombreParking;
    }

    public int getNumPlazasOcupadas() {
        return numPlazasOcupadas;
    }

    
    
    
    
    
}
