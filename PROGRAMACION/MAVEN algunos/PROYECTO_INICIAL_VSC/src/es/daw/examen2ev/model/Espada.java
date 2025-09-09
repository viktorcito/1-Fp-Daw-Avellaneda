package es.daw.examen2ev.model;

public class Espada extends Arma {
    private final boolean afilada;

    public Espada(String nombre, int damage, boolean afilada) {
        super(nombre, damage);
        this.afilada = afilada;
    }

    public boolean isAfilada() {
        return afilada;
    }

    public void cortar() {
        // Método abstracto en subclases
    }
}

