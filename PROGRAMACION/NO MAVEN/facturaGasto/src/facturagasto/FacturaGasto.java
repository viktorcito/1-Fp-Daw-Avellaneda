/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facturagasto;

import java.util.Scanner;
import javax.swing.JOptionPane;
import util.Utilidades;
/**
 *
 * @author VSPC
 */
public class FacturaGasto {

    
    public static Scanner lector = new Scanner(System.in);
    
    public static float[][] facturas;
    
    
    
    
    public static void main(String[] args) {
        
        String numFacturas1 = JOptionPane.showInputDialog("Introduce el numero de facturas");
        int numFacturas = Integer.parseInt(numFacturas1);
        
        
        facturas = new float [numFacturas][];
        
        Utilidades.inicializaFacturas();
        
        Utilidades.pedirGastosFacturas();
        
        int opcion =0;
        while(opcion != 4){
            
            
            Utilidades.pintaMenu();
            opcion = lector.nextInt();
            
            switch (opcion){
                case 1:
                    Utilidades.obtenerImportesFacturas();
                    break;
                case 2:
                    System.out.println("Indica el numero de factura");
                    Utilidades.desgloseFactura(lector.nextInt());
                    break;
                case 3:
                    System.out.println("indica el importe del gasto que queires buscar");
                    Utilidades.buscarGasto(lector.nextFloat());
                    break;
                case 4:
                    System.out.println("Vas a salir del programa");
                    break;
                    
                default :
                    System.out.println("Has elegido una opcion incorrecta. Prueba de nuevo.");
                                       
            }
                   
        }
        
        
        
    }
    
}
