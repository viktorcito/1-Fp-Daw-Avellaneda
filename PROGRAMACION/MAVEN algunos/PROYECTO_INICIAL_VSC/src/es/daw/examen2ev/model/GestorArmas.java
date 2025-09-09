package es.daw.examen2ev.model;

import java.util.ArrayList;
import java.util.List;

public class GestorArmas {
    private final List<Arma> armas;

    public GestorArmas(List<Arma> armas) {
        this.armas = armas;
    }

    public void addArma(Arma arma) {
        armas.add(arma);
    }

    public void removeLastArma() {
        if (!armas.isEmpty()) {
            armas.remove(armas.size() - 1);
        }
    }

    @Override
    public String toString() {


        

        return "GestorArmas [armas=" + armas + "]";
    }

    
}
