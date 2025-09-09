/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import calculadora.Calculadora;
import java.util.Scanner;    



public class Utilidades {

    static Scanner sc = new Scanner (System.in);
    
    public static void mostrarMenuSencillo() {
        System.out.println("**********");
        System.out.println("MENU CLACULADORA");
        System.out.println("**********");
        System.out.println("1.Sumar");
        System.out.println("2.Restar");
        System.out.println("3.Multiplicar");
        System.out.println("4.Dividir");
        System.out.println("5.Resto de la Division");
        System.out.println("0. Salir del programa");
        System.out.println("---------------");
        System.out.println("Introduzca una opcion valida");

    }

    // MODEL:PROPIEDADES Y ATRIBUTOS
    private String tipo;
    private float operando1;
    private float operando2;

    //CONSTRUCTORES
    public Utilidades() {

    }

    public Utilidades(String tipo) {
        this.tipo = tipo;
    }

    //GETTERS & SETTERS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getOperando1() {
        return operando1;
    }

    public void setOperando1(float operando1) {
        this.operando1 = operando1;
    }

    public float getOperando2() {
        return operando2;
    }

    public void setOperando2(float operando2) {
        this.operando2 = operando2;
    }
    //METODOS DE COMPORTAMIENTO

    public float sumar() {
        return operando1 + operando2;
    }

    public float restar() {
        return operando1 - operando2;
    }

    public float multiplicar() {
        return operando1 * operando2;
    }

    public float dividir() {
        return operando1 / operando2;
    }

    public float resto() {
        return operando1 % operando2;
    }
    
        public static void leerOperandos(){
    
            System.out.println("Introduzca el primer operando: ");
            Calculadora.calc2.setOperando1(sc.nextFloat());
            
            System.out.println("Introduzca el segundo operando");
            Calculadora.calc2.setOperando2(sc.nextFloat());
    
}
    
    

}
