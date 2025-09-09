/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Electrodomestico;

import Electrodomestico.dao.ElectrodomesticoDAO;
import Electrodomestico.model.Electrodomestico;
import Electrodomestico.model.Lavadora;
import Electrodomestico.model.Television;
import java.util.ArrayList;

/**
 *
 * @author VSPC
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        double sumaLavadoras = 0, sumaTelevisiones = 0, total = 0;

        ElectrodomesticoDAO dao = new ElectrodomesticoDAO();
        ArrayList<Electrodomestico> electrodomesticos = dao.select();

        for (Electrodomestico e : electrodomesticos) {

            if (e instanceof Lavadora) {

                sumaLavadoras += e.getPrecioFinal();
            } else if (e instanceof Television) {
                sumaTelevisiones += e.getPrecioFinal();
            }
        }
        
        System.out.println("La suma del precio de los electrodomesticos es de"+ (sumaLavadoras + sumaTelevisiones));
        System.out.println("La suma del precio de las lavadoras es de "+sumaLavadoras);
        System.out.println("La suma del precio de las televisiones es de"+sumaTelevisiones);
        

    }

}
