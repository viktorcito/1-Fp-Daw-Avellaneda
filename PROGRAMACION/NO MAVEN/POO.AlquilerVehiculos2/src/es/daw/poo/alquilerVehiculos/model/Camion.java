/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.alquilerVehiculos.model;

/**
 *
 * @author VSPC
 */
public class Camion extends Furgoneta {
    private final int EXTRA=40;

    public Camion(float PMA, String MATRICULA) {
        super(PMA, MATRICULA);
    }

    @Override
    public float getPrecioAlquiler() {
        return super.getPrecioAlquiler()+EXTRA;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
    
    
    
}
