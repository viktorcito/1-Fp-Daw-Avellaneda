
package ejercicio6_refuerzo;

import java.util.Scanner;


public class Ejercicio6_Refuerzo {


    public static void main(String[] args) {
        
         double precio_articulo, precio_venta, descuento;
         
         Scanner entrada = new Scanner(System.in);
         
         System.out.println("Introduce el precio ");
         precio_articulo = entrada.nextDouble();
         
         System.out.println("Introduce el precio de venta real ");
         precio_venta = entrada.nextDouble();
         
         descuento = ((precio_articulo - precio_venta) * 100 / precio_articulo);
         
         System.out.println("El descuento es " + descuento +"%");
         

    }
    
}
