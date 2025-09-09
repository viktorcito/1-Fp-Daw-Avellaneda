package es.daw.parkingalcala.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author melola
 */
public abstract class Parking implements Profitable {
    
    
    private int id, capacidad;
    public static int contador = 0;
    private String nombre;
    private String direccion;
    protected double cantidadGanada;
    private ArrayList<Coche> coches;
    private Seguro seguro;
    private final int TARIFA=5;
    
    
    private static int capacidadTotal = 0;
    private static int ocupacionTotal = 0;

    public Parking(int capacidad, String nombre, String direccion) {
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.direccion = direccion;
        coches = new ArrayList<>();
        
        contador++;
        
        this.id = contador;
        
        capacidadTotal += capacidad;
        
        this.seguro = new Seguro(0,"No asegurado",LocalDate.now());
    }

    public int getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public static int getContador() {
        return contador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getCantidadGanada() {
        return cantidadGanada;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public int getTARIFA() {
        return TARIFA;
    }

    public static int getTotalPlazas() {
        return capacidadTotal;
    }

    public static int getTotalNumCoches() {
        return ocupacionTotal;
    }

    
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    

    public void setSeguro(Seguro seguro) {
        Seguro miSeg = new Seguro(seguro.getNumPoliza(),seguro.getNomAseguradora(),seguro.getFechaFinSeguro());
        this.seguro = seguro;
    }

    
    
    private int getPorcentajeOcupacion(){
        float porcentaje = ((float)coches.size()/ capacidad)*100;
        
        return (int)porcentaje;
    }
    
    private int getPorcentajeOcupacionTotal(){
        float rdo = ((float)ocupacionTotal/capacidadTotal)*100;
        return (int)rdo;
    }

    
    
    public void addCoche(Coche c)throws ParkingsCompletoExcepcion{
        
    }
    
    
    
    
}
