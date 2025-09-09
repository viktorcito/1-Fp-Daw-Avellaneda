/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clonado;

import java.util.ArrayList;
import java.util.Arrays;
import model.Persona;

/**
 *
 * @author VSPC
 */
public class Clonado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        pruebasPersonasClonadas();
        
    }
    
    
    private static void pruebasPersonasClonadas(){
    ArrayList<Persona> personas = new ArrayList<>();
    
    Persona p1= new Persona("few",21);
    Persona p2= new Persona("dfewd",34);
    Persona p3= new Persona("weq",43);
    
    //personas.add(p1);
    
    
    personas = new ArrayList<>(Arrays.asList(p1,p2,p3));
    
    
        System.out.println("********");
        System.out.println("Lista de personas originales");
        
       personas.forEach(System.out::println);
        System.out.println("**************");
        
        
        ArrayList<Persona> personas2 =deepClone(personas);
    }

    private static ArrayList<Persona> deepCloneArtesanal(ArrayList<Persona> personasOriginal) {
        ArrayList<Persona> PersonasClonadas = new ArrayList<Persona>();
        
        for (Persona Persona p : personasOriginal) {
           
            
        }
        return
    }
}
