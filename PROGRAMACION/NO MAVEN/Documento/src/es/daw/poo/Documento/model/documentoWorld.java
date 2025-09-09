/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.Documento.model;

/**
 *
 * @author VSPC
 */
public class documentoWorld extends Documento{

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public documentoWorld(String version, String titulo) {
        super(titulo);
        this.version = version;
    }

    
   
    
    
    
    
    
    
    @Override
    public void validar() {
        System.out.println("el documento word"+getTitulo());
    }
    
    
    
    
}
