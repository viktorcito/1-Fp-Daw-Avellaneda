/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.parking;

import es.daw.parking.dao.ParkingDao;
import es.daw.parking.exception.NombreParkingDuplicadoException;
import es.daw.parking.model.Parking;
import es.daw.parking.model.TipoVehiculo;
import es.daw.parking.model.Transaccion;
import es.daw.parking.utilidades.Utilidades;
import static es.daw.parking.utilidades.Utilidades.mostrarMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author VSPC
 */
public class App {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Transaccion> transacciones = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        
        //System.out.println("Directorio actual: " + System.getProperty("user.dir")); ESTO NOS SIRVE PARA SABER NUESTRO DIRECTORIO PADRE DEL POJECTO
        ParkingDao parkingDao = new ParkingDao();
        // ArrayList<Parking> parkings = parkingDao.select(); ESTE CODIGO QUEDA YA OBSOLETO JUNTO CON TODO EL DAO PORQUE TENEMOS UN CSV

        //String filename = "parkings.csv";
        String filename = "parkings.json";
        //ArrayList<Parking> parkings = ParkingFileManager.readParkingsFromCSV(filename);
        ArrayList<Parking> parkings = ParkingFileManager.readParkingsFromJSON(filename);

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            System.out.println();
            System.out.println("Opción seleccionada: " + opcion);
            System.out.println();

            switch (opcion) {
                case 1:
                    Utilidades.mostrarInformeGeneral(parkings);
                    break;
                case 2:
                    int totalPlazas = Utilidades.obtenerNumPlazasTotal(parkings);
                    System.out.println("Numero total de plazas" + totalPlazas);
                    break;
                case 3:
                    System.out.println("Introduzca el tipo de vehículo (COCHES, MOTOS, FURGONETAS, CAMIONES):");
                    String tipoVehiculoStr = sc.nextLine();
                    TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(tipoVehiculoStr.toUpperCase());
                    int numPlazasTipoVehiculo = Utilidades.obtenerPlazasPorTipoVehiculo(parkings, tipoVehiculo);
                    System.out.println("Número total de plazas para " + tipoVehiculo + " en Alcalá: " + numPlazasTipoVehiculo);
                    break;
                case 4:
                    System.out.println("Introduzca el nombre del parking");
                    String nombreParking = sc.nextLine();
                    int numPlazasParking = Utilidades.obtenerNumPlazasPorParking(parkings, nombreParking);
                    System.out.println("Número total de plazas en el parking " + nombreParking + ": " + numPlazasParking);
                    break;
                case 5:
                    System.out.println("Introduce el parking");
                    String nombreParking2 = sc.nextLine();
                    System.out.println("Introduzca el tipo de vehículo (COCHES, MOTOS, FURGONETAS, CAMIONES):");
                    String tipoVehiculoStr2 = sc.nextLine();
                    TipoVehiculo tipoVehiculo2 = TipoVehiculo.valueOf(tipoVehiculoStr2.toUpperCase());
                    int numPlazasParkingTipoVehiculo = Utilidades.obtenerNumPlazasPorParkingPorTipoVehiculo(parkings, nombreParking2, tipoVehiculo2);
                    System.out.println("Número de plazas para " + tipoVehiculo2 + " en el parking " + nombreParking2 + ": " + numPlazasParkingTipoVehiculo);
                    break;
                case 6:
                    System.out.println("Introduce el nombre del parking:");
                    String parkingNombre = sc.nextLine();

                    System.out.println("Introduzca el primer tipo de vehículo a intercambiar (COCHES, MOTOS, FURGONETAS, CAMIONES):");
                    String tipoVehiculo1Str = sc.nextLine();
                    TipoVehiculo tipoVehiculo1 = TipoVehiculo.valueOf(tipoVehiculo1Str.toUpperCase());

                    System.out.println("Introduzca el segundo tipo de vehículo a intercambiar (COCHES, MOTOS, FURGONETAS, CAMIONES):");
                    String tipoVehiculo3Str = sc.nextLine();
                    TipoVehiculo tipoVehiculo3 = TipoVehiculo.valueOf(tipoVehiculo3Str.toUpperCase());

                    Utilidades.intercambiarPlazas(parkings, parkingNombre, tipoVehiculo1, tipoVehiculo3);
                    System.out.println("Se han intercambiado las plazas de " + tipoVehiculo1 + " y " + tipoVehiculo3 + " en el parking " + parkingNombre);
                    Utilidades.mostrarInformeGeneral(parkings);
                    break;
                case 7:
                    Utilidades.mostrarNumPlazasPorParkingOrdenadasDesc(parkings);
                    break;
                case 8:
                    System.out.println("EXIT...");
                    break;
                case 9:
                    // Solicitar los datos del usuario para crear un nuevo Parking
                    System.out.println("Introduce el nombre del parking:");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce el número de plazas para coches:");
                    int plazasCoches = sc.nextInt();
                    System.out.println("Introduce el número de plazas para motos:");
                    int plazasMotos = sc.nextInt();
                    System.out.println("Introduce el número de plazas para furgonetas:");
                    int plazasFurgonetas = sc.nextInt();
                    System.out.println("Introduce el número de plazas para camiones:");
                    int plazasCamiones = sc.nextInt();

                    // Crea el objeto Parking con los datos ingresados
                    Parking nuevoParking = new Parking(nombre, plazasCoches, plazasMotos, plazasFurgonetas, plazasCamiones);

                    // Intenta agregar el nuevo parking y manejar la excepción en caso de que el nombre sea duplicado
                    try {
                        Utilidades.añadirParking(parkings, nuevoParking);
                    } catch (NombreParkingDuplicadoException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    Utilidades.mostrarInformeGeneral(parkings);
                    break;
                case 10:
                    System.out.println("Introduce el nombre del parking a eliminar:");
                    String nombreParkingAEliminar = sc.nextLine();
                    Utilidades.borrarParking(parkings, nombreParkingAEliminar);
                    Utilidades.mostrarInformeGeneral(parkings);
                    break;
                case 11: //FASE3
                    System.out.println("Introduce el nombre del parking:");
                    String nombreParkingE = sc.nextLine();
                    System.out.println("Indica si es una entrada (E) o salida (S) de vehículo:");
                    String accion = sc.nextLine();
                    System.out.println("Introduce el tipo de vehículo (coche, moto, furgoneta, camion):");
                    String tipoVehiculoES = sc.nextLine();

                    if (accion.equalsIgnoreCase("E")) {
                        boolean resultadoEntrada = Utilidades.entradaVehiculo(parkings, transacciones, nombreParkingE, tipoVehiculoES);
                        if (resultadoEntrada) {
                            System.out.println("Entrada de vehículo registrada con éxito.");
                        } else {
                            System.out.println("No se pudo registrar la entrada de vehículo. Es posible que no haya plazas disponibles.");
                        }
                    } else if (accion.equalsIgnoreCase("S")) {
                        boolean resultadoSalida = Utilidades.salidaVehiculo(parkings, transacciones, nombreParkingE, tipoVehiculoES);
                        if (resultadoSalida) {
                            System.out.println("Salida de vehículo registrada con éxito.");
                        } else {
                            System.out.println("No se pudo registrar la salida de vehículo. Es posible que no haya vehículos de ese tipo en el parking.");
                        }
                    } else {
                        System.out.println("Acción no reconocida. Introduce E para entrada o S para salida.");
                    }
                    Utilidades.mostrarTransacciones(transacciones);
                    break;
                case 12:
                    Utilidades.mostrarTransacciones(transacciones);
                    break;

                default:
                    System.out.println("Opcion no valida");

            }

            if (opcion != 8) {
                System.out.println("\nPresione Enter para continuar...");
                sc.nextLine();
            }

        } while (opcion != 8);
        //ParkingFileManager.writeParkingsToCSV(filename, parkings);
        ParkingFileManager.writeParkingsToJSON(filename, parkings);
        sc.close();
    }

}
