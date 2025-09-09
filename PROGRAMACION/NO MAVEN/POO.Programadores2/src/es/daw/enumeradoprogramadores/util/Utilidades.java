package es.daw.enumeradoprogramadores.util;

import static es.daw.enumeradoprogramadores.EnumeradoProgramadores.sc;
import es.daw.enumeradoprogramadores.model.Lenguajes;
import es.daw.enumeradoprogramadores.model.Programador;
import java.util.ArrayList;

/**
 *
 * @author melol
 */
public class Utilidades {

    public static void pintaMenu() {

        System.out.println("************** MENÚ PRINCIPAL ***************");
        System.out.println("1.- Dar de alta un programador");
        System.out.println("2.- Consultar información de programador (por DNI)");
        System.out.println("3.- Consultar información de todos los programadores");
        System.out.println("4.- Eliminar un programador de la lista (por DNI)");
        System.out.println("5.- Número total de programadores expertos en un lenguaje concreto");
        System.out.println("6.- Salir");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Elige una opción:");

    }

    //Opcion 1
    public static void darProgramadorAlta(ArrayList<Programador> programadores) {
        System.out.println("Vas a dar de alta a un programador");
        System.out.println("1. Escribe DNI");
        String dni = sc.nextLine();
        System.out.println("2. Escribe el nombre");
        String nombre = sc.nextLine();
        System.out.println("3. Escribe la edad");
        int edad = sc.nextInt();
        System.out.println("4. Escribe el lenguaje");

        //pintar los nombres de los lenguajes
        Lenguajes[] lenguajes = Lenguajes.values();
        for (int i = 0; i < lenguajes.length; i++) {
            Lenguajes l = lenguajes[i];
            System.out.println(l.name());
        }
        System.out.println("--------------");

        Lenguajes leng = null;

        try {

            leng = Lenguajes.valueOf(sc.nextLine());

        } catch (java.lang.IllegalArgumentException e) {
            System.out.println("capturao");
            e.printStackTrace();
        }

        System.out.println("5. Escribe los años de exp");
        int anios = sc.nextInt();

        Programador p = new Programador(dni, nombre, edad, leng, anios);
        programadores.add(p);
    }

    //Opcion 2 Consultar informacion de programador (por DNI) y el otro metodo devuelve la posicion
    //del programador en lista
    public static String consultarProgramadorById(ArrayList<Programador> programadores) {
        String info = "";

        int posicion = getPosicionProgramador(programadores);
        if (posicion != -1) {
            info = programadores.get(posicion).toString();
        } else {
            info = "No existe el programador";
        }
        return info;
    }

    private static int getPosicionProgramador(ArrayList<Programador> programadores) {
        System.out.println("Indica el DNI del programador:");
        String dni = sc.nextLine();

        Programador p = new Programador(dni);
        return programadores.indexOf(p);
    }

    //Opcion 3 del menu
    public static void eliminarProgramadorById(ArrayList<Programador> programadores) {
        int posicion = getPosicionProgramador(programadores);
        if (posicion != -1) {
            programadores.remove(posicion).toString();
            System.out.println("Programador borrado");
        } else {
            System.out.println("No existe el programdor");
        }
    }

    public static Lenguajes getListadoLenguajes() {

        boolean correcto = true;
        Lenguajes lenguajeConsultar = Lenguajes.C;

        do {
            Lenguajes[] lenguajes = Lenguajes.values();
            for (int i = 0; i < lenguajes.length; i++) {
                Lenguajes l = lenguajes[i];
                System.out.println((i + 1) + " - " + l.name());
            }
            System.out.println("Elige el numero del lenguaje: ");
            int posicionLenguaje = sc.nextInt();

            switch (posicionLenguaje) {
                case 1:
                    lenguajeConsultar = Lenguajes.JAVA;
                    break;
                case 2:
                    lenguajeConsultar = Lenguajes.PHP;
                    break;
                case 3:
                    lenguajeConsultar = Lenguajes.C;
                    break;
                case 4:
                    lenguajeConsultar = Lenguajes.PERL;
                    break;
                case 5:
                    lenguajeConsultar = Lenguajes.RUBY;
                    break;
                case 6:
                    lenguajeConsultar = Lenguajes.PYTHON;
                    break;
                default:
                    System.out.println("Has introducido un numero de opcion incorrecta");
                    correcto = false;
            }
        }while (!correcto);
        
        return lenguajeConsultar;
    }
    
    
    
    public static int getNumProgsExpByLeng(ArrayList<Programador> progamadores, Lenguajes lenguajeConsultar){
        int contExpertos =0;
        for (Programador p : progamadores) {
            if (p.getLenguajes()== lenguajeConsultar){
                if (p.getAniosExperiencia() >= lenguajeConsultar.getAniosAprendizaje()){
                    contExpertos++;
                }
            }
        }
        return contExpertos;
    }

}
