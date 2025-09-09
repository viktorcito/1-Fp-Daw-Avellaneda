/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.tiendaOrdenadores.model;

/**
 *
 * @author VSPC
 */
public class Sobremesa extends Ordenador {
    private String tipo;
    
    public final static String SLOGAN ="Es el que mas pesa, pero el que menos cuesta";
    
    public final static int GARANTIA_INICIAL =6;
    public final static int GARANTIA_LIMITE = 24;

    
    
    public Sobremesa(String tipo, String codigo, float precio) {
        super(codigo, precio);
        this.tipo = tipo;
        
        
        super.setDuracion(GARANTIA_INICIAL);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setDuracion(int duracion) {
        super.setDuracion(duracion);
    }

    @Override
    public String toString() {
        return "Sobremesa{" + "tipo=" + tipo + '}';
    }
    
    
    
    
    
}
