/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.astro.model;

/**
 *
 * @author VSPC
 */
public class Astro {
    
    private String nombre;
    private double radio;
    private double rotrEje;
    private double masa;
    private double temMedia;
    private double gravedad;

    public Astro(String nombre, double radio, double rotrEje, double masa, double temMedia, double gravedad) {
        this.nombre = nombre;
        this.radio = radio;
        this.rotrEje = rotrEje;
        this.masa = masa;
        this.temMedia = temMedia;
        this.gravedad = gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRotrEje() {
        return rotrEje;
    }

    public void setRotrEje(double rotrEje) {
        this.rotrEje = rotrEje;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getTemMedia() {
        return temMedia;
    }

    public void setTemMedia(double temMedia) {
        this.temMedia = temMedia;
    }

    public double getGravedad() {
        return gravedad;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Astro{");
        sb.append("nombre=").append(nombre);
        sb.append(", radio=").append(radio);
        sb.append(", rotrEje=").append(rotrEje);
        sb.append(", masa=").append(masa);
        sb.append(", temMedia=").append(temMedia);
        sb.append(", gravedad=").append(gravedad);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
