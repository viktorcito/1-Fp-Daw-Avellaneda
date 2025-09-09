/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7_refuerzo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Ejercicio7_Refuerzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double M = 1.852, numeroM;
        
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Introduce el numero de millas que quieres convertir: ");        
        numeroM = entrada.nextDouble();
        
        numeroM = M * numeroM;
        
        System.out.println("Los metros son: " + numeroM);
    }
    
}
