/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package level4_1;

import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Level4_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        int N;
        
        System.out.println("Introduce numero N: ");
        N = entrada.nextInt();
        
        for (int i=1;i<=N;i++){
            System.out.print(i + " ");
        }
        
    }
    
}
