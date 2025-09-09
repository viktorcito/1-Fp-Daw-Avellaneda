/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.alquilerVehiculos.model;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Vehiculo {
    
    private final String MATRICULA;
    private int dias;
    private boolean alquilado;
    private final int PRECIO_BASE=50;

    public Vehiculo(String MATRICULA) {
        this.MATRICULA = MATRICULA;
        alquilado = false;
    }

  
    public boolean estaAlquilado(){
        return alquilado;
        
    }

    public void setAlquilado(boolean alquilado) {
        Scanner sc = new Scanner(System.in);
        
        this.alquilado = alquilado;
        if(alquilado){
            System.out.println("Introduce los dias de alquiler del" +getClass().getSimpleName());
            setDias(sc.nextInt());
            System.out.println("Precio estimado de alquiler"+ getPrecioAlquiler());
        }
        
        
    }
    
    
    
    
    

    public String getMATRICULA() {
        return MATRICULA;
    }
    

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

  
 
    public float getPrecioAlquiler(){
        return PRECIO_BASE * dias;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.MATRICULA);
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.MATRICULA, other.MATRICULA);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(((this instanceof Camion))?"[ Camion ]":"[ "+getClass().getSimpleName()+" ]");
        sb.append("MATRICULA=").append(MATRICULA);
        sb.append((alquilado)?"DIAS DE ALQUILER: "+dias:"");
        return sb.toString();
    }
    
    
    
    
    
}
