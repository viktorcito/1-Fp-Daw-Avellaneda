/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parking.model;

/**
 *
 * @author VSPC
 */
public class Parking {
    private String nombre;
    private int plazasCoches;
    private int plazasMotos;
    private int plazasFurgonetas;
    private int plazasCamiones;
    private int plazasCochesOcupadas;
    private int plazasMotosOcupadas;
    private int plazasFurgonetasOcupadas; //AÑADIENDO NUEVAS VARIABLES FASE3
    private int plazasCamionesOcupadas;
    //Aqui tengo duda de si seria mejor poner los enumerados en el contructor o llamarlo en la funcion directamente
    
    //CONSTRUCTOR
    public Parking(String nombre, int plazasCoches, int plazasMotos, int plazasFurgonetas, int plazasCamiones) {
        this.nombre = nombre;
        this.plazasCoches = plazasCoches;
        this.plazasMotos = plazasMotos;
        this.plazasFurgonetas = plazasFurgonetas;
        this.plazasCamiones = plazasCamiones;
        this.plazasCochesOcupadas = 0;
        this.plazasMotosOcupadas = 0;
        this.plazasFurgonetasOcupadas = 0; //AÑADIENDO NUEVAS VARIABLES FASE3
        this.plazasCamionesOcupadas = 0;
    }

    //Pongo todos los gett y sett 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlazasCoches() {
        return plazasCoches;
    }

    public void setPlazasCoches(int plazasCoches) {
        this.plazasCoches = plazasCoches;
    }

    public int getPlazasMotos() {
        return plazasMotos;
    }

    public void setPlazasMotos(int plazasMotos) {
        this.plazasMotos = plazasMotos;
    }

    public int getPlazasFurgonetas() {
        return plazasFurgonetas;
    }

    public void setPlazasFurgonetas(int plazasFurgonetas) {
        this.plazasFurgonetas = plazasFurgonetas;
    }

    public int getPlazasCamiones() {
        return plazasCamiones;
    }

    public void setPlazasCamiones(int plazasCamiones) {
        this.plazasCamiones = plazasCamiones;
    }
    
     public int getPlazasTipoVehiculo(TipoVehiculo tipoVehiculo) {
        switch (tipoVehiculo) {
            case COCHES:
                return plazasCoches;
            case MOTOS:
                return plazasMotos;
            case FURGONETAS:
                return plazasFurgonetas;
            case CAMIONES:
                return plazasCamiones;
            default:
                return 0;
        }
    }
     
     public void setPlazasTipoVehiculo(TipoVehiculo tipoVehiculo, int cantidad) {
        switch (tipoVehiculo) {
            case COCHES:
                plazasCoches = cantidad;
                break;
            case MOTOS:
                plazasMotos = cantidad;
                break;
            case FURGONETAS:
                plazasFurgonetas = cantidad;
                break;
            case CAMIONES:
                plazasCamiones = cantidad;
                break;
        }
    }
    
    
     //FASE 3 DEL PROGRAMA
     
     public boolean entradaVehiculo(String tipoVehiculo) {
    switch (tipoVehiculo.toLowerCase()) {
        case "coche":
            if (plazasCochesOcupadas < plazasCoches) {
                plazasCochesOcupadas++;
                return true;
            }
            break;
        case "moto":
            if (plazasMotosOcupadas < plazasMotos) {
                plazasMotosOcupadas++;
                return true;
            }
            break;
        case "furgoneta":
            if (plazasFurgonetasOcupadas < plazasFurgonetas) {
                plazasFurgonetasOcupadas++;
                return true;
            }
            break;
        case "camion":
            if (plazasCamionesOcupadas < plazasCamiones) {
                plazasCamionesOcupadas++;
                return true;
            }
            break;
        default:
            return false;
    }
    return false;
}

public boolean salidaVehiculo(String tipoVehiculo) {
    switch (tipoVehiculo.toLowerCase()) {
        case "coche":
            if (plazasCochesOcupadas > 0) {
                plazasCochesOcupadas--;
                return true;
            }
            break;
        case "moto":
            if (plazasMotosOcupadas > 0) {
                plazasMotosOcupadas--;
                return true;
            }
            break;
        case "furgoneta":
            if (plazasFurgonetasOcupadas > 0) {
                plazasFurgonetasOcupadas--;
                return true;
            }
            break;
        case "camion":
            if (plazasCamionesOcupadas > 0) {
                plazasCamionesOcupadas--;
                return true;
            }
            break;
        default:
            return false;
    }
    return false;
}

     
     
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parking{");
        sb.append("nombre=").append(nombre);
        sb.append(", plazasCoches=").append(plazasCoches);
        sb.append(", plazasMotos=").append(plazasMotos);
        sb.append(", plazasFurgonetas=").append(plazasFurgonetas);
        sb.append(", plazasCamiones=").append(plazasCamiones);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
