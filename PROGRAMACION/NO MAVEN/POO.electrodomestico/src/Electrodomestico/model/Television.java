/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electrodomestico.model;

import Electrodomestico.enumerados.Color;
import Electrodomestico.enumerados.ConsumoEnergetico;

/**
 *
 * @author VSPC
 */
public class Television extends Electrodomestico {
    
    private final static int RESOLUCION_DEF=20;
    
    private int resolucion;
    private boolean sintonizadorTDT;

    
    
    
    public Television() {
        this(PRECIO_BASE_DEF,PESO_DEF,CONSUMO_ENERGETICO_DEF,COLOR_DEF,RESOLUCION_DEF,false);
        
    }

    public Television(double precioBase, double peso) {
        this(precioBase, peso,CONSUMO_ENERGETICO_DEF,COLOR_DEF,RESOLUCION_DEF,false);
    }

    public Television(double precioBase, double peso, ConsumoEnergetico consumoEnergetico, Color color, int resolucion, boolean sintonizadorTDT) {
        super(precioBase, peso, consumoEnergetico, color);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    @Override
    public double getPrecioFinal() {
        double precioFinal=super.getPrecioFinal();
        
        if (resolucion>40){
            precioFinal = precioFinal * 1.3;
            
        }
        if (sintonizadorTDT){
            precioFinal+=50;
        }
        
        return precioFinal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Television{");
        sb.append("resolucion=").append(resolucion);
        sb.append(", sintonizadorTDT=").append(sintonizadorTDT);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
    
    
}
