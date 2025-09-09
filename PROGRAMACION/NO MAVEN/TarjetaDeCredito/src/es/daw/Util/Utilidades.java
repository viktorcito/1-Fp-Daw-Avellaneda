/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.Util;

import tarjetadecredito.TarjetaDeCredito;
import es.daw.poo.model.Tarjeta;
import javax.swing.JOptionPane;
import static tarjetadecredito.TarjetaDeCredito.lector;
import static tarjetadecredito.TarjetaDeCredito.tarjetas;

/**
 *
 * @author VSPC
 */
public class Utilidades {

    public static void pintaMenu() {
        System.out.println("****MENU****");
        System.out.println("1. Dar de alta tarjetas");
        System.out.println("2. Mostrar informacion de todas las tarjetas");
        System.out.println("3. Mostrar informacion de una tarjeta a traves de su numero identificado");
        System.out.println("4. Pagar");
        System.out.println("5. Desactivar tarjeta");

        System.out.println("6. Salir");
        System.out.println("Elige una opcion: ");
    }

    public static int pidoNumTarjetas() {
        String numTarjetas1 = JOptionPane.showInputDialog("Introduce el numero dadas de alta las tarjetas");
        return Integer.parseInt(numTarjetas1);

    }

    public static void darAltaTarjetas() {
        System.out.println("Damos de alta tarjeta");
        for (int i = 0; i < tarjetas.length; i++) {
            System.out.println("Datos tarjeta " + (1 + i));
            System.out.println("Pasame numero");
            String num = lector.next();
            lector.nextLine();
            System.out.println("Pasame titular");
            String ti = lector.nextLine();
            lector.nextLine();
            System.out.println("Pasame saldito");
            float sald = lector.nextFloat();

            tarjetas[i] = new Tarjeta(num, ti, sald);
        }

    }

    public static void imprimeInformacionTarjetas() {
        System.out.println("Damos informacion de tarjetas");

        for (int i = 0; i < tarjetas.length; i++) {
            if (tarjetas[i] == null) {
                System.out.println("NULO CATETIN");
                break;
            } else {
                System.out.println(tarjetas[i]);
            }
        }

    }
    
    public static void informacionPorNumero(String num){
        System.out.println("Mostrar informacion de la tarjeta por numero"+num);
        
        for (int i = 0; i < tarjetas.length; i++) {
            if(tarjetas[i].getNumero().equalsIgnoreCase(num)){
                System.out.println(tarjetas[i]);
            }

        }
    }
    
    
        //Metodo para realizar el pago con la tarjeta
   /* public static boolean pidoPagar(float importe, float saldo, float limite) {

        boolean error;
        if (importe > saldo || importe > limite) {
            System.out.println("[ERROR] No se ha podido realizar el pago");
            error = true;
        } else {
            saldo -= importe;
            error = false;
        }
        return error; 
    } 
    */

}




