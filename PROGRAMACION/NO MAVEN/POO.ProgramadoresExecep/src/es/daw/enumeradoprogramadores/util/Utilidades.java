package es.daw.enumeradoprogramadores.util;

import static es.daw.enumeradoprogramadores.EnumeradoProgramadores.sc;
import es.daw.enumeradoprogramadores.excepciones.LimiteEdadExcepcion;
import es.daw.enumeradoprogramadores.model.Lenguajes;
import es.daw.enumeradoprogramadores.model.Programador;
import java.util.ArrayList;
import javax.naming.LimitExceededException;

/**
 *
 * @author melol
 */
public class Utilidades {
    
    public static void pintaMenu(){
        
        System.out.println("************** MENÚ PRINCIPAL ***************");
        System.out.println("1.- Dar de alta un programador");
        System.out.println("2.- Consultar información de programador (por DNI)");
        System.out.println("3.- Consultar información de todos los programadores");
        System.out.println("4.- Eliminar un programador de la lista (por DNI)");
        System.out.println("5.- Número total de programadores expertos en un lenguaje concreto");
        System.out.println("6.- Salir");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Elige una opción:");
        
    }
        
        
        public static void darProgramadorAlta(ArrayList<Programador> programadores) throws LimiteEdadExcepcion {
            System.out.println("Vas a dar de alta un nuevo programador:");
            System.out.println("1. Escribe el DNI");
            String dni = sc.nextLine();
            System.out.println("2 Escribe el nombre");
            String nombre = sc.nextLine();
            
            
            System.out.println("3 escribe la edad");
            int edad = sc.nextInt();
            
            sc.nextLine();
            System.out.println("4. Escribe lenguaje de programacion");
            
            
            Lenguajes[] lenguajes = Lenguajes.values();
            
            for (int i = 0; i < lenguajes.length; i++) {
                 Lenguajes l = lenguajes[i];
                 System.out.println(l.name());
            }
            
            System.out.println("-------------");
            Lenguajes leng = Lenguajes.UNDEFINED;
            
            
            String lenguaje = "";
            try {
                lenguaje = sc.nextLine();
                leng = Lenguajes.valueOf(lenguaje);
            } catch (IllegalArgumentException ex) {
                System.out.println("Aviso El lp no esta soportado. Se va a asignar el lenguaje"+ Lenguajes.UNDEFINED);
                System.err.println("[ERROR] Se da de alta un programador con un lenguaje no reconocido por el sistema. El lenguaje fallido es "+lenguaje);
            }
            
            System.out.println("5 Escribe los años de experiencia");
            int anios = sc.nextInt();
            
            if (edad >= 18 && edad < 23){
                
            
            throw new LimiteEdadExcepcion(dni, edad, leng);
            }
        
        Programador p = new Programador(dni, nombre, edad, leng, anios);
        programadores.add(p);
            
        }
        
    
        private static int getPosicionProgramadorEnLista(ArrayList<Programador> programadores){
        System.out.println("Indica el DNI del programador:");
        String dni = sc.nextLine();
        
        Programador p = new Programador(dni);
        return programadores.indexOf(p);

        
    }
    /**
     * OPCIÓN 3 DEL MENÚ
     * Eliminar un programador de la lista (por DNI)
     */
    public static void eliminarProgramadorById(ArrayList<Programador> programadores){
        int posicion = getPosicionProgramadorEnLista(programadores);
        if ( posicion != -1){
            programadores.remove(posicion).toString();
            System.out.println("Programador borrado");
        }
        else
            System.out.println("No existe el programador");
        
    }
       
        
        
    
}
