/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package level5_1;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Level5_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N, pos = 0, neg = 0;
        boolean negativo;
        final int maximo = 10;

        negativo = false;

        for (int i = 1; i <= maximo; i++) {
            System.out.println("Escribe el numero " + i + " de " + maximo + ": ");
            N = sc.nextInt();

            if (N < 0) {
                negativo = true;
                neg++;
                System.out.println("Se han introducido numeros negativos.");

            } else {
                pos++;
                System.out.println("Es positivo");
            }
        }
        System.out.println("Se han introducido " + pos + " numeros positivos");
        System.out.println("Se han introducido " + neg + " numeros negativos");

    }

}
