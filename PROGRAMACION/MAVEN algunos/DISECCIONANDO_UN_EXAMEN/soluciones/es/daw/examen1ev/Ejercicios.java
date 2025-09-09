/*
 * Clase de utilidades con métodos estáticos 
 * 
 */
package es.daw.examen1ev;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author melola
 */
public class Ejercicios {

    static final int PRECIO_MATRICULA_GM = 50;
    static final int PRECIO_MATRICULA_GS = 70;

    static final String[] LETRAS = {"A", "B", "C", "D", "E", "F", "G", "H"};

    /**
     * EJERCICIO 1
     */
    public static void ejecutaEjercicio1() {

        Scanner sc = new Scanner(System.in);

        int opcion = 3;
        do {
            System.out.println("\n**** MENÚ PRINCIPAL ****");
            System.out.println("1. Opción 1\n2. Opción 2\n3. Salir\n"
                    + "*****************\n"
                    + "Elige una opción:");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido la opción 1");
                    break;
                case 2:
                    int opcion2 = 2;
                    do {
                        System.out.println("\t******* SUBMENÚ *********");
                        System.out.println("\t1. Número aleatorio entre 5 y 10\n"
                                + "\t2. Volver al menú principal\n"
                                + "\t****************************\n"
                                + "\tElige una opción:");
                        opcion2 = sc.nextInt();

                        switch (opcion2) {
                            case 1:
                                System.out.println("\nNúmero aleatorio: " + (int) ((Math.random() * 5) + 5));
                                break;
                            case 2:
                                System.out.println("Vuelves al menú principal!!!");
                                opcion2 = 2;
                                break;
                            default:
                                System.out.println("Debes elegir una opción correcta.");
                                break;
                        }
                    } while (opcion2 != 2);

                    break;
                case 3:
                    System.out.println("Vas a salir del programa");
                    break;
                default:
                    System.out.println("Elige una opción correcta");

            }
        } while (opcion != 3);

    }

    /**
     *
     * EJERCICIO 2
     */
    public static void ejecutaEjercicio2() {

        String[] matriculas = {
            "Ana,11111111A,18,6,GM",
            "Juan,11111111B,25,3,GS",
            "Sonia,22222222A,42,6,GS",
            "Pepe,22222222B,21,2,Gm",
            "Lucas,11111111B,32,2,gs",
            "Lola,33333333B,32,4,gs",
            "Lucas,33333333B,32,2,gs",};

        String[] nombres = new String[matriculas.length];
        String[] dnis = new String[matriculas.length];
        String[] edades = new String[matriculas.length];
        String[] numModulos = new String[matriculas.length];
        String[] ciclos = new String[matriculas.length];

        // Cargo los datos en arrays diferentes de la misma longitud
        for (int i = 0; i < matriculas.length; i++) {
            String[] matricula = matriculas[i].split(",");
            nombres[i]= matricula[0]; //nombre
            dnis[i] = matricula[1]; //dni
            edades[i] = matricula[2]; //edad
            numModulos[i] = matricula[3]; //numModulos
            ciclos[i] = matricula[4]; //ciclo
//            nombres[i] = matriculas[i].split(",")[0]; //nombre
//            dnis[i] = matriculas[i].split(",")[1]; //dni
//            edades[i] = matriculas[i].split(",")[2]; //edad
//            numModulos[i] = matriculas[i].split(",")[3]; //numModulos
//            ciclos[i] = matriculas[i].split(",")[4]; //ciclo

        }

        // Si no sabes cargar el array de dnis y edades partiendo de matriculas
//         String[] nombres = {"Ana","Juan","Sonia","Pepe","Lucas"};
//         String[] dnis = {"11111111A","11111111B","22222222A","22222222B","11111111A"};
//         String[] edades = {"18","25","42","21","32"};
//         String[] numModulos = {"6","3","6","2","2"};
//         String[] ciclos = {"GM","GS","Gm","gs"};
//        if (comprobarDNIs(dnis)) {
//            System.out.println("1.Hay DNIs repetidos");
//        } else {
//            System.out.println("1.No hay DNIs repetidos");
//        }
        int posDNIRepe = comprobarDNIs(dnis);
        if (posDNIRepe == -1) {
            System.out.println("1.No hay DNIs repetidos");
        } else {
            System.out.println("1. El primer DNI repetido es: " + dnis[posDNIRepe]);
        }

        System.out.println("2.La edad media de los alumnos matriculados es: " + obtenerEdadMedia(edades));

        System.out.println("3.El nombre del alumno que ha pagado más por la matrícula es: " + obtenerNombreAlumnoMayorImporte(nombres, numModulos, ciclos));

    }

    /**
     * EJERCICIO 3
     *
     */
    public static void ejecutaEjercicio3() {

        char[][] cine = {
            {'-', '-', '-', '-', 'X', 'X', 'X', 'X'},
            {'-', '-', '-', 'X', 'X', 'X', '-', '-'},
            {'-', 'X', '-', '-', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', '-', '-', '-'},
            {'X', 'X', '-', '-', '-', '-', '-', '-'}};

        System.out.println("1. ESTADO DEL CINE:");
        pintaCine(cine);

//        // Asiento 2C
//        int fila = 2;
//        int columna = 3;
//        
//        System.out.println("\n2. ASIENTOS LIBRES:");
//        System.out.println("El asiento 2C está libre:"+esAsientoLibre(cine,fila-1,columna-1));
//        
//        // Asiento 3E
//        fila = 3;
//        columna = 5;
//        
//        
//        System.out.println("El asiento 3E está libre:"+esAsientoLibre(cine,fila-1,columna-1));
        System.out.println("\n2. COMPRAR ENTRADAS:");
        String[] entradasCompradas;

        // -----------------------------------
        // 2 entradas
        
        System.out.println("\t COMPRANDO DOS ENTRADAS:");
        int filaLibre = obtenterFilaLibre(cine,2);
        
        if (filaLibre != -1){
            System.out.println("\tHay 2 asientos libres en la misma fila...");
            entradasCompradas = comprarEntrasEnFila(cine,2,filaLibre);
            System.out.println("\tCompra de 2 entradas. Los asientos asignados son: " + Arrays.toString(entradasCompradas));
        }
        else
            System.out.println("\tNo hay 2 asientos libres en la misma fila...");
        
//        entradasCompradas = comprarEntradas(cine, 2);

        // -----------------------------------
        // 6 entradas
        filaLibre = obtenterFilaLibre(cine,6);
        
        if (filaLibre != -1){
            System.out.println("\tHay 6 asientos libres en la misma fila...");
            entradasCompradas = comprarEntrasEnFila(cine,6,filaLibre);
            System.out.println("\tCompra de 6 entradas. Los asientos asignados son: " + Arrays.toString(entradasCompradas));
        }
        else
            System.out.println("\tNo hay 6 asientos libres en la misma fila...");
        
        
//        entradasCompradas = comprarEntradas(cine, 6);

        // -----------------------------------
        // 4 entradas
        filaLibre = obtenterFilaLibre(cine,4);
        
        if (filaLibre != -1){
            System.out.println("\tHay 4 asientos libres en la misma fila...");
            entradasCompradas = comprarEntrasEnFila(cine,4,filaLibre);
            if (entradasCompradas != null) {
                System.out.println("Compra de 4 entradas. Los asientos asignados son: " + Arrays.toString(entradasCompradas));
            } else {
                System.out.println("Compra de 4 entradas. No se ha podido reservar entradas en la misma fila");
            }
        }
        else
            System.out.println("\tNo hay 4 asientos libres en la misma fila...");
        
//        entradasCompradas = comprarEntradas(cine, 4);

        System.out.println("\n3. ESTADO DEL CINE TRAS LAS COMPRAS:");
        pintaCine(cine);

        System.out.println("\n4. CINE AMPLIADO CON DOS FILAS:");
        cine = ampliarCine(cine, 2);
        pintaCine(cine);

        System.out.println("\n5. VUELVO A INTENTAR COMPRAR 4 ENTRADAS:");
        entradasCompradas = comprarEntradas(cine, 4);
        System.out.println("Compra de 4 entradas. Los asientos asignados son: " + Arrays.toString(entradasCompradas));

        System.out.println("\n6. ESTADO DEL CINE TRAS LAS COMPRAS:");
        pintaCine(cine);

    }

    /**
     * ********************************
     * MÉTODOS AUXILIARES ********************************
     */
    /**
     *
     * @param matriculas
     * @return
     */
    //private static boolean comprobarDNIs(String[] dnis) {
    private static int comprobarDNIs(String[] dnis) {

//        // Ordeno ascendente
//        Arrays.sort(dnis);
//
//        // Si están ordenados, si hay repetidos, uno debe ser igual al siguiente 
//        boolean repetido = false;
//        int cont = 0;
//        do {
//            if (dnis[cont].equalsIgnoreCase(dnis[cont + 1])) {
//                repetido = true;
//            }
//            cont++;
//        } while (!repetido && cont < (dnis.length - 1));
//
//        return repetido;
        for (int i = 0; i < dnis.length; i++) {
            for (int j = i + 1; j < dnis.length; j++) {
                if (dnis[i].equals(dnis[j])) {
                    return i;
                }
            }

        }

        return -1;

        // ESTO NO FUNCIONA BIEN
//        for (int i = 0; i < dnis.length; i++) {
//            int pos = Arrays.binarySearch(dnis, dnis[i]);
//            if ( pos != -1 )
//                return i;
//        }
//        return -1;
    }

    /**
     *
     * @param edades
     * @return
     */
    private static int obtenerEdadMedia(String[] edades) {
        float sumaEdad = 0;
        for (int i = 0; i < edades.length; i++) {
            sumaEdad += Integer.parseInt(edades[i]); // convertir datos
        }
        return Math.round(sumaEdad / edades.length);
    }

    /**
     *
     * @param nombres
     * @param numModulos
     * @param ciclos
     * @return
     */
//    private static String obtenerNombreAlumnoMayorImporte(String[] nombres, String[] numModulos, String[] ciclos) {
//
//        int[] importes = new int[nombres.length];
//        int importeAux = 0;
//        int posicion = 0;
//
//        for (int i = 0; i < numModulos.length; i++) {
//            int importe = 0;
//            int num = Integer.parseInt(numModulos[i]);
//            if (ciclos[i].equalsIgnoreCase("GM")) {
//                importe += num * PRECIO_MATRICULA_GM;
//            } else {
//                importe += num * PRECIO_MATRICULA_GS;
//            }
//
//            if (i == 0) {
//                importeAux = importe;
//            } else {
//                if (importeAux < importe) {
//                    importeAux = importe; // machaco el importe con el nuevo importe mayor
//                    posicion = i;
//                }
//            }
//            importes[i] = importe;
//        }
//
//        return nombres[posicion];
//    }

    private static String obtenerNombreAlumnoMayorImporte(String[] nombres, String[] numModulos, String[] ciclos) {

        int importeMayor = 0;
        int posicion = 0;

        for (int i = 0; i < numModulos.length; i++) {
            int importe = 0;
            int num = Integer.parseInt(numModulos[i]);
            if (ciclos[i].equalsIgnoreCase("GM")) {
                importe += num * PRECIO_MATRICULA_GM;
            } else {
                importe += num * PRECIO_MATRICULA_GS;
            }

            if (importeMayor < importe) {
                importeMayor = importe; // machaco el importe con el nuevo importe mayor
                posicion = i;
            }
            
        }

        return nombres[posicion];
    }
    
    /**
     * *************************************************************
     */
    /* ************************ CINE ****************************** */
    /**
     * *************************************************************
     */
    private static void pintaCine(char[][] cine) {
        //System.out.println("Asiento: [A  B  C  D  E  F  G  H]");
        for (String letra : LETRAS) {
            System.out.print("[" + letra + "]");
        }
        System.out.println("");
        for (int i = 0; i < cine.length; i++) {
            //for (int j = 0; j < cine[i].length; j++) {
            System.out.println(Arrays.toString(cine[i]) + " Fila " + (i + 1));
            //}

        }
    }

//    private static boolean esAsientoLibre(char[][] cine,int fila, int col){
//        return (cine[fila][col] == '-');
//    }
    /**
     *
     * @param cineOriginal
     * @param numFilas
     * @return
     */
    private static char[][] ampliarCine(char[][] cineOriginal, int numFilas) {

        // Especifico el tamaño del nuevo cine ampliado
        char[][] cineAmpliado = new char[cineOriginal.length + numFilas][LETRAS.length];

        // Clono la matriz (deep clone)
        for (int i = 0; i < cineOriginal.length; i++) {
            cineAmpliado[i] = cineOriginal[i].clone();
        }

        // Pongo los asientos vacíos
        for (int i = cineOriginal.length; i < cineAmpliado.length; i++) {
            for (int j = 0; j < LETRAS.length; j++) {
                cineAmpliado[i][j] = '-';
            }

        }

        return cineAmpliado;
    }

    /**
     *
     * @param cine
     * @param numEntradas
     * @return
     */
    private static String[] comprarEntradas(char[][] cine, int numEntradas) {

        String[] asientos = new String[numEntradas];

        int indiceAsiento = 0;
        for (int i = 0; i < cine.length; i++) {
            
            // Por cada fila, busco entradas consecutivas en la misma fila
            int contador = 0; // para saber cuantas entradas consecutivas voy teniendo
            indiceAsiento = 0; // índice del array que guarda el nombre del asiento

            // recorro las columnas. Voy asiento por asiento de la fila
            for (int j = 0; j < cine[i].length; j++) {
                //busco el primer libre en la fila
                if (cine[i][j] == '-') {

                    char[] copiaFila = cine[i].clone(); //copio para dejar la fila como al principio si no encuentro asientos

                    contador = 1; //he encontrado el primer asiento
                    asientos[indiceAsiento] = (i + 1) + LETRAS[j];
                    cine[i][j] = 'X';

                    //busco si hay en la misma fila
                    int k = j + 1; //incremento la columna

                    // Ya tengo la primer entrada. Recorro el resto de columnas
                    while (contador < numEntradas && k < cine[i].length) {

                        if (cine[i][k] == '-') {
                            indiceAsiento++;
                            contador++;
                            asientos[indiceAsiento] = (i + 1) + LETRAS[k];
                            cine[i][k] = 'X';
                            k++;
                        } else {
                            k = cine[i].length; //Para cortar el while. Simulo que he llegado al final
                        }
                    }
                    // Una vez recorrida la fila
                    if (contador >= numEntradas) {
                        //he encontrado asientos libres en la misma fila
                        return asientos;
                    }

                    // Si paso por aquí es que no ha encontrado asientos en la misma fila
                    // Vuelvo a dejar la fila como está
                    indiceAsiento = 0;
                    cine[i] = copiaFila.clone();
                    // limpio los nombres de asientos que he ido asignando
                    for (int a = 0; a < asientos.length; a++) {
                        asientos[a] = "";
                    }
                    j = cine[i].length; // parar de procesar el resto de columnas. Para que termine el for que recorre filas
                }
            }
        }
        return null; //devuelvo el array nulo de asientos

    }

    /**
     * obtenterFilaLibre
     * @param cine
     * @param numEntradas
     * @return 
     */
    private static int obtenterFilaLibre(char[][] cine, int numEntradas) {

        for (int i = 0; i < cine.length; i++) {
            
            // Por cada fila, busco entradas consecutivas en la misma fila
            int contador = 0; // para saber cuantas entradas consecutivas voy teniendo

            // recorro las columnas. Voy asiento por asiento de la fila
            for (int j = 0; j < cine[i].length; j++) {
                //busco el primer libre en la fila
                if (cine[i][j] == '-') {

                    contador = 1; //he encontrado el primer asiento

                    //busco si hay en la misma fila
                    int k = j + 1; //incremento la columna

                    // Ya tengo la primer entrada. Recorro el resto de columnas
                    while (contador < numEntradas && k < cine[i].length) {

                        if (cine[i][k] == '-') {
                            contador++;
                            k++;
                        } else {
                            k = cine[i].length; //Para cortar el while. Simulo que he llegado al final
                        }
                    }
                    // Una vez recorrida la fila
                    if (contador >= numEntradas) {
                        //he encontrado asientos libres en la misma fila
                        return i;
                    }

                    j = cine[i].length; // parar de procesar el resto de columnas. Para que termine el for que recorre filas
                }
            }
        }
        return -1;

    }
    
    private static String[] comprarEntrasEnFila(char[][] cine, int numEntradas, int numFila) {

        String[] asientos = new String[numEntradas];

        int indiceAsiento = 0;
        
        for (int j = 0; j < cine[numFila].length; j++) {
            //busco el primer libre en la fila
            if (cine[numFila][j] == '-' && indiceAsiento < numEntradas) {
                asientos[indiceAsiento] = (numFila + 1) + LETRAS[j];
                cine[numFila][j] = 'X';
                indiceAsiento++;
            }
        }
        
        return asientos; //devuelvo el array nulo de asientos

    }
    
    
}
