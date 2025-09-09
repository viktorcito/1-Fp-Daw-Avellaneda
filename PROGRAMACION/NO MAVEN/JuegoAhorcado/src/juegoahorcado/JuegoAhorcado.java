/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegoahorcado;


import Utilidades.Util;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class JuegoAhorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String palabraSecreta = Util.darPalabraSecreta();  
        char[] palabraGuiones = Util.darGuionesPalabras(palabraSecreta);
        boolean juegoTerminado = false;
        Scanner sc = new Scanner(System.in);
        int intentos = 3;
        do{
            System.out.println(palabraGuiones);
            System.out.println("Introduce una letra ");
            char letra = sc.next().charAt(0);
            boolean algunaLetraAcertada = false;
            for (int i=0;i<palabraSecreta.length();i++){
                if (palabraSecreta.charAt(i)== letra){
                    palabraGuiones[i] = letra;
                    algunaLetraAcertada = true;
                }
                
            }        
            
              if (!algunaLetraAcertada){
                  System.out.println("No has acertado ninguna letra");
                  --intentos;
              if (intentos ==0){
                  System.out.println("has perdido el juego");
                  intentos =3;
                  break;
                  
              }
              }
              else {
                  boolean juegoGanado = !Util.hayGuiones(palabraGuiones);
                  if (juegoGanado){
                      System.out.println("Has ganado el juego");
                      juegoTerminado = true;
                  }
              }
        }while(!juegoTerminado);
        
        
        sc.close();
    }
    
}

