/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.astro.model;

import java.util.ArrayList;

/**
 *
 * @author VSPC
 */
public class Planeta extends Astro {
    
    private double distSol;
    private double orbSol;
    private ArrayList<Satelite> satelites;

    public Planeta(String nombre, double distSol, double orbSol, double radio, double rotrEje, double masa, double temMedia, double gravedad) {
        super(nombre, radio, rotrEje, masa, temMedia, gravedad);
        this.distSol = distSol;
        this.orbSol = orbSol;
        this.satelites = satelites;
        
        this.satelites = new ArrayList<>();
    }
    
   public void addSatelite(Satelite s){
       if(s!=null)
        satelites.add(s);
   }
    

    public double getDistSol() {
        return distSol;
    }

    public void setDistSol(double distSol) {
        this.distSol = distSol;
    }

    public double getOrbSol() {
        return orbSol;
    }

    public void setOrbSol(double orbSol) {
        this.orbSol = orbSol;
    }

    public void setSatelites(ArrayList<Satelite> satelites) {
        this.satelites = satelites;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n*** "+getClass().getSimpleName()+" "+super.getNombre()+" ***");
        sb.append(super.toString());
        sb.append("distSol=").append(distSol);
        sb.append(", orbSol=").append(orbSol);
        sb.append('}');
        
        
        
        return sb.toString();
    }
    
    
    
    
    
}
