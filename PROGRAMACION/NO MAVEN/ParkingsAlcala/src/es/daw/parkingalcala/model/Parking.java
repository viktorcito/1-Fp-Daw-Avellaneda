package es.daw.parkingalcala.model;

import java.util.ArrayList;

import es.daw.parkingalcala.excepciones.ParkingCompletoException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author melola
 */
public class Parking{

    private int id, capacidad;
    
    private String nombre, direccion;
    
    private double cantidadGanada;
    
    private ArrayList<Coche> coches;
    
    private final int TARIFA = 5;
    
    private Seguro seguro;
    
    public Parking(String nombre, String direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        coches = new ArrayList<>(); //Al crear el parking creo la lista de coches
                                    //para que puedan aparcar los coches
                                    
        // Para evitar problemas al trabajar con nulos creo un seguro por defecto
        this.seguro = new Seguro(0,"No asegurado", LocalDate.now());
        
    }

    /* Getter de todo, porsiaca */
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCantidadGanada() {
        return cantidadGanada;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }
    
    /* Setters de los tres parámetros del constructor */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    /**
     * Método para obtener el % de ocupación local
     * @return 
     */
    private int getPorcentajeOcupacion(){
        
    }
    
    /**
     * Método para obtener el % de ocupación total
     * @return 
     */
    private int getPorcentajeOcupacionTotal(){
        
    }
    
    // MÉTODOS PÚBLICOS
    /**
     * 
     * @param c
     * @throws ParkingCompletoException 
     */
    public void addCoche(Coche c){
        
    }

    /**
     * 
     * @param posicion 
     */
    public void deleteCoche(int posicion){
        
    }
    
    /**
     * 
     * @return 
     */
    private int getNumero_Coches(){
        
    }
    
    /**
     * 
     * @return 
     */
    public String mostrarCoches(){
        
    }
    
    /**
     * 
     * @return 
     */
    private String mostrarCochesElectricos(){
        
    }
         
    private int getNumCochesElectricos(){
        
    }
    
    @Override
    public String toString() {
        String mensaje = String.format("\n********* INFORMACIÓN DEL PARKING ****************"
                + "\nEl parking %s con id %d"
                + ", situado en %s, cuenta con una capacidad de %d coches."
                + "\nEl porcentaje de ocupación es del %d %%"
                + "\n\nEsta es la cantidad de coches aparcados en el parking: %d"
                + "\nSolo son eléctricos: %d"
                + "\n\nEn Alcalá hay %d plazas disponibles."
                + "\nEl porcentaje de ocupación total es del %d %%"
                + "\n\nEl seguro del parking está contratado con la aseguradora %s."
                + "\nEl número de póliza es %d y quedan %d días para que se cumpla el seguro."
                + "\n*************************************************************************",
                nombre,
                id,
                direccion,
                capacidad, 
                getPorcentajeOcupacion(),
                coches.size(),
                getNumCochesElectricos(),
                capacidadTotal,
                getPorcentajeOcupacionTotal(),
                seguro.getNombreAseguradora(),seguro.getNumPoliza(),ChronoUnit.DAYS.between(LocalDate.now(),seguro.getFechaFinSeguro()));
        return mensaje;
    }
    
    
    
    
}
