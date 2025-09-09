/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentavocales;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class CuentaVocales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca una cadena");
        String cadena = sc.nextLine();
        
        String minusculas = cadena.toLowerCase();
        
        int cantidadVocales = 0;
        
        for (int i = 0; i < minusculas.length(); i++) {
            char c = minusculas.charAt(i);
            
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cantidadVocales++;
            }
        }
        
        System.out.println("La cantidad de vocales es:" + cantidadVocales);
        
        sc.close();
    }
    
}
