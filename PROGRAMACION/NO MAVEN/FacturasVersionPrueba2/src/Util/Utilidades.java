/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import static facturasversionprueba2.FacturasVersionPrueba2.facturas;
import static facturasversionprueba2.FacturasVersionPrueba2.lector;       
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author VSPC
 */
public class Utilidades {
    
    
    public static void pintaMenu(){
        System.out.println("MENUUUU");
        System.out.println("1. Informe completo");
        System.out.println("2. Informe factura");
        System.out.println("3. Buscar gasto");
        
        System.out.println("4.Salir");
        System.out.println("Elige una opcion");
        
        
    }
    
    public static void inicializaFacturas (){
        
        for (int i =0; i < facturas.length;i++){
            System.out.println("Indica el numero de gastos de la factura"+(i+1));
            int numGastos = lector.nextInt();
            facturas[i] = new float[numGastos];
        }
        
    }
    
    public static void pedirGastosFacturas(){
        for( int i=0; i < facturas.length; i++){
            System.out.println("Introduce los gastos de la factura"+(i+1));
            for (int j = 0; j <facturas[i].length; j++){
                System.out.println("Gasto"+(j+1));
                facturas[i][j]= lector.nextFloat();
            }
        }
        
    }
    
    //METODO PARA INICIALIZAR LAS DOS MATRIZES Y PEDIR LOS DOS METODOS ANTERIORES EN ESTE METODO
    
    public static void inicializoLasDosMatrizes(float[][] facturas,Scanner lector){
        
        
    }
    
    
    
    
    public static void obtenerImportesFacturas(){
        float sumaTotalFacturas = 0;
        float sumaTotalFactura = 0;
        
        for (int i = 0; i < facturas.length; i++) {
            System.out.println("Factura"+(i+1));
            for (int j = 0; j < facturas.length; j++) {
                System.out.println("Gasto"+(j+1));
                sumaTotalFactura += facturas[i][j];
               
            }
            sumaTotalFacturas += sumaTotalFactura;
            System.out.println("Factura"+ (i+1)+ ", total importe: "+sumaTotalFactura+" euros");
            sumaTotalFactura =0;
            
            
        }
        System.out.println("Importe total: "+ sumaTotalFacturas+ "euros");
        
    }
    
    public static void desgloseFactura (int numFactura){
        
        if (numFactura > 0 && numFactura <= facturas.length) {
            
            float[]gastos = facturas[numFactura-1].clone();
            
            int sumaGasto =0;
            
            Arrays.sort(gastos);
            
            System.out.println("Los gasto han sido ordenados");
            for (int i = 0; i < gastos.length; i++) {
                System.out.println(gastos[i]+"euros");
                sumaGasto += gastos[i];
            }
            System.out.println("Factura"+numFactura+"Gastos totales"+ gastos.length+"Importe total de la factura"+sumaGasto);
            
            
        }else{
            System.out.println("Numero de la factura incorrecto");
        }
        
        
    }
    
    
    //quedaria el metodo de buscar gasto con if y else
    
    public static void buscarGasto(float importeGasto){
        String facturasAux = "";
        int contador=0;
        
        for (int i = 0; i < facturas.length; i++) {
            for (int j = 0; j < facturas.length; j++) {
                if ( facturas[i][j]== importeGasto){
                    facturasAux = facturasAux + (i+1)+" ";
                    contador++;
                    break;
                }
                
            }
            
        }
        
        
        
    }
    
    
}
