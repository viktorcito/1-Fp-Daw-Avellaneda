
package es.daw.poo2.rrhh.model;

import es.daw.poo2.rrhh.exceptions.FormatoDNIException;
import static es.daw.poo2.rrhh.util.Utilidades.checkExpresionRegular;
import java.time.LocalDate;

/**
 *
 * @author melol
 */
public abstract class Empleado implements Comparable<Empleado> {
    
    public static int contador;
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String DNI;
    private String domicilioCompleto;
    private int movil;
    private String email;
    private LocalDate fechaInicioContrato;
    private Categorias categoria;

    public Empleado(String nombre, String apellido1, String apellido2, String DNI, String domicilioCompleto, int movil, String email, Categorias categoria) throws FormatoDNIException {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        checkDNI(DNI);
        this.domicilioCompleto = domicilioCompleto;
        this.movil = movil;
        this.email = email;
        this.fechaInicioContrato = LocalDate.now();
        this.categoria = categoria;
        
        contador++;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Empleado.contador = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDomicilioCompleto() {
        return domicilioCompleto;
    }

    public void setDomicilioCompleto(String domicilioCompleto) {
        this.domicilioCompleto = domicilioCompleto;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    
    private void checkDNI(String dni) throws FormatoDNIException {
        if(!checkExpresionRegular("[0-9]{8}[A-Z]{1}",dni)){
            throw new FormatoDNIException(dni);
        }else
            this.DNI = dni;
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido1=").append(apellido1);
        sb.append(", apellido2=").append(apellido2);
        sb.append(", DNI=").append(DNI);
        sb.append(", domicilioCompleto=").append(domicilioCompleto);
        sb.append(", movil=").append(movil);
        sb.append(", email=").append(email);
        sb.append(", fechaInicioContrato=").append(fechaInicioContrato);
        sb.append(", categoria=").append(categoria);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    public abstract int calcularFactorPagaExtra();

    @Override
    public int compareTo(Empleado otro){
        return DNI.compareTo(otro.DNI);
    }
    
    
    
    
}
