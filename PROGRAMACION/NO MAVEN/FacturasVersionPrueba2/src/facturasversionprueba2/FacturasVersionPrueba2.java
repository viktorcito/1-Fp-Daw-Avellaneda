/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facturasversionprueba2;

import Util.Utilidades;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author VSPC
 */
public class FacturasVersionPrueba2 {

    public static float[][] facturas;
    public static Scanner lector = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String numFacturas1 = JOptionPane.showInputDialog("Introduce el numero de facturas");
        int numFacturas = Integer.parseInt(numFacturas1);

        facturas = new float[numFacturas][];

        // inicializo el array
        // se rellena el array de arrays
        Utilidades.inicializaFacturas();
        Utilidades.pedirGastosFacturas();
        
        
        int opcion = 0;
        while (opcion != 4) {

            Utilidades.pintaMenu();
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    Utilidades.obtenerImportesFacturas();
                    break;
                case 2:
                    System.out.println("Indica el numero de factura");
                    Utilidades.desgloseFactura(lector.nextInt());
                    break;
                case 3:
                    System.out.println("Indica el importe del gasto");
                    Utilidades.buscarGasto(lector.nextInt());
                    break;
                case 4:
                    System.out.println("Vas a salir del programa");
                    break;
                default:
                    System.out.println("Vuelcve a probar");
            }

        }

    }

}
