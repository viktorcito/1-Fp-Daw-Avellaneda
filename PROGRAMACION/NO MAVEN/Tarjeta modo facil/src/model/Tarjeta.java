/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author VSPC
 */
public class Tarjeta {
    
    //Atributos
    private static final String ENTIDAD = "DAW_BANK";
    private static final float Limite_Defecto = 1000;
    
    private static int contador;
    private String numero;
    private String titular;
    private LocalDate fechaCaducidad;
    private int CVV;
    private boolean activa;
    private float saldo;
    private float limite;

    public Tarjeta(String numero, String titular, float saldo, float limite) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limite = limite;
        
        this.CVV =generarCVV();
        this.activa =true;
        contador++;
        this.fechaCaducidad = generarFechaCaducidad();
        
    }
    
    
    

    public Tarjeta(String numero, String titular, float saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Tarjeta.contador = contador;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public void desactivarTarjeta(){
        activa=false;
        
    }

    public boolean pagar(float importe){
        
        boolean error;
        if (importe > saldo || importe > limite){
            System.out.println("Error");
            error = true;
        }else{
            saldo -= importe;
            error = false;
        }
        
        return error;
    }
    
    
    
    
    private int generarCVV(){
        Random r = new Random();
        
        return 100+r.nextInt(900);
    }
    
    private LocalDate generarFechaCaducidad(){
        return LocalDate.now().plusYears(1);
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "numero=" + numero + ", titular=" + titular + ", fechaCaducidad=" + fechaCaducidad + ", CVV=" + CVV + ", activa=" + activa + ", saldo=" + saldo + ", limite=" + limite + '}';
    }
    

    
    
    
    
}
