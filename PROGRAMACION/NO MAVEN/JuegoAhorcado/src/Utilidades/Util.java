/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.util.Random;
import juegoahorcado.JuegoAhorcado;
/**
 *
 * @author VSPC
 */
public class Util {
    
    public static String darPalabraSecreta(){
    
        String [] palabras = {"anita","collar","ordenador","kuki"};
        
        Random ruu = new Random();
        int num = ruu.nextInt(palabras.length);
        
        return palabras[num];
              
}
    
    public static char[] darGuionesPalabras(String palabra){
       
        
        int numLetrasPalabraSecreta = palabra.length();
        
        char [] palabraGuiones = new char [numLetrasPalabraSecreta];
        
        for (int i=0;i<palabraGuiones.length;i++){
            palabraGuiones[i] = '_';
            
            
        } 
        return palabraGuiones;
        
    }
    
    public static boolean hayGuiones (char [] array){
        for(char le:array){
        if (le=='_')return true;
    }
       return false;
    }
    
}
