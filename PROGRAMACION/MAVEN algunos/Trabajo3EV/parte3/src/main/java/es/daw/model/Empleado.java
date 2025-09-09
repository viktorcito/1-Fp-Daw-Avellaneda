package es.daw.model;

public class Empleado {
    private int codigo;
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int codigo_departamento;

    public Empleado() {
    }

    public Empleado(String nif, String nombre, String apellido1, String apellido2, int codigo_departamento) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.codigo_departamento = codigo_departamento;
    }

    public Empleado(int codigo, String nif, String nombre, String apellido1, String apellido2, int codigo_departamento) {
        this.codigo = codigo;
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.codigo_departamento = codigo_departamento;
    }

    public Empleado(int codigo, String nombre, String apellido1, String apellido2, int codigo_departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.codigo_departamento = codigo_departamento;
    }

    public Empleado(String nombre, String apellido1, String apellido2, int codigo_departamento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.codigo_departamento = codigo_departamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", codigo_departamento=" + codigo_departamento +
                '}';
    }
}

