

package ejercicio5_refuerzo;

import java.util.Scanner;


public class Ejercicio5_Refuerzo {


    public static void main(String[] args) {
        
        double radio, circunferencia, area, volumen;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce la longitud");
        radio = sc.nextDouble();
        
        circunferencia = radio * 2 * Math.PI;
        area = Math.PI * Math.pow(radio, 2);
        volumen = 4/3 * Math.PI * Math.pow(radio, 3);
        
        System.out.println("La cicunferencia es " + circunferencia);
        System.out.println("El area es " + area);
        System.out.println("El volumen es " + volumen);
        
    }
    
}
