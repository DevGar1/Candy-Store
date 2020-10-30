package Clases;

public class Dulce {
    private final int id;
    private int cantidad_disponible;
    private String nombreProducto;
    private float precio;
    private static int numId;


    public Dulce() {
        this.id = ++numId;
    }

    public int getId() {
        return id;
    }

    public boolean ver_disponibilidad() {
        int disponibilidad = this.getCantidad_disponible();
        if (disponibilidad > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public static int getNumId() {
        return numId;
    }

    public static void setNumId(int numId) {
        Dulce.numId = numId;
    }

    @Override
    public String toString() {
        return "\nid=" + id + "\t\tcantidad_disponible=" + cantidad_disponible + "\t\tnombreProducto=" + nombreProducto + "\t\tprecio=" + precio +
                "\n\n";
    }
}
