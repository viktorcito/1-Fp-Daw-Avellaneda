/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.arrayslistonfire.model;

import java.util.Comparator;

/**
 *
 * @author VSPC
 */
public class ComparatorByName implements Comparator<Persona>{

    @Override
    public int compare(Persona p1, Persona p2) {
        
        return p1.getNombre().compareTo(p2.getNombre());
    }
    
}
