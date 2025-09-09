/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.patatoncioCaliente;

import es.daw.patatoncioCaliente.Util.Utilidades;
import static es.daw.patatoncioCaliente.Util.Utilidades.generarPreguntaAleatoria;
import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int puntuacionTotal = 0;
        int preguntasAcertadas = 0;
        int preguntasFallidas = 0;
        int aciertosSinIntentos = 0;
        int juegosJugados = 0;

        int opcion;

        do {
            Utilidades.mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    juegosJugados++;

                    for (int juego = 0; juego < 5; juego++) {
                        int nivel = Utilidades.elegirNivel();

                        int intentos;
                        if (nivel == 1) {
                            intentos = 10;
                        } else if (nivel == 2) {
                            intentos = 5;
                        } else {
                            intentos = 2;
                        }

                        int respuestaCorrecta = generarPreguntaAleatoria(juego);
                        int puntuacionPregunta = Utilidades.jugarPregunta(respuestaCorrecta, intentos, nivel);
                        puntuacionTotal += puntuacionPregunta;

                        if (puntuacionPregunta > 0) {
                            preguntasAcertadas++;
                            if (puntuacionPregunta == 100 || puntuacionPregunta == 200 || puntuacionPregunta == 500) {
                                aciertosSinIntentos++;
                            }
                        } else {
                            preguntasFallidas++;
                            break;
                        }

                        if (aciertosSinIntentos >= 3) {
                            Utilidades.mostrarEasterEgg(aciertosSinIntentos);
                        }
                    }

                    break;

                case 2:
                    Utilidades.mostrarInstrucciones();
                    break;

                case 3:
                    if (juegosJugados == 0) {
                        System.out.println("\nTI@ YA TE RINDES PFFFFF....");
                    } else {
                        Utilidades.mostrarResultados(puntuacionTotal, preguntasAcertadas, preguntasFallidas);
                        Utilidades.mostrarEasterEgg(aciertosSinIntentos);
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Elige una opción del menú.");
                    break;
            }
        } while (opcion != 3);

        
    }

}
