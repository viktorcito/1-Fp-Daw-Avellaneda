/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.alquilerVehiculos.model;

/**
 *
 * @author VSPC
 */
public class Microbus extends Vehiculo {
    
    private int numPlazas;
    private final int EXTRA =3;

    public Microbus(int numPlazas, String MATRICULA) {
        super(MATRICULA);
        this.numPlazas = numPlazas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    @Override
    public float getPrecioAlquiler() {
        return super.getPrecioAlquiler()+(EXTRA * numPlazas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("numPlazas=").append(numPlazas);
        if (estaAlquilado()){
        sb.append("Precio de alquiler").append(getPrecioAlquiler()).append("euros");
        }
        return sb.toString();
    }
    
    
    
}
