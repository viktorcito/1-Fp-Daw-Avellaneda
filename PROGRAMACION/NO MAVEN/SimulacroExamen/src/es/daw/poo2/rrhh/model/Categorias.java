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
    
    private int factor;

    private Categorias(int factor) {
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }
    
    
    
}
