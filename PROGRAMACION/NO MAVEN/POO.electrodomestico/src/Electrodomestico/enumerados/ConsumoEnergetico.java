/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electrodomestico.enumerados;

/**
 *
 * @author VSPC
 */
public enum ConsumoEnergetico {
    
    A(100),
    B(80),
    C(60),
    D(50),
    E(30),
    F(10);
    
    
    private int extra;

    private ConsumoEnergetico(int extra) {
        this.extra = extra;
    }

    public int getExtra() {
        return extra;
    }

   
    
    
}
