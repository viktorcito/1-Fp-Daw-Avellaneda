/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.arrayslistonfire;

import es.daw.arrayslistonfire.model.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author VSPC
 */
public class ArrayListApp {

    
    static List<Persona> listPersonas;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        testListPersonas();

        
    }
    
            private static void testListPersonas(){
    
                System.out.println("Ejemplois de ordenacion de arraysList\n");
                
                listPersonas = new ArrayList<>();
                
                
                
                Persona p1 = new Persona("pepe",20);
                Persona p2 = new Persona("Juan",40);
                Persona p3 = new Persona ("Anana",32);
                
                
                
                listPersonas = new ArrayList<>(Arrays.asList(p1,p2,p3));
                
                
                
                System.out.println("");
                listPersonas.forEach(System.out::println);
                
                //LISATADO DE PERSONAS POR NOMBRE
                Comparator<Persona> comparatorByName = (pa,pb)-> pa.getNombre().compareTo(pb.getNombre());
                listPersonas.sort(comparatorByName);
}
            
            private static void borraPersonasConEdadPar(){
                
                Iterator<Persona> it =listPersonas.iterator();
                while(it.hasNext()){
                    Persona p= it.next();
                    if(p.getEdad()%2==0){
                    it.remove();
                }
                }
                
            }
    
}
