/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio18_refuerzo;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Ejercicio18_Refuerzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        
        String nombre;
        int horas;
        double salarioNeto, salarioB, impuesto, tarifaH;
        
        impuesto=0;
        
        System.out.println("Introduce el nombre: ");
        nombre=entrada.nextLine();

        System.out.print("Escribe la tarifa hora: ");
        tarifaH = entrada.nextDouble();

        System.out.print("Cuantas horas has trabajado:");
        horas = entrada.nextInt();
        
        if (horas <= 35) {
            salarioB = horas * tarifaH;
        } else {
            salarioB = 35 * tarifaH + ((horas-35)*tarifaH*1.5);
        }
           
        if (salarioB > 900) {
            impuesto = (400 * 0.25) + (salarioB - 900)*0.45;           
        } else if (salarioB > 500) {
            impuesto = (salarioB-500) * 0.25;

        }
        
        
        salarioNeto = salarioB-impuesto;
        
        System.out.println("Informe del empleado " + nombre + ":");
        System.out.println("Salario bruto " + salarioB + "€");
        System.out.println("Salario neto " + salarioNeto + "€");
        System.out.println("Impuesto: " + impuesto + "€");
    
    }
}
