package es.daw.pasapalabra.util;

import es.daw.pasapalabra.Pasapalabra;
import java.util.Scanner;

public class Utilidades {

    static Scanner sc = new Scanner(System.in);

    public static void mostrarPanel() {

        //Imprimimos por consola el menú
        System.out.println(" LETRAS DEL JUEGO: ");
        for (String letra : Pasapalabra.letras) {
            System.out.print("[" + letra + "]");
        }
        System.out.println("\n"); //Este caracter especial nos permite imprimir una línea en blanco

    }

    public static void mostrarRondaFinal(int aciertos, int errores, int ronda){
            System.out.println("FINALIZADA LA RONDA NUMERO: "+ ronda);
            System.out.println("Numero de aciertos: " + aciertos);
            System.out.println("Numero de errores: " + errores);
            System.out.println("HA TERMINADO LA RONDA " + ronda + " EL JUEGO HA ACABADO.");
            System.out.println("HAS OBTENIDO " + Utilidades.calcularPuntuacion(aciertos, errores, ronda) + " PUNTOS"); 
    }

    public static int calcularPuntuacion(int aciertos, int errores, int ronda) {

        int puntuacion = aciertos * 2 - errores;

        if (aciertos == Palabras.devuelveLetras().length) {
            switch (ronda) {
                case 1:{
                    puntuacion = aciertos * 2 - errores +30;
                    break;
                }
                case 2:{
                    puntuacion = aciertos * 2 - errores +15;
                    break;
                }
                case 3:{
                    puntuacion = aciertos * 2 - errores +5;
                    break;
                }
            }
        }

        return puntuacion;
    }

}
