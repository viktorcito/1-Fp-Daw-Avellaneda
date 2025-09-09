/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.rrhh.exceptions;

/**
 *
 * @author VSPC
 */
public class FormatoDNIException extends Exception {
    
    private String DNI;

    public FormatoDNIException(String DNI) {
        super("EL DNI"+DNI+"tiene un formato no adecuado");
        this.DNI = DNI;
    }
    
    
    
}
