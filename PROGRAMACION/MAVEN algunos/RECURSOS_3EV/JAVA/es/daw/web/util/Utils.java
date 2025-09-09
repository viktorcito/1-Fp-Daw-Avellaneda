package es.daw.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author daw1a
 */
public class Utils {

    /**
     * Método que devuelve verdadero/falso dependiendo de si se cumple la 
     * expresión regular
     * @param expresionRegular String con la expresión regular
     * @param cadena String con la cadena de texto a validar
     * @return boolean
     */
    public static boolean checkExpresionRegular(String expresionRegular, String cadena){
        Pattern pat = Pattern.compile(expresionRegular);
        Matcher mat = pat.matcher(cadena);
        return (mat.matches());
        
    }
    
    /**
     * Método que devuelve una cadena de texto con la fecha actual del sistema
     * en formato dd/MM/YYYY HH:mm:ss
     * @return 
     */
    public static String getDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        String formatoFecha = sdf.format(new Date());
        return formatoFecha;
    }    
}
