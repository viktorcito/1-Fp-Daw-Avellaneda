/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.patatoncioCaliente.Util;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author VSPC
 */
public class Utilidades {

    public static void mostrarMenu() {

        System.out.println(" ____   ____  ______   ____  ______   ___   ____     __  ____  ___          __   ____  _      ____    ___  ____   ______    ___ \n"
                + "|    \\ /    ||      | /    ||      | /   \\ |    \\   /  ]|    |/   \\        /  ] /    || |    |    |  /  _]|    \\ |      |  /  _]\n"
                + "|  o  )  o  ||      ||  o  ||      ||     ||  _  | /  /  |  ||     |      /  / |  o  || |     |  |  /  [_ |  _  ||      | /  [_ \n"
                + "|   _/|     ||_|  |_||     ||_|  |_||  O  ||  |  |/  /   |  ||  O  |     /  /  |     || |___  |  | |    _]|  |  ||_|  |_||    _]\n"
                + "|  |  |  _  |  |  |  |  _  |  |  |  |     ||  |  /   \\_  |  ||     |    /   \\_ |  _  ||     | |  | |   [_ |  |  |  |  |  |   [_ \n"
                + "|  |  |  |  |  |  |  |  |  |  |  |  |     ||  |  \\     | |  ||     |    \\     ||  |  ||     | |  | |     ||  |  |  |  |  |     |\n"
                + "|__|  |__|__|  |__|  |__|__|  |__|   \\___/ |__|__|\\____||____|\\___/      \\____||__|__||_____||____||_____||__|__|  |__|  |_____|\n"
                + "                                                                                                                                ");
        System.out.println("Bienvenido al juego desarrollado por VICTOR GARCIA SANTOS");
        System.out.println("\nMenú:");
        System.out.println("1. Elegir nivel");
        System.out.println("2. Leer las instrucciones");
        System.out.println("3. Salir del programa\n");
        System.out.print("Selecciona una opción: \n");

    }

    public static void mostrarInstrucciones() {
        System.out.println("\nInstrucciones del Juego:");
        System.out.println("=================================");
        System.out.println("Bienvenido al juego de adivinanza.");
        System.out.println("El objetivo del juego es adivinar la respuesta correcta a una serie de preguntas.");
        System.out.println("Tienes un número limitado de intentos para cada pregunta, dependiendo del nivel que elijas.");
        System.out.println("Cada respuesta correcta te otorgará una puntuación.");
        System.out.println("El puntaje se calcula en función de cuántos intentos utilizaste y el nivel de dificultad.");
        System.out.println("Niveles de dificultad:");
        System.out.println("1. Nivel inicial: 10 intentos.");
        System.out.println("2. Nivel medio: 5 intentos.");
        System.out.println("3. Nivel avanzado: 2 intentos.");
        System.out.println("Si adivinas la respuesta a la primera, obtendrás 100 puntos.");
        System.out.println("Por cada intento adicional, se restarán 10 puntos de la puntuación.");
        System.out.println("Si adivinas todas las respuestas sin gastar intentos, desbloquearás un Easter Egg sorpresa.");
        System.out.println("¡Diviértete y demuestra tus conocimientos!\n");

    }

    public static int elegirNivel() {

        /** SI TE DA ALGUN ERROR UTILIZAR VERSION FULL CONSOLA
         * Scanner scanner = new Scanner(System.in); System.out.println("\n1.
         * Nivel inicial"); System.out.println("2. Nivel medio");
         * System.out.println("3. Nivel avanzado"); System.out.print("Elige un
         * nivel: \n"); int nivel = scanner.nextInt();
         *
         * if (nivel < 1 || nivel > 3) { System.out.println("Nivel no válido. Se
         * asignará el nivel inicial con 10 intentos."); return 1; }
         *
         * return nivel;
         */
        
        //VERSION PANELES
        String[] opciones = {"Nivel Inicial", "Nivel Medio", "Nivel Avanzado"};
        int nivel = JOptionPane.showOptionDialog(null, "Elige un nivel", "Niveles", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]) + 1;

        if (nivel < 1 || nivel > 3) {
            JOptionPane.showMessageDialog(null, "Nivel no válido. Se asignará el nivel inicial con 10 intentos.");
            return 1;
        }

        return nivel;
    }

    public static int jugarPregunta(int respuestaCorrecta, int intentos, int nivel) {
        Scanner scanner = new Scanner(System.in);
        int puntuacion = 0;
        int intentosUsados = 0;

        for (int i = 0; i < intentos; i++) {
            System.out.print("Intenta adivinar la respuesta: ");
            int respuestaUsuario = scanner.nextInt();
            intentosUsados++;

            if (respuestaUsuario == respuestaCorrecta) {
                if (i == 0) {
                    puntuacion = 100;
                } else {
                    puntuacion = 100 - i * 10;
                }

                if (nivel == 2) {
                    puntuacion *= 2;
                } else if (nivel == 3) {
                    puntuacion *= 5;
                }

                System.out.println("¡Respuesta correcta! Has utilizado " + intentosUsados + " intento(s).");
                System.out.println("Puntuación obtenida: " + puntuacion);
                break;
            } else {
                if (i < intentos - 1) {
                    System.out.println("Respuesta incorrecta. Te quedan " + (intentos - i - 1) + " intento(s).");
                    if (respuestaUsuario > respuestaCorrecta) {
                        System.out.println("La respuesta es menor.\n");
                    } else {
                        System.out.println("La respuesta es mayor.\n");
                    }
                } else {
                    System.out.println("\n¡        ) (   (       )  (   (       )     )  \n"
                            + "     ( /( )\\ ))\\ ) ( /(  )\\ ))\\ ) ( /(  ( /(  \n"
                            + " (   )\\()|()/(()/( )\\())(()/(()/( )\\()) )\\()) \n"
                            + " )\\ ((_)\\ /(_))(_)|(_)\\  /(_))(_)|(_)\\ ((_)\\  \n"
                            + "((_)__((_|_))(_))   ((_)(_))(_))   ((_) _((_) \n"
                            + "| __\\ \\/ / _ \\ |   / _ \\/ __|_ _| / _ \\| \\| | \n"
                            + "| _| >  <|  _/ |__| (_) \\__ \\| | | (_) | .` | \n"
                            + "|___/_/\\_\\_| |____|\\___/|___/___| \\___/|_|\\_| \n"
                            + "                                              ! Has agotado los intentos.\n");
                    puntuacion = 0;
                    break;
                }
            }
        }

        return puntuacion;
    }

    public static void mostrarEasterEgg(int aciertosSinIntentos) {
        if (aciertosSinIntentos >= 3) {
            System.out.println("\n¡$$$$$$$$\\  $$$$$$\\   $$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ $$$$$$$\\        $$$$$$$$\\  $$$$$$\\   $$$$$$\\  $$\\ \n"
                    + "$$  _____|$$  __$$\\ $$  __$$\\\\__$$  __|$$  _____|$$  __$$\\       $$  _____|$$  __$$\\ $$  __$$\\ $$ |\n"
                    + "$$ |      $$ /  $$ |$$ /  \\__|  $$ |   $$ |      $$ |  $$ |      $$ |      $$ /  \\__|$$ /  \\__|$$ |\n"
                    + "$$$$$\\    $$$$$$$$ |\\$$$$$$\\    $$ |   $$$$$\\    $$$$$$$  |      $$$$$\\    $$ |$$$$\\ $$ |$$$$\\ $$ |\n"
                    + "$$  __|   $$  __$$ | \\____$$\\   $$ |   $$  __|   $$  __$$<       $$  __|   $$ |\\_$$ |$$ |\\_$$ |\\__|\n"
                    + "$$ |      $$ |  $$ |$$\\   $$ |  $$ |   $$ |      $$ |  $$ |      $$ |      $$ |  $$ |$$ |  $$ |    \n"
                    + "$$$$$$$$\\ $$ |  $$ |\\$$$$$$  |  $$ |   $$$$$$$$\\ $$ |  $$ |      $$$$$$$$\\ \\$$$$$$  |\\$$$$$$  |$$\\ \n"
                    + "\\________|\\__|  \\__| \\______/   \\__|   \\________|\\__|  \\__|      \\________| \\______/  \\______/ \\__|\n"
                    + "                                                                                                   \n"
                    + "                                                                                                   \n"
                    + "                                                                                                    Has resuelto 3 preguntas sin gastar ningún intento.\n");
        }
    }

    public static int generarPreguntaAleatoria(int juego) {

        switch (juego) {
            case 0:
                System.out.println("\nPregunta 1: ¿Cuándo se descubrió América?");
                return 1492;
            case 1:
                System.out.println("\nPregunta 2: ¿Cuántos elementos químicos naturales conocidos existen en la Tabla Periódica?");
                return 118;
            case 2:
                System.out.println("\nPregunta 3: ¿Cuál es la respuesta a la Vida, el Universo y Todo lo Demás (según el libro 'Guía del autoestopista galáctico')?");
                return 42;
            case 3:
                System.out.println("\nPregunta 4: ¿Cuántos continentes hay en el mundo?");
                return 7;
            case 4:
                System.out.println("\nPregunta 5: ¿En qué año se publicó la novela '1984' de George Orwell?");
                return 1984;
            default:
                return 0;
        }
    }

    public static void mostrarResultados(int puntuacionTotal, int preguntasAcertadas, int preguntasFallidas) {
        System.out.println("\nEl juego ha terminado.");
        System.out.println("Puntuación total acumulada: " + puntuacionTotal);
        System.out.println("Preguntas acertadas: " + preguntasAcertadas);
        System.out.println("Preguntas no acertadas: " + preguntasFallidas + "\n");
    }

}
