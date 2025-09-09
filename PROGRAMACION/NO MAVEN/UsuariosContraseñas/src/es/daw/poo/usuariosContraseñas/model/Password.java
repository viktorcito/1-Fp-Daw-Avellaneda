/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.usuariosContraseñas.model;

import java.util.Random;

/**
 *
 * @author VSPC
 */
public class Password {
    
    private final int LONGITUD=6;
    private String pwd;
       

    
    private static final char[] especiales={'$','&','*'};
    private static final String pattern= "DAW";
    private static final char[] vocalesUp={'A','E','I','O','U'};

    public Password(String pwd) {
        this.pwd = pwd;
    }

    public Password() {
    }
    
    
    
}
