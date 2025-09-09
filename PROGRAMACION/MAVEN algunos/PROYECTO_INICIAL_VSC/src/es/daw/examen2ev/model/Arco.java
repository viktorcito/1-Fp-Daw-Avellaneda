package es.daw.examen2ev.model;

public class Arco extends Arma {
    private final float distancia;

    public Arco(String nombre, int damage, float distancia) {
        super(nombre, damage);
        this.distancia = distancia;
    }
    
    public float getDistancia() {
        return distancia;
    }

}
