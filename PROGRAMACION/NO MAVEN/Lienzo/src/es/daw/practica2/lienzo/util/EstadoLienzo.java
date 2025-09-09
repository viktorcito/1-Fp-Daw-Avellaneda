/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.practica2.lienzo.util;

/**
 *
 * @author VSPC
 */
public class EstadoLienzo {
    
    String[][] estado;
    String descripcion;

    public EstadoLienzo(String[][] estado, String descripcion) {
        this.estado = estado;
        this.descripcion = descripcion;
    }

    // Getters
    public String[][] getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
