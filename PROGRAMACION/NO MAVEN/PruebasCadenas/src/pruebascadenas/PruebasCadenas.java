/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebascadenas;

import java.util.Scanner;



/**
 *
 * @author VSPC
 */
public class PruebasCadenas {
    
        static boolean longitudCorrecta = false;
        static boolean tieneMay = false;
        static boolean tieneMin = false;
        static boolean tieneCharRaro = false;
        static boolean tieneNumero = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce una contraseña");
        String pwd = sc.nextLine();
        
        boolean correcta = isValidPwd(pwd);
        
        if (correcta) {
            System.out.println("Es correcta");
        }else{
            System.out.println("La contraseña no es valida");
            if(!longitudCorrecta)
                System.out.println("No tiene una longitud entre 8 y 20");
            if (!tieneMay)
                System.out.println("No tiene por lo menos una letra May");
            if (!tieneMin)
                System.out.println("No tiene por lo menos una letra Min");
            if (!tieneCharRaro)
                System.out.println("No tiene ni % $ _ *");
            if (!tieneNumero)
                System.out.println("No tiene por lo menos un número");
          
            
        }
           /*En este ejercicio la primera vez en vez de las variables globales las puse en el metodo y hice el else de
           de los if del metodo para decir que no tiene los requisitos que pide la contraseña*/
        
    }
    
    public static boolean isValidPwd(String password){
        
        
        
        if (password.length() >=8 && password.length() <= 20) {
            longitudCorrecta = true;
            
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                
                
                if (Character.isUpperCase(c)) {
                    tieneMay = true;
                }if (Character.isLowerCase(c)) {
                    tieneMin = true;
                }if (Character.isDigit(c)) {
                    tieneNumero = true;
                }if (c == '$'||c == '%'||c == '_'||c == '*') {
                    tieneCharRaro = true;
                }
 
            }
            
        }
        
        
        return (longitudCorrecta && tieneMay && tieneMin && tieneNumero && tieneCharRaro );
        
    }
    
}
