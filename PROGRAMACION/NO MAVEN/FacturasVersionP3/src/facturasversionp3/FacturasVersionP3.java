/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package facturasversionp3;

import Util.Utilidades;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author VSPC
 */
public class FacturasVersionP3 {

    public static Scanner lector = new Scanner(System.in);
    public static float facturas[][];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String numFacturas1 = JOptionPane.showInputDialog("Introduce el numero de facturas");
        int numFacturas = Integer.parseInt(numFacturas1);

        facturas = new float[numFacturas][];

        //hueco por si tenemos que inicializar o rellenar cosas
        Utilidades.inicializaFacturas();
        Utilidades.pedirGastosFacturas();
        
        
        int option = 0;
        while (option != 4) {

            Utilidades.pintaMenu();
            option = lector.nextInt();

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("vas a salir del programa");
                    break;
                default:
                    System.out.println("Elige la opcion correcta bien");

            }

        }

    }

}
