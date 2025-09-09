/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.enumeradoprogramadores.excepciones;

import es.daw.enumeradoprogramadores.model.Lenguajes;

/**
 *
 * @author VSPC
 */
public class LimiteEdadExcepcion extends Exception implements Comparable <LimiteEdadExcepcion>{
    
    private String dni;
    private int edad;
    private Lenguajes lp;
    
    private static final String MESSAGE="El programador con DNI %s y con %d años y debe realizar el curso formativo previo";

    public LimiteEdadExcepcion(String dni, int edad, Lenguajes lp) {
        super(String.format(MESSAGE, dni,edad));
        this.dni = dni;
        this.edad = edad;
        this.lp = lp;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public Lenguajes getLp() {
        return lp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LimiteEdadExcepcion{");
        sb.append("dni=").append(dni);
        sb.append(", edad=").append(edad);
        sb.append(", lp=").append(lp);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(LimiteEdadExcepcion e) {
        return dni.compareTo(e.dni);
    }

    
   
    
    
}
