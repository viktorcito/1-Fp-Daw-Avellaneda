package es.daw.pasapalabra;

import es.daw.pasapalabra.util.Utilidades;
import es.daw.pasapalabra.util.Palabras;
import java.util.Scanner;

public class Pasapalabra {

    static Scanner sc = new Scanner(System.in);
    public static String[] letras = Palabras.devuelveLetras();
    public static int ronda;

    public static void main(String[] args) {
        int aciertos = 0;
        int errores = 0;

        for (ronda = 1; ronda <= 3; ronda++) {
            Utilidades.mostrarPanel();
            System.out.println("*************************");
            System.out.println("COMIENZO RONDA : " + ronda);
            System.out.println("*************************\n");

            for (int i = 0; i < Palabras.devuelveDefiniciones().length; i++) {
                if (errores == 5) {
                    break;
                }

                if (letras[i].equalsIgnoreCase("*")) {
                    continue;
                }

                System.out.println(Palabras.devuelveDefiniciones()[i] + "que empieza con la letra: " + letras[i]);
                String entrada = sc.nextLine();
                boolean acertado = false;

                if (entrada.equalsIgnoreCase("PASAPALABRA")) {
                    continue;

                }

                if (entrada.equalsIgnoreCase(Palabras.devuelveSoluciones()[i])) {
                    acertado = true;

                }

                if (acertado) {
                    aciertos++;
                    letras[i] = "*";
                    System.out.println("\nHAS ACERTADO!!!\n");
                } else {
                    errores++;
                    System.out.println("\nHAS FALLADO :(!\n");
                }
                System.out.println("LLEVAS ACUMULADOS ACIERTOS: " + aciertos + " | ERRORES : " + errores + "\n");
                Utilidades.mostrarPanel();

            }

            if (letras.length == aciertos || 5 == errores) {
                System.out.println("PUNTUACION!!!: " + Utilidades.calcularPuntuacion(aciertos, errores, ronda));
                break;

            }

        }
        Utilidades.mostrarPanel();
        Utilidades.mostrarRondaFinal(aciertos, errores, ronda);

    }

}
