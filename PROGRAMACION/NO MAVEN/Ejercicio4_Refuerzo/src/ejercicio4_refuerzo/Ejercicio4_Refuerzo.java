package ejercicio4_refuerzo;

import java.util.Scanner;

public class Ejercicio4_Refuerzo {

    public static void main(String[] args) {

        float numero1, numero2, suma, resta, producto, division;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("intruduce el primer numero");
        numero1 = sc.nextFloat();
        
        System.out.println("introduce el segundo numero");
        numero2 = sc.nextFloat();
        
        suma = numero1 + numero2;
        resta = numero1 - numero2;
        producto = numero1 * numero2;
        
        
        System.out.println("Los resultados son: ");
        System.out.println(numero1 + " + " + numero2 + " = " + suma);
        System.out.println(numero1 + " - " + numero2 + " = " + resta);
        System.out.println(numero1 + " * " + numero2 + " = " + producto);
        
        if (numero2 == 0)
            System.out.println("Entonces es 0");
        
        else {
            
            division = numero1 / numero2;
            
            System.out.println("La division es: " + division);
        }
        
        

    }

}
