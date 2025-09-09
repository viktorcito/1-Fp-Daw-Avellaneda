package es.daw.examen2ev.model;


public class Arma {

    private final String nombre;
    private int damage;
    private static int contador = 0;


    public Arma(String nombre, int damage) {
        this.nombre = nombre;
        this.damage = damage;
        contador++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public static int getContador() {
        return contador;
    }
    
}
