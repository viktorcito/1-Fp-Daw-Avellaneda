/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio12_refuerzo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Ejercicio12_Refuerzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        float numero1;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Escribe el primer numero ");
        numero1 = entrada.nextFloat();

        if (numero1 >= 0) {
            System.out.println("ESTE NUMERO ES POSITIVO " + numero1);
        } else {
            System.out.println("ES NEGATIVO " + numero1);
        }
    }

}
