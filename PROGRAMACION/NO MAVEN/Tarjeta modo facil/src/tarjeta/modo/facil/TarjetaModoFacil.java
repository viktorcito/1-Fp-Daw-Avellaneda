/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarjeta.modo.facil;

import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Tarjeta;
import util.Utilidades;

/**
 *
 * @author VSPC
 */
public class TarjetaModoFacil {

    public static Scanner lector = new Scanner(System.in);
    public static Tarjeta[] tarjetas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Tarjeta t1 = new Tarjeta("6565","Mari",500);
        
        String numTarjetas1 = JOptionPane.showInputDialog("Introduce el numero dadas de alta");
        int numTarjetas = Integer.parseInt(numTarjetas1);
        
        tarjetas = new Tarjeta[numTarjetas];
        
        
        
        

        int opcion = 0;
        while (opcion != 6) {

            Utilidades.pintaMenu();
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    Utilidades.darAltaTarjetas();
                    break;
                case 2:
                    Utilidades.darInformacionTarjetas();
                    break;
                case 3:
                    System.out.println("Introduce bien el numero porfavor");
                    String num = lector.next();
                    Utilidades.mostrarinformacionPorNumero(num);
                    break;
                case 4:
                    System.out.println("Pasame el importe");
                    float importe = lector.nextFloat();
                    System.out.println("Tarjeta con la que vas a pagar");
                    tarjetas[lector.nextInt()].pagar(importe);
                    break;
                case 5:
                    System.out.println("Desactivamos");
                    tarjetas[0].desactivarTarjeta();
                    break;
                case 6:
                    System.out.println("pulsa par salir del programa");
                    break;
                default:
                    System.out.println("has elegido la opcion incorrecta");

            }

        }

    }

}
