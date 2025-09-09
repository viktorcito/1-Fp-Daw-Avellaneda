package es.daw.model;

public class Departamento {
    private int codigo;
    private String nombre;
    private String ubicacion;
    private double presupuesto;
    private double gastos;

    public Departamento() {
    }

    public Departamento(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Departamento(int codigo, String nombre, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Departamento(String nombre, double presupuesto, double gastos) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.gastos = gastos;
    }

    public Departamento(int codigo, String nombre, double presupuesto, double gastos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.gastos = gastos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", presupuesto=" + presupuesto +
                ", gastos=" + gastos +
                '}';
    }
}
