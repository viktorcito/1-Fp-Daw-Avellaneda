/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.productosperecederos.model;

/**
 *
 * @author VSPC
 */
public class Perecedero extends Producto {
    private int diasCaducar;

    public Perecedero(int diasCaducar, String nombre, double precio) {
        super(nombre, precio);
        this.diasCaducar = diasCaducar;
    }

    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }

    @Override
    public double calcular(int cantidad) {
        
        double precio = super.calcular(cantidad);
        
        switch (diasCaducar) {
            case 1:
                precio = super.calcular(cantidad);
                break;
            case 2:
               precio = precio - (precio*33)/100;
                break;
            case 3:
                precio = precio - (precio*50)/100;
                break;
            default:
                break;
        }
        
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("diasCaducar=").append(diasCaducar);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean permiteDevolucion() {
        if (diasCaducar > 5) return true;
        else return false;
    }

    @Override
    public String convert2XML() {
        return "<producto>Producto perecedero<producto>";
    }
    
    
    
    
    
    
}
