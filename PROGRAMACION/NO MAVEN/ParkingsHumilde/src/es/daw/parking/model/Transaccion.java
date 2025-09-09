/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parking.model;

import java.time.LocalDateTime;

/**
 *
 * @author VSPC
 */
public class Transaccion {

    private String tipoTransaccion;
    private String tipoVehiculo;
    private LocalDateTime fechaHora;
    private String nombreParking;

    public Transaccion(String tipoTransaccion, String tipoVehiculo, LocalDateTime fechaHora, String nombreParking) {
        this.tipoTransaccion = tipoTransaccion;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaHora = fechaHora;
        this.nombreParking = nombreParking;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombreParking() {
        return nombreParking;
    }

    public void setNombreParking(String nombreParking) {
        this.nombreParking = nombreParking;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion{");
        sb.append("tipoTransaccion=").append(tipoTransaccion);
        sb.append(", tipoVehiculo=").append(tipoVehiculo);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", nombreParking=").append(nombreParking);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
