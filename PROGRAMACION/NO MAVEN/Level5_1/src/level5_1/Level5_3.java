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
public class Level5_3 {

    // static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

       // int num, negativo = 0, positivo = 0;
        int suma, producto;

       // System.out.println("Introduce un numero 0 para salir");
       // num = sc.nextInt();

        suma = 0;
        producto = 1;


            for (int i = 1; i < 10; i++) {
                suma = suma + i;
                producto = producto * i;

               /* if (num < 0) {
                    System.out.println("se han introducido numero negarivos");
                    negativo++;
                } else {
                    positivo++;
                }
                System.out.println("Introduce un numero");
                num = sc.nextInt();

            }
        
        System.out.println("NUmero positivos: " + positivo);
        System.out.println("Numeros negaticos: " + negativo);*/
        System.out.println("La suma " + suma + "producto" + producto);
    }
    }
}
