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
import javax.naming.LimitExceededException;

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
        
        
        // PENDIENTE COMPLETAR
        ProgramadorDAO dao = new ProgramadorDAO();
        programadores = dao.select();
        
        boolean salir = false;
        
        do{
            System.out.println("");
            Utilidades.pintaMenu();
            
            int opt=0;
            
            if(sc.hasNextInt())
                opt = sc.nextInt();
            
            sc.nextLine();
            
            switch (opt) {
                case 1:
                    try {
                    
                } catch (LimitExceededException ex) {
                    
                }
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Informacion de todos los progrmadores");
                    programadores.forEach(System.out::println);
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Elige una opcion");
                    break;
                case 6:
                    System.out.println("en obras....");
                    break;
                case 7:
                    System.out.println("Informe de juniors");
                    break;
                case 8:
                    System.out.println("vas a salir del programa");
                    sc.nextLine();
                    salir=true;
                    break;
                default:
                    System.out.println("elige una opcion");
                    break;
            }
            
        }while(!salir);
        
        
    }
    
    
}
