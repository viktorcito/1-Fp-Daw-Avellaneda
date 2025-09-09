/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.Documento.model;

/**
 *
 * @author VSPC
 */
public class documentosPdf extends Documento {

    private boolean protegido;
    
    
    
    public boolean isProtegido(){
        return protegido;
    }
    

    public documentosPdf(boolean protegido, String titulo) {
        super(titulo);
        this.protegido = protegido;
    }
         
    public void setProtegido(boolean protegido) {
        this.protegido = protegido;
    }

    @Override
    public void validar() {
        
        System.out.println("el documento pdf con titulo"+getTitulo()+"ha sido validado");
        
    }
    
    
    
    
    
    
  
}
