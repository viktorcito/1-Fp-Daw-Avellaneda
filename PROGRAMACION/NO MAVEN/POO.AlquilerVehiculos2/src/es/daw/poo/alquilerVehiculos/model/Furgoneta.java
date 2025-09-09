/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.alquilerVehiculos.model;

/**
 *
 * @author VSPC
 */
public class Furgoneta extends Vehiculo{
    private final int EXTRA =20;
    private float PMA;

    public Furgoneta(float PMA, String MATRICULA) {
        super(MATRICULA);
        this.PMA = PMA;
    }

    public float getPMA() {
        return PMA;
    }

    public void setPMA(float PMA) {
        this.PMA = PMA;
    }

    @Override
    public float getPrecioAlquiler() {
        return super.getPrecioAlquiler()+(EXTRA*PMA);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", PMA=").append(PMA);
        if (estaAlquilado()){
        sb.append("Precio de alquiler: ").append(getPrecioAlquiler()).append("euros");
        return sb.toString();
    }
    return sb.toString();
    }
    
}
