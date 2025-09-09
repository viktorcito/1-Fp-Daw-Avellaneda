/*
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/UT06_UT07_POO/Enumerados
 * 
 */
package es.daw.enumeradoprogramadores;

import es.daw.enumeradoprogramadores.dao.ProgramadorDAO;
import es.daw.enumeradoprogramadores.model.*;
import es.daw.enumeradoprogramadores.util.Utilidades;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author melol
 */
public class EnumeradoProgramadores {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Pendiente cargar colección de programadores a través del DAO
        ArrayList<Programador> programadores = new ArrayList<>();
        ProgramadorDAO dao = new ProgramadorDAO();
        programadores = dao.select();
        
        boolean salir = false;
        
        
        do {
            System.out.println("");
            Utilidades.pintaMenu();
            
            int opt=0;
            
            if (sc.hasNextInt()){
                opt =sc.nextInt();
            }
            sc.nextLine();
            
            
            switch (opt) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Informacion de todos los programadores");
                    programadores.forEach(System.out::println);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Vas a salir del programa");
                    sc.nextLine();
                    salir = true;
                    break;
                default:
                    System.out.println("Introduce");
            }
            
            
            
        }while(!salir);
        
        
    }
    
    
}
