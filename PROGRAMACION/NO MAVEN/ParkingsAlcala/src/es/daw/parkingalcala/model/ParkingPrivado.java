package es.daw.parkingalcala.model;

/**
 *
 * @author melola
 */
public class ParkingPrivado{
    private int numSocios;

    public ParkingPrivado(int numSocios, String nombre, String direccion, int capacidad) {
        super(nombre, direccion, capacidad);
        this.numSocios = numSocios;
    }
    
    // El número de socios se puede modificar en un futuro
    public void setNumSocios(int numSocios){
        this.numSocios = numSocios;
    }
    
    
}
