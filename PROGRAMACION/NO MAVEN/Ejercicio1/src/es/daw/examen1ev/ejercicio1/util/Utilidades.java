package es.daw.examen1ev.ejercicio1.util;

import static es.daw.examen1ev.ejercicio1.ParkingsAlcala.*;
import java.util.Arrays;

public class Utilidades {

    // Constantes
    public static final int NUM_PARKINGS = 4;
    public static final int NUM_TIPO_VEHICULOS = 4;

    /**
     * Método que devuelve una matriz cargada con los datos de los aparcamientos
     * públicos de Alcalá y el número de plazas por cada tipo de vehículo
     *
     * @return
     */
    public static int[][] cargarDatos() {
        int[][] parkings = new int[NUM_PARKINGS][NUM_TIPO_VEHICULOS];

        parkings[0] = new int[]{25, 20, 0, 5};
        parkings[1] = new int[]{32, 15, 10, 0};
        parkings[2] = new int[]{47, 25, 15, 10};
        parkings[3] = new int[]{35, 18, 12, 0};

        return parkings;
    }

    /**
     * Método que muestra por consola el menú del programa
     */
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
        System.out.println("\t----------------------------------------------");
        System.out.println("\tElige una opción:");

    }

    /**
     * [opción 1 del menú] Método que muestra el informe general con toda la
     * información de todos los aparcamientos
     *
     */
    public static void mostrarInformeGeneral() {

        for (int i = 0; i < parkingPlazas.length; i++) {
            System.out.println("---------------------------------------------\n");
            System.out.println("Información del parking " + NOMBRE_PARKINGS[i]);
            for (int j = 0; j < parkingPlazas[i].length; j++) {
                System.out.println("\tNúmero de plazas de [ " + NOMBRE_VEHICULOS[j] + " ] : " + parkingPlazas[i][j] + "\n");
            }
        }
    }

    /**
     * [opción 2 del menú] Este método devuelve el número total de plazas de
     * todos los tipos de vehículos de los cuatro aparcamientos públicos de
     * Alcalá.
     *
     * @return
     */
    public static int obtenerNumPlazasTotal() {
        int plazasTot = 0;

        for (int[] parkingPlaza : parkingPlazas) {
            for (int j = 0; j < parkingPlaza.length; j++) {
                plazasTot += parkingPlaza[j];
            }
        }

        return plazasTot;
    }

    /**
     * [opción 3 del menú] Este método devuelve el número total de plazas en
     * Alcalá de un tipo de vehículo concreto.
     *
     * @param tipoVehiculo
     * @return
     */
    public static int obtenerNumPlazasPorTipoVehiculo(int tipoVehiculo) {
        int plazasVehiculo = 0;

        for (int i = 0; i < parkingPlazas.length; i++) {
            for (int j = 0; j < parkingPlazas[i].length; j++) {
                if (tipoVehiculo == j) {
                    plazasVehiculo += parkingPlazas[i][j];
                }
            }
        }
        return plazasVehiculo;
    }

    /**
     * [opción 4 del menú] Este método devuelve el número total de plazas de un
     * parking concreto
     *
     * @param numParking
     * @return
     */
    public static int obtenerNumPlazasPorParking(int numParking) {
        int plazasParking = 0;
        
        for (int i = 0; i < parkingPlazas[numParking].length; i++) {
            plazasParking += parkingPlazas[numParking][i];
        }
        
        return plazasParking;
    }

    /**
     * [opción 5 del menú] Este método devuelve el número de plazas de un
     * parking concreto y de un tipo de vehículo concreto.
     *
     * @param numParking
     * @param tipoVehiculo
     * @return
     */
    public static int obtenerNumPlazasPorParkingPorTipoVehiculo(int numParking, int tipoVehiculo) {
        return parkingPlazas[numParking][tipoVehiculo];
    }

    /**
     * [opción 6 del menú] Este método intercambia el número de plazas de un
     * tipo de vehículo por otro dentro de un mismo parking
     *
     * @param numParking
     * @param tipoVehiculo1
     * @param tipoVehiculo2
     */
    public static void intercambiarPlazas(int numParking, int tipoVehiculo1, int tipoVehiculo2) {
        int aux;
            aux = parkingPlazas[numParking][tipoVehiculo1];
            parkingPlazas[numParking][tipoVehiculo1] = parkingPlazas[numParking][tipoVehiculo2];
            parkingPlazas[numParking][tipoVehiculo2] = aux;
    }

    /**
     * [opción 7 del menú] Este método muestra por consola el número total de
     * plazas por parking de forma descendente
     */
    public static void mostrarNumPlazasPorParkingOrdenadasDesc() {
        int[] plazasPorParking = new int[parkingPlazas.length];
        
        for (int i = 0; i < plazasPorParking.length; i++) {
            plazasPorParking[i] = obtenerNumPlazasPorParking(i);
        }
        
        Arrays.sort(plazasPorParking);
        for (int i = plazasPorParking.length-1; i >= 0; i--) {
            System.out.print(" ["+plazasPorParking[i]+"] ");
        }
        
    }

}
