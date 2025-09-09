/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio8_refuerzo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Ejercicio8_Refuerzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int edad;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduce la edad ");
        edad = entrada.nextInt();
        
        if (edad >= 18)
            System.out.println("Es mayor de edad ");
        
        else 
            System.out.println("Eres menor ");
        
        
    }
    
}
