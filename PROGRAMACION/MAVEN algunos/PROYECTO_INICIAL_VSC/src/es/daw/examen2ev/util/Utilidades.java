package es.daw.examen2ev.util;

import java.util.ArrayList;
import java.util.Collections;

import es.daw.examen2ev.exception.DniFormatException;
import es.daw.examen2ev.model.Arco;
import es.daw.examen2ev.model.Arma;
import es.daw.examen2ev.model.EspadaAcero;
import es.daw.examen2ev.model.EspadaHielo;
import es.daw.examen2ev.model.GestorArmas;
import es.daw.examen2ev.model2.AgenteDAO;
import es.daw.examen2ev.model2.Cliente;
import es.daw.examen2ev.model2.Corporatable;
import es.daw.examen2ev.model2.Empleado;

/**
 *
 * @author melola
 */
public class Utilidades {

    /**
     * ejecutaEjercicio1
     */
    public static void ejecutaEjercicio1(){
        System.out.println("\n ********** EJERCICIO 1 *************");
        String dnis = "15007335L,9104351E,21947107A,52991600Z,12345V";


        // PENDIENTE DE COMPLETAR

    }

    /**
     * ejecutaEjercicio2
     */
    public static void ejecutaEjercicio2(){

        // NO TOCAR!!!! IMPLEMENTA EL MODELADO DE CLASES EN model2 SEGÚN LAS ESPECIFICACIONES

        System.out.println("\n ********** EJERCICIO 2 *************");
        GestorArmas gestor = new GestorArmas();

        gestor.addArma(new EspadaAcero("Espada de acero inoxidable", 100, true));
        gestor.addArma(new EspadaHielo("Espada de hielo polar", 50, false));
        gestor.addArma(new Arco("Arco olímpico", 75, 125.5f));

        System.out.println("* Número de armas creadas:"+Arma.getContador());

        System.out.println("\n* Listado de armas:");
        System.out.println(gestor);

        gestor.removeArma();

        System.out.println("\n* Listado después de borrar todas las armas:");
        System.out.println(gestor);


    }

    /**
     * ejecutaEjercicio3
     */
    public static void ejecutaEjercicio3(){
        System.out.println("\n ********** EJERCICIO 3 *************");

        // PENDIENTE DE COMPLETAR



        
        System.out.println("* Listado de empleados ordenados de forma natural (razón social):");

        // PEDIENTE DE COMPLETAR




        System.out.println("* Listado de clientes:");
        
        // PEDIENTE DE COMPLETAR





        // -----------------------------------------------------------------
        System.out.println("******* COMPROBANDO SI UN CLIENTE EXISTE *********");
        Cliente clienteOK = new Cliente("Quantum Dynamics Innovations");
        Cliente clienteKO = new Cliente("Avellanda Sofware");


        // PEDIENTE DE COMPLETAR



        
        // -----------------------------------------------------------------
        System.out.println("******* CÓDIGOS DE DEPARTAMENTO QUE EMPIEZAN POR C *********");

        // PEDIENTE DE COMPLETAR

    }

        

}
