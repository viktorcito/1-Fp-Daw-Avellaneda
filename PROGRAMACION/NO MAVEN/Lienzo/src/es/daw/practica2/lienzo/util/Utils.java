/**
 * Clase que contiene métodos estáticos (funciones) de uso general de la aplicación
 */
package es.daw.practica2.lienzo.util;

import java.util.Scanner;

/**
 *
 * @author melol
 */
public class Utils {


    /**
     * Función para sacar el menú de opciones
     */
    public static void menuOpciones() {
        System.out.println("Selecciona la operación que desea realizar:");
        System.out.println(" 1 - Dibujar líneas");
        System.out.println(" 2 - Dibujar cuadrado");
        System.out.println(" 3 - Cubo de pintura");
        System.out.println(" 4 - Deshacer");
        System.out.println(" 5 - Historial");
        System.out.println(" 6 - Limpiar");
        System.out.println(" 7 - Salir");

    }

    /**
     * Método que lee del teclado y comprueba si es un enter
     * @return verdadero si es un enter
     */
    public static boolean leerEnter(){
        Scanner teclado = new Scanner(System.in);
        //Comparación para saber si se presiono Enter
        if (teclado.nextLine().isEmpty()) return true;
        else return false;
        
    }
    
    
    /**
     * Método que lee del teclado y devuelve un carácter
     * @return el carácter introducido
     */
    public static char leerCaracter(){
        Scanner teclado = new Scanner(System.in);
        return teclado.next().charAt(0);
    }

    /**
     * Método que lee del teclado y devuelve una cadena de texto
     * @return la cadena introducida
     */
    public static String leerCadena(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    /**
     * Método que lee del teclado y devuelve un entero
     * @return el entero introducido
     */
    public static int leerEntero(){
        Scanner teclado = new Scanner(System.in);
        while (!teclado.hasNextInt()) {
            System.out.println("Por favor, introduce un número entero válido.");
            teclado.next(); // Limpiar el buffer
        }
        return teclado.nextInt();
    }
            
}
