/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.poo.herencia.alquilerVehiculos;

import es.daw.poo.herencia.alquilerVehiculos.model.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Knox
 */
public class AlquilerApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> flota = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        
        do{
        System.out.println("************* CONCESIONARIO *********************");
            System.out.println("1. A�adir veh�culo.");
            System.out.println("2. Alquilar veh�culo.");
            System.out.println("3. Informe de flota");
            System.out.println("4. Informe de no alquilados");
            System.out.println("5. Informe de alquileres");
            System.out.println("6. Salir");
            System.out.print("Elige una opci�n: ");
            op = sc.nextInt();
            
            switch(op){
                case 1:
                   añadirVehiculo();
                   break;
                case 2:
                    alquilarVehiculo();
                    break;
                case 3:
                    informeFlota();
                    break;
                case 4:
                    informeNoAlquilado();
                    break;
                case 5:
                    informeAlquilado();
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicaci�n...");
                    break;
                default:
                    System.out.println("No has introducido una opci�n correcta");
            }
            
        }while(op != 6);
    }
    
    static void añadirVehiculo(){
        int plazas;
        String matricula;
        float peso;
        
         System.out.println("Introduce el tipo de veh�culo");
                    System.out.println("\t[1] Coche");
                    System.out.println("\t[2] Microbus");
                    System.out.println("\t[3] Furgoneta");
                    System.out.println("\t[4] Camion");
                    switch(sc.nextInt()){
                        case 1:
                            System.out.println("Introduce la matr�cula");
                            matricula = sc.nextLine();
                            sc.nextLine();//Pasa mal la matr�cula
                            System.out.println("Introduce el n�mero de plazas");
                            plazas = sc.nextInt();
                            
                            flota.add(new Coche(matricula,plazas));
                            break;
                        case 2:
                            System.out.println("Introduce la matr�cula");
                            matricula = sc.nextLine();
                            System.out.println("Introduce el n�mero de plazas");
                            plazas = sc.nextInt();
                            
                            flota.add(new Microbus(matricula,plazas));
                            break;
                        case 3:
                            System.out.println("Introduce la matr�cula");
                            matricula = sc.nextLine();
                            System.out.println("Introduce el PMA");
                            peso = sc.nextFloat();
                            
                            flota.add(new Furgoneta(matricula,peso));
                            break;
                        case 4:
                            System.out.println("Introduce la matr�cula");
                            matricula = sc.nextLine();
                            System.out.println("Introduce el PMA");
                            peso = sc.nextFloat();
                            
                            flota.add(new Furgoneta(matricula,peso));
                            break;
                    }
    }
    
    static void alquilarVehiculo(){
        System.out.println("Introduce la matr�cula del veh�culo");
        for (Vehiculo vehiculo : flota) {
            if(vehiculo.getMATRICULA().equalsIgnoreCase(sc.nextLine())){
                vehiculo.setAlquilado(true);
                break;
            }
        }
    }
    
    static void informeFlota(){
        flota.forEach(System.out::println);
    }
    
    static void informeNoAlquilado(){
        flota.forEach(v ->{
            if(!v.isAlquilado())
                System.out.println(v);
        });
    }
    
    static void informeAlquilado(){
        flota.forEach(v ->{
            if(v.isAlquilado())
                System.out.println(v);
        });
    }
    
    

}
