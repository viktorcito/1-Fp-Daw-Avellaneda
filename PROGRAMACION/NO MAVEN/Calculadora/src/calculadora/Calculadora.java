/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import Util.Utilidades;
import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Calculadora {

    static Scanner sc = new Scanner(System.in);
    public static Utilidades calc2 = new Utilidades("Cientifica");

    public static void main(String[] args) {

        int opcion = 0;

        Utilidades calculadora1 = new Utilidades();

        System.out.println("Tipo calc1: " + calculadora1.getTipo());

        System.out.println("Tipo calc2: " + calc2.getTipo());

        do {
            Utilidades.mostrarMenuSencillo();
            opcion = sc.nextInt();

            if (opcion > 0) {
                
           //    System.out.println("Opcion no valida. Vuelva a escoger");
           // }else if (opcion !=0){

                System.out.println("\n");

                Utilidades.leerOperandos();

                System.out.println("\n");
                switch (opcion) {
                    case 1:
                        System.out.println("El resultado de la suma es " + calc2.sumar());
                        break;

                    case 2:
                        System.out.println("El resultado de la resta es" + calc2.restar());
                        break;
                    case 3:
                        System.out.println("El resultado de la multiplicacion es" + calc2.multiplicar());
                        break;

                    case 4:
                        System.out.println("El resultado de la divion es" + calc2.dividir());
                        break;
                    case 5:
                        System.out.println("El resto de dividir es" + calc2.getOperando1() + "entre" + calc2.getOperando2() + "es" + calc2.resto());
                        break;

                    default:
                        System.out.println("Opcion no valida vuelva a escoger");
                }

            }

        } while (opcion != 0);

        sc.close();
        System.out.println("Finalizo la ejecucion de la calculadora");

    }

}
