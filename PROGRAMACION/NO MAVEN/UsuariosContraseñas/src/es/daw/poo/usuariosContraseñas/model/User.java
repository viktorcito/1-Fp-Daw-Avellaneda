/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.usuariosContraseñas.model;

/**
 *
 * @author VSPC
 */
class User {
    private String login;
    private Password password;

    public User(String login, Password pwd) {
        this.login = login;
        this.password = pwd;
    }

    public User(String login) {
        this.login = login;
        
        
        
    }

    public String getLogin() {
        return login;
    }

  
    public Password getPassword() {
        return password;
    }

   
    
    @Override
    public String toString() {
        return "User{" + "login=" + login + ", password=" + password + '}';
    }


    
    
    
}
