/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author VSPC
 */
public class Producto implements Comparable<Producto>{

    private String nombre;
    private int alto, largo, ancho;

    private final int MIN = 2;
    private final int MAXANCHOLARGO = 10;
    private final int MAXALTO = 30;

    public Producto(String nombre, int alto, int largo, int ancho) {
        this.nombre = nombre;
        this.alto = alto;
        this.largo = largo;
        this.ancho = ancho;
        comprobarValores();
    }

    public Producto(String nombre) {
        this.nombre = nombre;
        this.alto = MIN;
        this.largo = MIN;
        this.ancho = MIN;
    }

    private void comprobarValores() {
        //Pendiente comprobar el minimo tambien;

        if (this.alto >= MAXALTO) {
            this.alto = MAXALTO;
        }
        if (this.largo >= MAXANCHOLARGO) {
            this.largo = MAXANCHOLARGO;
        }
        if (this.alto >= MAXANCHOLARGO) {
            this.alto = MAXANCHOLARGO;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getAlto() {
        return alto;
    }

    public int getLargo() {
        return largo;
    }

    public int getAncho() {
        return ancho;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("nombre=").append(nombre);
        sb.append(", alto=").append(alto);
        sb.append(", largo=").append(largo);
        sb.append(", ancho=").append(ancho);
        sb.append(", MIN=").append(MIN);
        sb.append(", MAXANCHOLARGO=").append(MAXANCHOLARGO);
        sb.append(", MAXALTO=").append(MAXALTO);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Producto t) {
        
        return this.nombre.compareTo(t.nombre);
    }
    
    
    

}
