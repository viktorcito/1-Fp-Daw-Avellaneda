/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import static facturagasto.FacturaGasto.facturas;
import static facturagasto.FacturaGasto.lector;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author VSPC
 */
public class Utilidades {
    
    public static void inicializaFacturas(){
        
        for(int i=0; i < facturas.length; i++){
            System.out.println("Indica el numero de gastos de la factura <"+(i+1)+">");
            int numGastos = lector.nextInt();
            facturas[i]= new float [numGastos];
        }
    }
    
    public static void pedirGastosFacturas(){
        for (int i=0; i < facturas.length; i++){
            System.out.println("*Introduce los gastos de la factura<"+(i+1)+">");
            for(int j = 0; j < facturas[i].length; i++){
                System.out.println("\t *Gasto <"+(j+1)+"> :");
                facturas [i][j] = lector.nextFloat();
            }
        }
    }
    
    public static void pintaMenu(){
        System.out.println("****MENU****");
        System.out.println("1. Informe completo");
        System.out.println("2. Informe factura");
        System.out.println("3. Buscar gasto");
        
        System.out.println("4. Salir");
        System.out.println("Elige una opcion: ");
        
        
    }
    
    
    public static void obtenerImportesFacturas(){
        float sumaTotalFacturas = 0;
        float sumaTotalFactura = 0;
        
        for (int i=0; i<facturas.length;i++){
            System.out.println("\tFactura ("+(i+1)+"): ");
            for (int j=0; j<facturas[i].length;i++){
                System.out.println("\tGasto ("+(j+1)+"): "+ facturas[i][j]);
                sumaTotalFactura += facturas[i][j];
            }
            sumaTotalFacturas +=sumaTotalFactura;
            System.out.println("Factura"+(i+1)+",total importe: "+sumaTotalFactura+"euros.");
            sumaTotalFactura =0;
            
        }
        System.out.println("Importe total:"+sumaTotalFacturas+"euros.");
        
        
    }
    
    public static void desgloseFactura (int numFactura){
        if (numFactura > 0 && numFactura <= facturas.length){
            
            float [] gastos = facturas[numFactura -1].clone();
            int sumaGastos=0;
            
            Arrays.sort(gastos);
            
            System.out.println("Gatos ordenados de mayor a menor:");
            
            System.out.println("Factura"+numFactura+": numero totales de gastos <" +gastos.length+">. Importe total de la factura <");
        }
        
    }
    
    public static void buscarGasto (float importeGasto){
        String facturasAux ="";
        int contador =0;
        
        
        for (int i =0;i<facturas.length;i++){
            for (int j=0; j<facturas[i].length;j++){
                if(facturas[i][j]==importeGasto){
                    facturasAux = facturasAux + (i+1)+"";
                    contador++;
                    break;
                }
            }
        }
        if (contador==0)
            System.out.println("No se encuentra ningun gasto con importe de "+importeGasto+"euros.");
        else{
            if (contador==1)
                System.out.println("El gasto con importe de" +importeGasto+"euros se encuentra en la factura <"+facturasAux+">");
            else
                System.out.println("El gasto con importe de "+importeGasto+"euros se encuentra en las facturas <"+ facturasAux+">");
        }
    }
    
    
}
