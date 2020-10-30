package Clases;

public class Venta {
    private String nombre;
    public int cantidad;
    private int codigoEmpleado;
    public float precio;

    public Venta(String nombre, int cantidad, int codigoEmpleado, float precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.codigoEmpleado =  codigoEmpleado;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
