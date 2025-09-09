/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package palindromo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Palindromo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce una palabra o frase");
        String cadena = sc.nextLine();
        
        if (esPalindromo(cadena)) {
            System.out.println("La drase es palindromo");
        }else{
            System.out.println("La frase no es palindroma");
        }
        
        
    }
    
    
    private static boolean esPalindromo(String frase){
        
        String nuevaFrase = "";
        
        frase = frase.trim();
        
        frase = frase.toLowerCase();
        
        for (int i = 0; i < frase.length(); i++) {
            //char c = frase.charAt(i);
            
            String sub = frase.substring(i,i+1);
            
            if (!sub.isBlank()) {
                sub = sustituirVocalAcentuada(sub);
                nuevaFrase += sub;
            }
            
        }
        
        String inversa = "";
        
        
        for (int i = nuevaFrase.length()-1; i >=0; i--) {
            inversa += nuevaFrase.charAt(i);
        }
        
        
        return nuevaFrase.equals(inversa);
        
    }
    
    
    private static String sustituirVocalAcentuada(String letra){
        
        String nuevaLetra ="";
        
        switch (letra) {
            case "á":
                nuevaLetra = "a";
                break;
            case "é":
                nuevaLetra = "e";
                break;
            case "í":
                nuevaLetra = "i";
                break;
            case "ó":
                nuevaLetra = "o";
                break;
            case "ú":
                nuevaLetra = "u";
                break;
            default:
                nuevaLetra = letra;
        }
        
        
        return nuevaLetra;
        
        
        
    }
    
}
