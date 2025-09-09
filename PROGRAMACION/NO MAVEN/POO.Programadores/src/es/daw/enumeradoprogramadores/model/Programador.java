package es.daw.enumeradoprogramadores.model;

import java.util.Objects;

/**
 *
 * @author melol
 */
public class Programador {
    
    // PENDIENTE COMPLETAR
 
    private String DNI;
    
    private String nombre;
    
    private int edad;
    
    private Lenguajes lenguaje;
    
    private int aniosExperiencia;

    public Programador(String DNI, String nombre, int edad, Lenguajes lenguaje, int aniosExperiencia) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
        this.lenguaje = lenguaje;
        this.aniosExperiencia = aniosExperiencia;
    }

    public Programador(String DNI) {
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Lenguajes getLenguaje() {
        return lenguaje;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.DNI);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programador other = (Programador) obj;
        return Objects.equals(this.DNI, other.DNI);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Programador{");
        sb.append("DNI=").append(DNI);
        sb.append(", nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", lenguaje=").append(lenguaje);
        sb.append(", aniosExperiencia=").append(aniosExperiencia);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
}
