/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioarray4;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class EjercicioArray4 {

    static Scanner sc = new Scanner(System.in);
    static String[] palabras = {"uno", "dos", "tres"};
    
    public static void main(String[] args) {
        
                preguntaPalabra();
    }

    static void preguntaPalabra() {
        System.out.println("Adivina una de mis palabras:");
        String entrada = sc.nextLine();
        boolean acertado = false;

        for (String palabra : palabras) {
            if (entrada.equalsIgnoreCase(palabra)) {
                acertado = true;
                break;
            }
        }
        
        int i=0;
        
        /*
        while(!acertado && i < palabras.length){
            if(entrada.equalsIgnoreCase(palabras[i])){
                acertado = true;
            }
            i++;
        }*/
        
        /*while( !entrada.equalsIgnoreCase(palabras[i]) && (i < palabras.length)){
            i++;
        }
        
        if (i < palabras.length) acertado = true;*/
        
        
        
        if (acertado) {
            System.out.println("HAS ACERTADO!!!");
        } else {
            preguntaSeguir();
        }
        
        
    }

    static void preguntaSeguir() {
        System.out.println("Ohh...Has fallado.\n ¿Quires seguir jugando? ('Y', 'N'");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("Y")) {
            preguntaPalabra();
        }
    }

}

