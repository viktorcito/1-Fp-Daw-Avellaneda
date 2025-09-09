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
public abstract class Electrodomestico {

    protected final static Color COLOR_DEF = Color.BLANCO;
    protected final static ConsumoEnergetico CONSUMO_ENERGETICO_DEF = ConsumoEnergetico.F;
    protected final static double PRECIO_BASE_DEF = 100;
    protected final static double PESO_DEF = 5;

    private double precioBase;
    private double peso;
    private Color color;
    private ConsumoEnergetico ce;

    //CONSTRUCTORES
    public Electrodomestico() {
        this(PRECIO_BASE_DEF, PESO_DEF);

    }

    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.ce = CONSUMO_ENERGETICO_DEF;
        this.color = COLOR_DEF;
    }

    public Electrodomestico(double precioBase, double peso, ConsumoEnergetico ce, Color color) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = color;
        this.ce = ce;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPeso() {
        return peso;
    }

    public Color getColor() {
        return color;
    }

    public ConsumoEnergetico getCe() {
        return ce;
    }

    public double getPrecioFinal() {
        double precioFinal = 0;

        precioFinal = precioBase + ce.getExtra();

        if (peso >= 0 && peso < 19) {

            precioFinal += 10;
        } else if (peso >= 20 && peso < 49) {

            precioFinal += 50;
        } else if (peso >= 50 && peso < 79) {

            precioFinal += 80;
        } else if (peso >= 80) {
            
            precioFinal += 100;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Electrodomestico{");
        sb.append("precioBase=").append(precioBase);
        sb.append(", peso=").append(peso);
        sb.append(", color=").append(color);
        sb.append(", ce=").append(ce);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    

}
