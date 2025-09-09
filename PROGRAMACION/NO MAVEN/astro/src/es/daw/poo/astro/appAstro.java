/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.poo.astro;

import es.daw.poo.astro.model.Astro;
import es.daw.poo.astro.model.Planeta;
import es.daw.poo.astro.model.Satelite;
import java.util.ArrayList;

/**
 *
 * @author VSPC
 */
public class appAstro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        ArrayList<Astro> astros = new ArrayList<>();
        
        Planeta tierra = new Planeta("Tierra", 5.97E24, 12742.0, 1.0, 365.25, 
                14.05, 9.78, 146600000.0);
        
        Satelite luna = new Satelite("Luna", 7.349E22, 3474.0, 27.5, 
                27.5, -153.0, 1.62, 384400.0, tierra);        
        
    }
    
}
