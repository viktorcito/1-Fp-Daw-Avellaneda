package es.daw.parkingalcala.model;

/**
 *
 * @author melola
 */
public class ParkingPublico extends Parking{
    private int numTrabajadoresDiscapacitados;

    public ParkingPublico(int numTrabajadoresDiscapacitados, String nombre, String direccion, int capacidad) {
        super(nombre, direccion, capacidad);
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }
    
    // Doy por hecho que el numTrabajadoresDiscapacitados lo podré modificar
    // en un futuro
    public void setTrabajadoresDiscapacitados(int numTrabajadoresDiscapacitados){
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    @Override
    public double mostrarGananciasTotales() {
        return cantidadGanada + (numTrabajadoresDiscapacitados*250);
    }

    @Override
    public int compareTo(Parking o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
