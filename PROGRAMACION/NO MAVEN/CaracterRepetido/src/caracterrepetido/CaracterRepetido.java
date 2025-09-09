/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caracterrepetido;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author VSPC
 */
public class CaracterRepetido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Instroduzca la cadena a verficar");
        String str = sc.nextLine();
        
        boolean repetido = false;
        
        char caracterRepetido = ' ';
        
        for (int i = 0; i < str.length() && !repetido; i++) {
            char c = str.charAt(i);
            
            for (int j = i+1; j < str.length() && !repetido; j++) {
                if (c == str.charAt(j)) {
                    repetido = true;
                    caracterRepetido = c;
                }
            }
        }
        
        if (repetido) {
            System.out.println("El primer caracter repetido es"+ caracterRepetido);
        }else{
            System.out.println("No hay ningun caracter repetido");
        }
        sc.close();
        
        /*       
        String cadena = "abcdefa";
        char primerRepetido = encontrarPrimerRepetido(cadena);

        if (primerRepetido != '\0') {
            System.out.println("El primer carácter repetido es: " + primerRepetido);
        } else {
            System.out.println("No hay caracteres repetidos en la cadena.");
        }*/
    }
    
    
    /*
    public static char encontrarPrimerRepetido(String cadena) {
        Set<Character> caracteresVistos = new HashSet<>();

        for (char c : cadena.toCharArray()) {
            if (caracteresVistos.contains(c)) {
                return c;
            }
            caracteresVistos.add(c);
        }

        return '\0';
        
    }*/
    
    
    
    
}
