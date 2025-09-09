package es.daw.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author daw1a
 */
public class Utils {

    /**
     * Método que devuelve una cadena de texto con la fecha actual del sistema
     * en formato dd/MM/YYYY HH:mm:ss
     *
     * @return fecha dd/MM/YYYY HH:mm:ss
     */
    public static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        String formatoFecha = sdf.format(new Date());
        return formatoFecha;
    }

    /**
     * Método que devuelve una cadena de texto con la fecha actual 
     * en formato dd_MM_YYYY
     * @return fecha dd_MM_YYYY
     */
    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY");
        String formatoFecha = sdf.format(new Date());
        return formatoFecha;
    	
    }
	
    /**
     * PENDIENTE COMPLETAR
     * Este método guarda información de un empleado (NIF, nombre) en una colección 
     * y pinta por consola el contenido de la colección (va creciendo según se añaden empleados)
     * ordenados por NIF ascendente
     * @param e
     */

    public static void guardarNuevosEmpleadosEnColeccion(Empleado e) {
    	
    	
    }
	

}
