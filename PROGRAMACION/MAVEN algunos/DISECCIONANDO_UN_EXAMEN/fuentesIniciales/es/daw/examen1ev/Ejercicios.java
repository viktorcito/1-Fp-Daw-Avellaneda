/*
 * Clase de utilidades con métodos estáticos 
 * 
 */
package es.daw.examen1ev;

/**
 *
 * @author melola
 */
public class Ejercicios {

    static final int PRECIO_MATRICULA_GM = 50;
    static final int PRECIO_MATRICULA_GS = 70;
    
    static final String[] LETRAS = {"A","B","C","D","E","F","G","H"};
    

    /**
     * EJERCICIO 1 
     */
    public static void ejecutaEjercicio1() {
        
        System.out.println("Menú....");
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
            "Lucas,33333333B,32,2,gs",
        };

        
        System.out.println("1.No hay DNIs repetidos");
        System.out.println("1.El primer DNI repetido es: ");

        
        System.out.println("2.La edad media de los alumnos matriculados es: ");

        
        System.out.println("3.El nombre del alumno que ha pagado más por la matrícula es: ");

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
        
        
        System.out.println("\n2. COMPRAR ENTRADAS:");
        
        // 2 entradas
        System.out.println("Compra de 2 entradas. Los asientos asignados son: ");
        
        // 6 entradas
        System.out.println("Compra de 6 entradas. Los asientos asignados son: ");
        
        // 4 entradas
        System.out.println("Compra de 4 entradas. Los asientos asignados son: ");
        System.out.println("Compra de 4 entradas. No se ha podido reservar entradas en la misma fila");
        
        System.out.println("\n3. ESTADO DEL CINE TRAS LAS COMPRAS:");

        
        System.out.println("\n4. CINE AMPLIADO CON DOS FILAS:");

        
        System.out.println("\n5. VUELVO A INTENTAR COMPRAR 4 ENTRADAS:");
        System.out.println("Compra de 4 entradas. Los asientos asignados son: ");
        

        System.out.println("\n6. ESTADO DEL CINE TRAS LAS COMPRAS:");


    }

    /**
     * ********************************
     * MÉTODOS AUXILIARES
     * ********************************
     */
    
    
    
    
    
    
}
