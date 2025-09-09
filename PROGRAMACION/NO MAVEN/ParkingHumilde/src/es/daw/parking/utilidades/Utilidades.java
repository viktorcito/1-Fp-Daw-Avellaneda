/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parking.utilidades;

import es.daw.parking.exception.NombreParkingDuplicadoException;
import es.daw.parking.model.Parking;
import es.daw.parking.model.TipoVehiculo;
import es.daw.parking.model.Transaccion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class Utilidades {

    public static void mostrarMenu() {
        System.out.println("");
        System.out.println("\t----------------------------------------------");
        System.out.println("\t---- [AYUNTAMIENTO DE ALCALÁ DE HENARES]  ----");
        System.out.println("\t---  INFORMACIÓN DE PLAZAS DE APARCAMIENTO ---");
        System.out.println("\t----------------------------------------------");
        System.out.println("\t----------------- [INFORMES] -----------------");
        System.out.println("\t1. Informe general");
        System.out.println("\t2. Número de plazas totales en Alcalá");
        System.out.println("\t3. Número de plazas para un determinado tipo de vehículo en Alcalá");
        System.out.println("\t4. Número de plazas totales de un parking concreto");
        System.out.println("\t5. Número de plazas de un determinado tipo de vehículo de un parking concreto");
        System.out.println("\t----------------------------------------------");
        System.out.println("\t6. [INTERCAMBIAR] Intercambiar plazas de aparcamiento de un mismo parking");
        System.out.println("\t7. [ORDENAR] Mostrar número de plazas ordenadas descendentemente");
        System.out.println("");
        System.out.println("\t8. SALIR");
        System.out.println("\t-----------------------------------------------");
        System.out.println("\t9. Añadir un nuevo parking");
        System.out.println("\t10. Borrar un parking");
        System.out.println("\t----------------------------------------------");
        System.out.println("\t11. Registrar entrada o salida de vehículo");
        System.out.println("\t----------------------------------------------");
        System.out.println("\tElige una opción:");

    }

    public static void mostrarInformeGeneral(ArrayList<Parking> parkings) {
        for (Parking parking : parkings) {
            System.out.println(parking.toString());
        }
    }

    public static int obtenerNumPlazasTotal(ArrayList<Parking> parkings) {
        int totalPlazas = 0;

        for (Parking parking : parkings) {
            totalPlazas += parking.getPlazasCoches();
            totalPlazas += parking.getPlazasMotos();
            totalPlazas += parking.getPlazasFurgonetas();
            totalPlazas += parking.getPlazasCamiones();
        }

        return totalPlazas;
    }

    public static int obtenerPlazasPorTipoVehiculo(ArrayList<Parking> parkings, TipoVehiculo tipoVehiculo) {
        int totalPlazasTipo = 0;
        for (Parking parking : parkings) {
            switch (tipoVehiculo) {
                case COCHES:
                    totalPlazasTipo += parking.getPlazasCoches();
                    break;
                case MOTOS:
                    totalPlazasTipo += parking.getPlazasMotos();
                    break;
                case FURGONETAS:
                    totalPlazasTipo += parking.getPlazasFurgonetas();
                    break;
                case CAMIONES:
                    totalPlazasTipo += parking.getPlazasCamiones();
                    break;
            }

        }

        return totalPlazasTipo;
    }

    public static int obtenerNumPlazasPorParking(ArrayList<Parking> parkings, String parkingNombre) {
        for (Parking parking : parkings) {
            if (parking.getNombre().equalsIgnoreCase(parkingNombre)) {
                return parking.getPlazasCoches() + parking.getPlazasMotos() + parking.getPlazasFurgonetas() + parking.getPlazasCamiones();
            }
        }

        return 0;
    }

    public static int obtenerNumPlazasPorParkingPorTipoVehiculo(ArrayList<Parking> parkings, String parkingNombre, TipoVehiculo tipoVehiculo) {
        for (Parking parking : parkings) {
            if (parking.getNombre().equalsIgnoreCase(parkingNombre)) {
                switch (tipoVehiculo) {
                    case COCHES:
                        return parking.getPlazasCoches();
                    case MOTOS:
                        return parking.getPlazasMotos();
                    case FURGONETAS:
                        return parking.getPlazasFurgonetas();
                    case CAMIONES:
                        return parking.getPlazasCamiones();
                }
            }
        }
        return 0;
    }

    public static void intercambiarPlazas(ArrayList<Parking> parkings, String parkingNombre, TipoVehiculo tipoVehiculo1, TipoVehiculo tipoVehiculo2) {
        for (Parking parking : parkings) {
            if (parking.getNombre().equalsIgnoreCase(parkingNombre)) {
                int plazasTipoVehiculo1 = parking.getPlazasTipoVehiculo(tipoVehiculo1);
                int plazasTipoVehiculo2 = parking.getPlazasTipoVehiculo(tipoVehiculo2);

                parking.setPlazasTipoVehiculo(tipoVehiculo1, plazasTipoVehiculo2);
                parking.setPlazasTipoVehiculo(tipoVehiculo2, plazasTipoVehiculo1);
            }
        }
    }

    public static void mostrarNumPlazasPorParkingOrdenadasDesc(ArrayList<Parking> parkings) {
        ArrayList<Parking> ordenParking = new ArrayList<>(parkings);

        Collections.sort(ordenParking, new Comparator<Parking>() {
            @Override
            public int compare(Parking p1, Parking p2) {
                int totalPlazasP1 = p1.getPlazasCoches() + p1.getPlazasMotos() + p1.getPlazasFurgonetas() + p1.getPlazasCamiones();
                int totalPlazasP2 = p2.getPlazasCoches() + p2.getPlazasMotos() + p2.getPlazasFurgonetas() + p2.getPlazasCamiones();
                return Integer.compare(totalPlazasP2, totalPlazasP1);
            }

        });

        for (Parking parking : ordenParking) {
            int totalPlazas = parking.getPlazasCoches() + parking.getPlazasMotos() + parking.getPlazasFurgonetas() + parking.getPlazasCamiones();
            System.out.println(parking.getNombre() + ": " + totalPlazas + " plazas");
        }

    }

    //2 PARTE DEL PROGRAMA
    public static void añadirParking(ArrayList<Parking> parkings, Parking nuevoParking) throws NombreParkingDuplicadoException {
        for (Parking parking : parkings) {
            if (parking.getNombre().equalsIgnoreCase(nuevoParking.getNombre())) {
                throw new NombreParkingDuplicadoException("El nombre del parking ya existe.");
            }
        }
        if (nuevoParking.getPlazasCoches() < 0 || nuevoParking.getPlazasMotos() < 0 || nuevoParking.getPlazasFurgonetas() < 0 || nuevoParking.getPlazasCamiones() < 0) {
            throw new IllegalArgumentException("\nEL NUMERO DE PLAZAS NO PUEDE SER NEGATIVO.\n");
        }
        parkings.add(nuevoParking);
        System.out.println("Parking añadido con éxito.");
    }

    public static void borrarParking(ArrayList<Parking> parkings, String nombreParking) {
        boolean parkingEliminado = false;
        for (int i = 0; i < parkings.size(); i++) {
            if (parkings.get(i).getNombre().equalsIgnoreCase(nombreParking)) {
                parkings.remove(i);
                parkingEliminado = true;
                System.out.println("Parking eliminado con éxito.");
                break;
            }
        }
        if (!parkingEliminado) {
            System.out.println("No se encontró el parking especificado.");
        }
    }

    //3 PARTE DEL PROGRAMA
    public static void registrarTransaccion(ArrayList<Transaccion> transacciones, String tipoTransaccion, String tipoVehiculo, String nombreParking) {
        LocalDateTime fechaHora = LocalDateTime.now();
        Transaccion transaccion = new Transaccion(tipoTransaccion, tipoVehiculo, fechaHora, nombreParking);
        transacciones.add(transaccion);
    }

    public static boolean entradaVehiculo(ArrayList<Parking> parkings, ArrayList<Transaccion> transacciones, String nombreParking, String tipoVehiculo) {
        // Encuentra el parking con el nombre dado en la lista de parkings
        for (Parking parking : parkings) {
            if (parking.getNombre().equalsIgnoreCase(nombreParking)) {
                // Llama al método entradaVehiculo() de la clase Parking para este parking específico
                if (parking.entradaVehiculo(tipoVehiculo)) {
                    // Registra la transacción y devuelve true si la entrada es exitosa
                    registrarTransaccion(transacciones, "entrada", tipoVehiculo, nombreParking);
                    return true;
                } else {
                    // Devuelve false si no hay plazas disponibles
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean salidaVehiculo(ArrayList<Parking> parkings, ArrayList<Transaccion> transacciones, String nombreParking, String tipoVehiculo) {
        // Encuentra el parking con el nombre dado en la lista de parkings
        for (Parking parking : parkings) {
            if (parking.getNombre().equalsIgnoreCase(nombreParking)) {
                // Llama al método salidaVehiculo() de la clase Parking para este parking específico
                if (parking.salidaVehiculo(tipoVehiculo)) {
                    // Registra la transacción y devuelve true si la salida es exitosa
                    registrarTransaccion(transacciones, "salida", tipoVehiculo, nombreParking);
                    return true;
                } else {
                    // Devuelve false si no hay vehículos de este tipo en el parking
                    return false;
                }
            }
        }
        return false;
    }
    
    public static void mostrarTransacciones(ArrayList<Transaccion> transacciones) {
    if (transacciones.isEmpty()) {
        System.out.println("No hay transacciones registradas.");
    } else {
        System.out.println("Lista de transacciones:");
        for (Transaccion transaccion : transacciones) {
            System.out.println(transaccion);
        }
    }
}


}
