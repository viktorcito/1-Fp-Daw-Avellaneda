/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.poo.alquilerVehiculos;


import es.daw.poo.alquilerVehiculos.util.Utilidades;
import static es.daw.poo.alquilerVehiculos.util.Utilidades.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class AlquilerApp {

    static Scanner sc = new Scanner(System.in);
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int op;

        do {

            Utilidades.mostrarMenu();
            op = sc.nextInt();

            switch (op) {
                case 1:
                    añadirVehiculo();
                    break;
                case 2:
                    alquilarVehiculo();
                    break;
                case 3:
                    informeFlota();
                    break;
                case 4:
                    informeNoAlquilado();
                    break;
                case 5:
                    informeAlquilado();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("No has introducido una opcion correcta");
            }

        } while (op != 6);

    }
    
    
    
    

}
