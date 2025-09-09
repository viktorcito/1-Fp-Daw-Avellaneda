/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.alquilerVehiculos.util;

import es.daw.poo.alquilerVehiculos.model.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Utilidades {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> flota = new ArrayList();

    public static void mostrarMenu() {
        System.out.println("**********CONCESIONARIO*************");
        System.out.println("1. Añadir vehiculo");
        System.out.println("2. Alquiler vehiculo");
        System.out.println("3. Informe de flota");
        System.out.println("4. Informe de no alquilados");
        System.out.println("5. Informe de alquileres");
        System.out.println("6. Salir");
        System.out.println("Elige una opcion: ");
    }

    public static void añadirVehiculo() {
        int plazas;
        String matricula;
        float peso;

        System.out.println("Introduce el tipo de vehiculo");
        System.out.println("1. Coche");
        System.out.println("2. Microbus");
        System.out.println("3. Furgoneta");
        System.out.println("4. Camion");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("Introduce la matricula");
                matricula = sc.nextLine();
                sc.nextLine();
                System.out.println("Introduce el numero de plazas");
                plazas = sc.nextInt();

                flota.add(new Coche(matricula, plazas));
                break;
            case 2:
                System.out.println("Introduce la matricula");
                matricula = sc.nextLine();
                System.out.println("Introduce el numero de plazas");
                plazas = sc.nextInt();

                flota.add(new Microbus(plazas, matricula));
                break;
            case 3:
                System.out.println("Introduce la matricula");
                matricula = sc.nextLine();
                System.out.println("Introduce el PMA");
                peso = sc.nextFloat();

                flota.add(new Furgoneta(peso, matricula));
                break;
            case 4:
                System.out.println("Introduce la matricula");
                matricula = sc.nextLine();
                System.out.println("Introduce el PMA");
                peso = sc.nextFloat();

                flota.add(new Furgoneta(peso, matricula));
                break;

        }

    }

    public static void alquilarVehiculo() {
        System.out.println("Introduce la matricula del vehiculo");
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.getMATRICULA().equalsIgnoreCase(sc.nextLine())) {
                vehiculo.setAlquilado(true);
                break;
            }
        }
    }

    public static void informeFlota() {
        flota.forEach(System.out::println);
    }

    public static void informeNoAlquilado() {
        flota.forEach(v -> {
            if (!v.estaAlquilado()) {
                System.out.println(v);
            }
        });
    }

    public static void informeAlquilado() {
        flota.forEach(v -> {
            if (v.estaAlquilado()) {
                System.out.println(v);
            }
        });
    }

}
