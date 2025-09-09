/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.JOptionPane;
import model.Tarjeta;
import static tarjeta.modo.facil.TarjetaModoFacil.lector;
import static tarjeta.modo.facil.TarjetaModoFacil.tarjetas;

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

    public static void darAltaTarjetas() {
        
        System.out.println("Damos de altas las tarjetras");
        for (int i = 0; i < tarjetas.length; i++) {
            System.out.println("Datos tarjeta" + (i+1));
            System.out.println("Pasame el numero");
            String num = lector.nextLine();
            lector.next();
            System.out.println("Pasame el titular");
            String titu = lector.nextLine();
            lector.next();
            System.out.println("Pasame saldito");
            float sald = lector.nextFloat();
            
            tarjetas[i]= new Tarjeta (num,titu,sald);
            

        }
    }
    
    public static void darInformacionTarjetas(){
        System.out.println("Datos informativos de la tarjeta");
        for (int i = 0; i < tarjetas.length; i++) {
            if (tarjetas[i] == null){
                System.out.println("No hay");
                break;
            } else{
                System.out.println(tarjetas[i]);
            }
        }
        
    }
    
    public static void mostrarinformacionPorNumero(String num){
        for (int i = 0; i < tarjetas.length; i++) {
            if (tarjetas[i].getNumero().equalsIgnoreCase(num)){
                System.out.println(tarjetas[i]);
            }
            
        }
        System.out.println("Mostrando informacion tarjeta porm numero"+num);
    }

}
