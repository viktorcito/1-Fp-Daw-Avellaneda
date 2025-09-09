/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parkingalcala.model;

import java.time.LocalDate;

/**
 *
 * @author VSPC
 */
class Seguro {
    private int numPoliza;
    private String nomAseguradora;
    private LocalDate fechaFinSeguro;

    public Seguro(int numPoliza, String nomAseguradora, LocalDate fechaFinSeguro) {
        this.numPoliza = numPoliza;
        this.nomAseguradora = nomAseguradora;
        this.fechaFinSeguro = fechaFinSeguro;
    }

    

    public int getNumPoliza() {
        return numPoliza;
    }

    public String getNomAseguradora() {
        return nomAseguradora;
    }

    public LocalDate getFechaFinSeguro() {
        return fechaFinSeguro;
    }

    

    
    
}
