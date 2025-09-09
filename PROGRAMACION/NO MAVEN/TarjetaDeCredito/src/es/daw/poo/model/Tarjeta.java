/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.model;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author VSPC
 */
public class Tarjeta {

    //ATRIBUTOS
    private static final String ENTIDAD = "DAW_BANK";
    private static final float LIMITE_DEFECTO = 1000;

    //comun para todas las tarjetas y vamos a incrementarlo
    private static int contador;
    private String numero;
    private String titular;
    private LocalDate fechaCaducidad;
    private int CVV; //generamos aleatoriamente un numero de 100 a 999
    private boolean activa; // en el momento de  dar de alta la tarjeta queda activada
    private float saldo;
    private float limite; //limite diario

    //CONSTRUCTORES 
    public Tarjeta(String numero, String titular, float saldo) {
        this(numero, titular, saldo, LIMITE_DEFECTO);
    }

    public Tarjeta(String numero, String titular, float saldo, float limite) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limite = limite;

        //generar aleatoriamente un CVV desde 100 a 999
        this.CVV = generarCVV();
        // activar la tarjeta
        this.activa = true;
        // incrementar el contador de tarjetas emitidas
        contador++;
        // automaticamente la fecha de caducidad sera 1 año despues de la fecha de alta
        this.fechaCaducidad = generarFechaCaducidad();
    }

    public static String getENTIDAD() {
        return ENTIDAD;
    }

    public static float getLIMITE_DEFECTO() {
        return LIMITE_DEFECTO;
    }

    public static int getContador() {
        return contador;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getCVV() {
        return CVV;
    }

    public boolean isActiva() {
        return activa;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getLimite() {
        return limite;
    }

    //setters.. 
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    //METODOS PROPIOS
    //Metodo para realizar el pago
    
    public void desactivarTarjeta(){
        activa = false;
        
    }
    
    public boolean pagar(float importe){
        boolean error;
        if (importe > saldo || importe > limite){
            System.out.println("Error");
            error = true;
        }else{
            saldo -= importe;
            System.out.println("nuevo salgo"+saldo);
            error = false;
        }
        return error;
    }


    //Metodo para generar un numero aleatorio entre 100 y 999
    private int generarCVV() {
        Random r = new Random();

        return 100 + r.nextInt(900);
    }

    //Metodo que suma un año a la fecha actual
    private LocalDate generarFechaCaducidad() {
        return LocalDate.now().plusYears(1);
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "numero=" + numero + ", titular=" + titular + ", fechaCaducidad=" + fechaCaducidad + ", activa=" + activa + ", saldo=" + saldo + ", limite=" + limite + '}';
    }


    
}
