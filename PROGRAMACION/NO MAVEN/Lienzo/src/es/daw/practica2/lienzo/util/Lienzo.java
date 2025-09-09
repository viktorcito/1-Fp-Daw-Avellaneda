/**
 * Clase que contiene métodos estáticos (funciones) específicos del lienzo
 */
package es.daw.practica2.lienzo.util;

import es.daw.practica2.lienzo.AppLienzo;

import static es.daw.practica2.lienzo.AppLienzo.NUM_COLS;

import static es.daw.practica2.lienzo.AppLienzo.letras;

/**
 *
 * @author melol
 */
public class Lienzo {

    // Inicializamos el arrays del lienzo: array bidimensional 26x25 (26 filas y 25 columnas)
    public static String[][] lienzo = new String[letras.length][NUM_COLS];

    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AZUL = "\u001B[34m";

    static {
        inicializarLienzo();
    }

    private static void inicializarLienzo() {
        lienzo = new String[AppLienzo.letras.length][AppLienzo.NUM_COLS];
        for (int i = 0; i < lienzo.length; i++) {
            for (int j = 0; j < lienzo[i].length; j++) {
                lienzo[i][j] = ".";
            }
        }
    }

    /**
     * Función para dibujar los marcos laterales del lienzo, el contenido del
     * lienzo y el marco inferior
     *
     * @param lienzo
     */
    public static void dibujarLienzo() {

        // marco superior números
        System.out.print("         "); // 9 espacios
        for (int i = 0; i < lienzo[0].length; i++) {
            if (i < 9) {
                System.out.print((i + 1) + "   "); // 3 espacios
            } else {
                System.out.print((i + 1) + "  "); // 2 espacios
            }
        }

        // marco superior con @
        System.out.print("\n     @"); // 5 espacios
        for (int i = 1; i < lienzo[0].length + 1; i++) {
            System.out.print("   @"); // 3 espacios
        }
        System.out.println("   @"); //3 espacios y última arroba del marco superior

        // lienzo
        for (int i = 0; i < lienzo.length; i++) {
            System.out.print("  " + letras[i] + "  @"); // 2 espacios + letra + 2 espacios + @
            for (int j = 0; j < lienzo[i].length; j++) {
                System.out.print("   " + lienzo[i][j]); // 3 espacios de separación
            }
            System.out.println("   @"); // 3 espacios
        }
        System.out.print("     @"); // 5 espacios

        // marco inferior
        for (int j = 0; j < lienzo[0].length; j++) {
            System.out.print("   @"); // 3 espacios
        }
        System.out.println("   @\n"); // 3 espacios

    }

    /**
     * Función para limpiar el lienzo dejandolo con '.'
     */
    public static void limpiarLienzo() {
        for (int i = 0; i < lienzo.length; i++) {
            for (int j = 0; j < lienzo[i].length; j++) {
                lienzo[i][j] = ".";
            }
        }
    }
    
    public static void limpiarLienzoTotal() {
        for (int i = 0; i < lienzo.length; i++) {
            for (int j = 0; j < AppLienzo.NUM_COLS; j++) {
                lienzo[i][j] = ".";
            }
        }
    }

    

    /**
     * Función para dibujar el lienzo completo (marco y contenido)
     */
    public static void dibujarCuadro() {

        dibujarLienzo(); // se dibuja el lienzo completo con marco y su contenido
    }

    public static void dibujarLinea(char tipoLinea, String coordenadaInicio) {
        int fila = coordenadaInicio.charAt(0) - 'a';
        int columna = Integer.parseInt(coordenadaInicio.substring(1)) - 1;

        switch (tipoLinea) {
            case 'h':
                // Dibujar línea horizontal
                for (int j = columna; j < NUM_COLS; j++) {
                    lienzo[fila][j] = "*";
                }
                break;
            case 'v':
                // Dibujar línea vertical
                for (int i = fila; i < letras.length; i++) {
                    lienzo[i][columna] = "*";
                }
                break;
            case 'd':
                // Dibujar línea diagonal
                for (int i = fila, j = columna; i < letras.length && j < NUM_COLS; i++, j++) {
                    lienzo[i][j] = "*";
                }
                break;
            default:
                System.out.println("Tipo de línea no válido. Use 'h', 'v' o 'd'.");
        }
    }

    public static void dibujarCuadrado(int lado, String coordenadaInicio) {
        int filaInicio = coordenadaInicio.charAt(0) - 'a';
        int columnaInicio = Integer.parseInt(coordenadaInicio.substring(1)) - 1;

        // Verifica si el cuadrado completo se sale del panel
        if (filaInicio + lado > letras.length || columnaInicio + lado > NUM_COLS) {
            System.out.println("El cuadrado se sale del panel. No se dibujará.");
            return;
        }

        // Dibuja los bordes superior e inferior
        for (int j = columnaInicio; j < columnaInicio + lado; j++) {
            lienzo[filaInicio][j] = "*"; // Borde superior
            lienzo[filaInicio + lado - 1][j] = "*"; // Borde inferior
        }

        // Dibuja los bordes laterales
        for (int i = filaInicio + 1; i < filaInicio + lado - 1; i++) {
            lienzo[i][columnaInicio] = "*"; // Borde izquierdo
            lienzo[i][columnaInicio + lado - 1] = "*"; // Borde derecho
        }
    }

    public static void cuboDePintura(String coordenadaInicio, char color) {
        int fila = coordenadaInicio.charAt(0) - 'a';
        int columna = Integer.parseInt(coordenadaInicio.substring(1)) - 1;
        String colorANSI = obtenerColorANSI(color);
        aplicarCuboDePintura(fila, columna, ".", colorANSI);
    }

    private static String obtenerColorANSI(char color) {
        switch (color) {
            case 'R':
                return ROJO;
            case 'V':
                return VERDE;
            case 'A':
                return AZUL;
            default:
                return RESET;
        }
    }

    private static void aplicarCuboDePintura(int fila, int columna, String colorOriginal, String colorANSI) {
        if (fila < 0 || fila >= lienzo.length || columna < 0 || columna >= lienzo[0].length) {
            return;
        }
        if (!lienzo[fila][columna].equals(colorOriginal)) {
            return;
        }

        lienzo[fila][columna] = colorANSI + "." + RESET;

        // Expande en todas las direcciones
        aplicarCuboDePintura(fila + 1, columna, colorOriginal, colorANSI);
        aplicarCuboDePintura(fila - 1, columna, colorOriginal, colorANSI);
        aplicarCuboDePintura(fila, columna + 1, colorOriginal, colorANSI);
        aplicarCuboDePintura(fila, columna - 1, colorOriginal, colorANSI);
    }

    

}
