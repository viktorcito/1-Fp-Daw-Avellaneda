/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio16_refuerzo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Ejercicio16_Refuerzo {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int n1;

        System.out.println("Escribe un numero: ");
        n1 = entrada.nextInt();

        if (n1 >= 0 && n1 <= 3) {
            System.out.println("Muy deficiente: " + n1);
        } else if (n1 > 3 && n1 < 5) {
            System.out.println("Insufivciente: " + n1);
        } else if (n1 >= 5 && n1 <= 6) {
            System.out.println("Bien: " + n1);
        } else if (n1 > 6 && n1 <= 8) {
            System.out.println("Notable: " + n1);
        } else if (n1 >= 9 && n1 <= 10) {
            System.out.println("Sobresaliente: " + n1);
        } else {
            System.out.println("ERROR: Numero incorrecto");
        }

    }

}
