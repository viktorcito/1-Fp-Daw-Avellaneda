package es.daw.examen1ev.ejercicio1;

import es.daw.examen1ev.ejercicio1.util.Utilidades;
import java.util.Scanner;

/*
 * Módulo de Programación
 * Examen primera evaluación 2022-23
 * Ejercicio 1
 */
public class ParkingsAlcala {

    //ARRAY CONSTANTE: Nombre de los cuatro parkings públicos de Alcalá
    public static final String[] NOMBRE_PARKINGS = {"El Mercado", "San Lucas", "Obispado", "La Paloma"};

    //ARRAY CONSTANTE: Nombre de los cuatro tipos de vehículos con plazas de aparcamiento en los parkings de Alcalá
    public static final String[] NOMBRE_VEHICULOS = {"coche", "moto", "furgoneta", "camión"};

    public static Scanner sc = new Scanner(System.in);

    public static int[][] parkingPlazas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion, tipoVehiculo, numParking;

        System.out.println("**BIENVENIDO AL SISTEMA DE INFORMACIÓN DE PLAZAS DE APARCAMIENTO DE ALCALÁ DE HENARES **");

        // 1. CARGAR LOS DATOS DIRECTAMENTE AL INICIAR EL PROGRAMA ( utiliza Utilidades.cargarDatos() )
        parkingPlazas = Utilidades.cargarDatos();

        // 2. MOSTRAR EL MENÚ Y SE GESTIONAR LAS DIFERENTES OPCIONES DEL MISMO
        do {
            Utilidades.mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Utilidades.mostrarInformeGeneral();
                    break;
                case 2:
                    System.out.println("\tEl número de plazas totales en Alcalá es: " + Utilidades.obtenerNumPlazasTotal());
                    break;
                case 3:
                    System.out.println("Indica el tipo de vehículo (1: coche, 2: moto, 3. fugoneta, 4: camión)");
                    tipoVehiculo = sc.nextInt();
                    tipoVehiculo--;

                    System.out.println("\tEl número de plazas en Alcalá de < " + NOMBRE_VEHICULOS[tipoVehiculo] + " > es: " + Utilidades.obtenerNumPlazasPorTipoVehiculo(tipoVehiculo));

                    break;
                case 4:
                    System.out.println("Indica el número de parking (1: El Mercado, 2: San Lucas, 3: Obispado, 4: La paloma):");
                    numParking = sc.nextInt();
                    numParking--;

                    System.out.println("El número de plazsas del parking < " + NOMBRE_PARKINGS[numParking] + " > es: " + Utilidades.obtenerNumPlazasPorParking(numParking));

                    break;
                case 5:
                    System.out.println("\nIndica el tipo de vehículo (1: coche, 2: moto, 3: furgoneta, 4: camión)");
                    tipoVehiculo = sc.nextInt();

                    System.out.println("\nIndica el número de parking (1: El Mercado, 2: San Lucas, 3: Obispado, 4: La paloma):");
                    numParking = sc.nextInt();

                    tipoVehiculo--;
                    numParking--;

                    System.out.println("El número de plazas de < " + NOMBRE_VEHICULOS[tipoVehiculo] + "> del parking < " + NOMBRE_PARKINGS[numParking] + "> es: "
                            + Utilidades.obtenerNumPlazasPorParkingPorTipoVehiculo(numParking, tipoVehiculo));
                    break;
                case 6:
                    int vehiculo1,
                     vehiculo2;

                    System.out.println("Indica el número de parking donde intercambiar plazas (1: El Mercado, 2: San Lucas, 3: Obispado, 4: La Paloma):");
                    numParking = sc.nextInt();
                    System.out.println("Indica el primer tipo de vehículo (1: coche, 2: moto, 3: furgoneta, 4: camión");
                    vehiculo1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Indica el segundo tipo de vehículo para intercambiar las plazas (1: coche, 2: moto, 3: furgoneta, 4: camión");
                    vehiculo2 = sc.nextInt();

                    numParking--;
                    vehiculo1--;
                    vehiculo2--;

                    Utilidades.intercambiarPlazas(numParking, vehiculo1, vehiculo2);

                    System.out.println("Se ha intercambiado correctamente las plazas de < " + NOMBRE_VEHICULOS[vehiculo1]
                            + " > a < " + NOMBRE_VEHICULOS[vehiculo2] + " > en el parking < " + NOMBRE_PARKINGS[numParking] + " >");
                    break;
                case 7:
                    System.out.println("Número de plazas por parking ordenadas descendentemente:");
                    Utilidades.mostrarNumPlazasPorParkingOrdenadasDesc();
                    break;
                case 8:
                    System.out.println("Saliendo del programa ¡¡Hasta pronto!!");
                    break;
                default:
                    System.out.println("Introduce una opción válida.\n");
            }
        } while (opcion != 8);
    }

}
