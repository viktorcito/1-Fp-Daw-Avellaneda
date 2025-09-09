/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio13_refuerzo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Ejercicio13_Refuerzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float numero1, numero2;
        
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Escribe el primer numero: ");
        numero1 = entrada.nextFloat();
        
        System.out.println("Escribe el segundo numero: ");
        numero2 = entrada.nextFloat();
        
        System.out.println("El orden es: ");
        
        if (numero1 > numero2)
            System.out.println(numero1 + " , " + numero2);
        
        else
            System.out.println(numero2 + " , " + numero1);
        
    }
    
}
