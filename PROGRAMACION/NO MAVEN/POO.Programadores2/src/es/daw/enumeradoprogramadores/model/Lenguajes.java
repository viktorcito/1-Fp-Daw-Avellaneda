/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package es.daw.enumeradoprogramadores.model;

/**
 *
 * @author VSPC
 */
public enum Lenguajes {
    
    JAVA(4),
    PHP(2),
    C(5),
    PERL(6),
    RUBY(3),
    PYTHON(4);
    
    private int aniosAprendizaje;

    private Lenguajes(int aniosAprendizaje) {
        this.aniosAprendizaje = aniosAprendizaje;
    }

    public int getAniosAprendizaje() {
        return aniosAprendizaje;
    }
    
    
}
