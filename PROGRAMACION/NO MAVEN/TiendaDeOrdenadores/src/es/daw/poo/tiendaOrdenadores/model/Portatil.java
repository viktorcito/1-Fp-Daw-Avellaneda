/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.tiendaOrdenadores.model;

/**
 *
 * @author VSPC
 */
public class Portatil extends Ordenador{
    private float peso;
    
    public final static String Slogan ="Ideal para tus viajes";
    
    public final static int GARANTIA_INICIAL= 12;
    public final static int GARANTIA_LIMITE = 60;

    public Portatil(float peso, String codigo, float precio) {
        super(codigo, precio);
        this.peso = peso;
        
        super.setDuracion(GARANTIA_INICIAL);
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public void setDuracion(int duracion) {
       if(duracion <= GARANTIA_LIMITE) super.setDuracion(duracion);
    }

    @Override
    public String toString() {
        return "Portatil{" + "peso=" + peso + '}';
    }
    
    
    
    
}
