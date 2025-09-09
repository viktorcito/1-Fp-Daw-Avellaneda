/**
 * Clase principal ejecutable de la herramienta LIENZO
 *
 */
package es.daw.practica2.lienzo;

import es.daw.practica2.lienzo.util.Historial;
import es.daw.practica2.lienzo.util.Lienzo;
import static es.daw.practica2.lienzo.util.Lienzo.dibujarCuadro;
import static es.daw.practica2.lienzo.util.Utils.*;

public class AppLienzo {

    // Variables globales
    public static final char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final int NUM_COLS = 25;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("[LIENZO DAW - DIBUJAR POR CONSOLA] Realizado por Victor Garcia Santos");
        System.out.println("Pulsa intro para mostrarte el lienzo");

        leerEnter();

        int opcion;
        do {
            dibujarCuadro();
            menuOpciones();

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    // Opción 1: Dibujar Líneas
                    Historial.guardarEstadoParaDeshacer(Lienzo.lienzo);

                    System.out.println("Seleccionaste la opción 1 - Dibujar Líneas");
                    System.out.print("Tipo de línea (h/v/d): ");
                    char tipoLinea = leerCaracter();
                    System.out.print("Coordenada de inicio (ejemplo: b10): ");
                    String coordenadaInicio = leerCadena();
                    Historial.guardarEstadoParaHistorial(Lienzo.lienzo, "Dibujado linea en " + coordenadaInicio);
                    // Llama a la función para dibujar la línea
                    Lienzo.dibujarLinea(tipoLinea, coordenadaInicio);

                    break;
                case 2:
                    // Opción 2: Dibujar Cuadrado
                    Historial.guardarEstadoParaDeshacer(Lienzo.lienzo);

                    System.out.println("Seleccionaste la opción 2 - Dibujar Cuadrado");
                    System.out.print("Tamaño del lado: ");
                    int ladoCuadrado = leerEntero();
                    System.out.print("Coordenada de inicio (ejemplo: b10): ");
                    String coordenadaInicioCuadrado = leerCadena();
                    Historial.guardarEstadoParaHistorial(Lienzo.lienzo, "Dibujado cuadrado en " + coordenadaInicioCuadrado);
                    // Llama a la función para dibujar el cuadrado
                    Lienzo.dibujarCuadrado(ladoCuadrado, coordenadaInicioCuadrado);

                    break;
                case 3:
                    Historial.guardarEstadoParaDeshacer(Lienzo.lienzo);

                    System.out.println("Seleccionaste la opción 3 - Cubo de Pintura");
                    System.out.print("Coordenada de inicio (ejemplo: b10): ");
                    String coordenadaInicioPintura = leerCadena();
                    System.out.print("Color (R/V/A): ");
                    char color = leerCaracter();

                    Historial.guardarEstadoParaHistorial(Lienzo.lienzo, "Aplicado cubo de pintura en " + coordenadaInicioPintura + " con color " + color);
                    Lienzo.cuboDePintura(coordenadaInicioPintura, color);
                    
                    break;
                case 4:
                    Historial.deshacer(Lienzo.lienzo);
                    break;
                case 5:
                    Historial.mostrarHistorial();
                    break;
                case 6:
                    Lienzo.limpiarLienzoTotal();
                    break;
                case 7:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 7.");
            }

        } while (opcion != 7);

    }

}
