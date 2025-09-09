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
public class Level5_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        int N, fact=1;
        
        System.out.println("Introduce el numero N: ");
        N = entrada.nextInt();
        
        while (N > 1){
            fact = fact * N;
            N--;
        }
        System.out.println("Su factorial es " + fact);
    }
    
}
