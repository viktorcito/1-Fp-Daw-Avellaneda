package ejercicio3_refuerzo;

import java.util.Scanner;


public class Ejercicio3_Refuerzo {

    public static void main(String[] args) {
        
        
        float lado,area;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cuanto mide el lado? (cm)");
        lado = sc.nextFloat();
        
        area = lado * lado;
        
         System.out.println("El area es " + area);

    }

}
