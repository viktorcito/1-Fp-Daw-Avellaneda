/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.productosperecederos.model;

/**
 *
 * @author VSPC
 */
public class NoPerecedero extends Producto {

    
    public enum TIPO {SIN_DEVOLUCION,PERMITE_DEVOLUCION};
    
    private TIPO tipo;

    public NoPerecedero(TIPO tipo, String nombre, double precio) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("NoPerecedero -> tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean permiteDevolucion() {
        if (tipo == TIPO.PERMITE_DEVOLUCION) return true;
        else return false;
    }

    @Override
    public String convert2XML() {
        return "<producto>No perecedero<producto>";
    }
    
    
    
    
    
    
}
