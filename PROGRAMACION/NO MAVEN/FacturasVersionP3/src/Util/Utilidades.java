/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import static facturasversionp3.FacturasVersionP3.facturas;
import static facturasversionp3.FacturasVersionP3.lector;

/**
 *
 * @author VSPC
 */
public class Utilidades {

    public static void pintaMenu() {
        System.out.println("MENUUUU");
        System.out.println("1. Informe completo");
        System.out.println("2. Informe factura");
        System.out.println("3. Buscar gasto");

        System.out.println("4.Salir");
        System.out.println("Elige una opcion");

    }
    
    public static void inicializaFacturas(){
        for (int i = 0; i <facturas.length; i++) {
            System.out.println("Indica el numero de gastos por factura"+(i+1));
            int numGastos= lector.nextInt();
            facturas[i]=new float[numGastos];
            
        }
        
        
    }
    
    public static void pedirGastosFacturas(){
        for (int i = 0; i < facturas.length; i++) {
            System.out.println("Introduce los gastos de la factura");
            for (int j = 0; j < facturas[i].length; j++) {
                System.out.println("Gasto");
                facturas[i][j]= lector.nextInt();
            }
            
        }
        
    }
    
    //Metodo para inicializar los dos de arriba
    
    
    

}
