/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.practica2.lienzo.util;

import es.daw.practica2.lienzo.AppLienzo;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author VSPC
 */
public class Historial {

    private static Stack<String[][]> pilaDeshacer = new Stack<>();
    private static List<EstadoLienzo> historial = new LinkedList<>();

    public static void guardarEstadoParaDeshacer(String[][] lienzo) {
    String[][] estadoActual = new String[AppLienzo.letras.length][AppLienzo.NUM_COLS];
    for (int i = 0; i < AppLienzo.letras.length; i++) {
        System.arraycopy(lienzo[i], 0, estadoActual[i], 0, AppLienzo.NUM_COLS);
    }

    if (pilaDeshacer.size() >= 5) {
        pilaDeshacer.remove(0);  // Elimina el estado más antiguo si la pila ya tiene 5 elementos
    }

    pilaDeshacer.push(estadoActual);
}


    public static void deshacer(String[][] lienzo) {
        if (!pilaDeshacer.isEmpty()) {
            String[][] estadoAnterior = pilaDeshacer.pop();
            for (int i = 0; i < AppLienzo.letras.length; i++) {
                System.arraycopy(estadoAnterior[i], 0, lienzo[i], 0, AppLienzo.NUM_COLS);
            }
        }
    }

    public static void guardarEstadoParaHistorial(String[][] lienzo, String descripcion) {
    if (historial.size() == 10) {
        historial.remove(0);
    }
    String[][] estadoActual = new String[AppLienzo.letras.length][AppLienzo.NUM_COLS];
    for (int i = 0; i < AppLienzo.letras.length; i++) {
        System.arraycopy(lienzo[i], 0, estadoActual[i], 0, AppLienzo.NUM_COLS);
    }
    historial.add(new EstadoLienzo(estadoActual, descripcion));
}


    public static void mostrarHistorial() {
    for (EstadoLienzo estado : historial) {
        System.out.println("Descripción: " + estado.getDescripcion());
        
    }
}


}
