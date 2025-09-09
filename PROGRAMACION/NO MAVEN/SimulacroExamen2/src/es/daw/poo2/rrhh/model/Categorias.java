/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package es.daw.poo2.rrhh.model;

/**
 *
 * @author VSPC
 */
public enum Categorias {
    DIRECTIVO(3),
    SENIOR(2),
    JUNIOR(1);
    
    private int valor;

    private Categorias(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
    
    
}
