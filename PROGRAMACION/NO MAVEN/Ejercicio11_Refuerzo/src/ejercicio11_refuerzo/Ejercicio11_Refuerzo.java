/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio11_refuerzo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Ejercicio11_Refuerzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        float numero1, numero2, numero3;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Escribe numero 1: ");
        numero1 = entrada.nextFloat();

        System.out.println("Escribe numero 2: ");
        numero2 = entrada.nextFloat();
        
        System.out.println("Escribe numero 3: ");
        numero3 = entrada.nextFloat();

        if (numero1 > numero2) {
            
            if( numero1 > numero3)
                System.out.println("El mayor es: " + numero1);
            else
                System.out.println("El mayor es: " + numero3);
        }
        
        if (numero2 > numero1) {
            if (numero2 > numero3)
                System.out.println("El mayor es: " + numero2);
            else
                System.out.println("El mayor es: " + numero3);
        }
    }

}
