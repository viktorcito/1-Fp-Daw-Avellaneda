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
public class Lavadora extends Electrodomestico{
    
    private final static int CARGA_DEF=5;
    private int carga;

    public Lavadora() {
        this(PRECIO_BASE_DEF,PESO_DEF,CONSUMO_ENERGETICO_DEF,COLOR_DEF,CARGA_DEF);
        
    }

    public Lavadora(double precioBase, double peso) {
        this(precioBase, peso,CONSUMO_ENERGETICO_DEF,COLOR_DEF,CARGA_DEF);
    }

    public Lavadora(double precioBase, double peso, ConsumoEnergetico consumoEnergetico,Color color) {
        this(precioBase, peso,consumoEnergetico,color, CARGA_DEF);
    }

    public Lavadora(double precioBase, double peso, ConsumoEnergetico consumoEnergetico, Color color,int carga) {
        super(precioBase, peso,consumoEnergetico ,color);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    @Override
    public double getPrecioFinal() {
        double precioFinal=super.getPrecioFinal();
        
        precioFinal += (carga>30)? 50:0;
        
        
        return precioFinal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lavadora{");
        sb.append("carga=").append(carga);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
}
