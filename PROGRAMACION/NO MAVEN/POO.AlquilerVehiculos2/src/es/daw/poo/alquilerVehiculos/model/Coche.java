/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.alquilerVehiculos.model;

/**
 *
 * @author VSPC
 */
public class Coche extends Vehiculo {
    
    private int numPlazas;
    private final float EXTRA = 1.5f;

    public Coche(String MATRICULA, int numPlazas) {
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
        return super.getPrecioAlquiler() + (EXTRA *numPlazas) + (EXTRA * getDias());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Numero de plazas=").append(numPlazas);
        if (estaAlquilado()){
        sb.append("Precio de alquiler: ").append(getPrecioAlquiler()).append("euros");
        sb.append('}');
        }
        return sb.toString();
    }
    
    
    
    
    
    
}
