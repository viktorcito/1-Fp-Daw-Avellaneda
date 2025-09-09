/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio17_refuerzo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Ejercicio17_Refuerzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int hora, minutos, segundos;

        System.out.println("Escribe la hora");
        hora = entrada.nextInt();

        System.out.println("Escribe minutos");
        minutos = entrada.nextInt();

        System.out.println("Escribe segundos");
        segundos = entrada.nextInt();

        if (segundos == 59) {
            segundos = 0;

            if (minutos == 59) {
                minutos = 0;

                if (hora == 23) {
                    hora = 0;
                } else {
                    hora++;
                }
            } else {
                minutos++;
            }
        } else {
            segundos++;
        }

        System.out.println("Son las" + hora + ":" + minutos + ":" + segundos);
    }

}
