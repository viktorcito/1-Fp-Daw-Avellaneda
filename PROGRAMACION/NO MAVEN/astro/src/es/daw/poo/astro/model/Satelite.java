/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.astro.model;

/**
 *
 * @author VSPC
 */
public class Satelite extends Astro {

    private double distPlaneta;
    private double orbPlaneta;
    private Planeta planeta;

    public Satelite(String nombre, double distPlaneta, double orbPlaneta, double radio, double rotrEje, double masa, double temMedia, double gravedad, Planeta planeta) {
        super(nombre, radio, rotrEje, masa, temMedia, gravedad);
        this.distPlaneta = distPlaneta;
        this.orbPlaneta = orbPlaneta;
        this.planeta = planeta;
        if (planeta != null) {
            planeta.addSatelite(this);
        }
    }

    public double getDistPlaneta() {
        return distPlaneta;
    }

    public void setDistPlaneta(double distPlaneta) {
        this.distPlaneta = distPlaneta;
    }

    public double getOrbPlaneta() {
        return orbPlaneta;
    }

    public void setOrbPlaneta(double orbPlaneta) {
        this.orbPlaneta = orbPlaneta;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n***" + getClass().getSimpleName() + "" + super.getNombre() + "****");
        sb.append(super.toString());
        sb.append("distPlaneta=").append(distPlaneta);
        sb.append(", orbPlaneta=").append(orbPlaneta);
        sb.append(", planeta=").append(planeta.getNombre());
        return sb.toString();
    }

}
