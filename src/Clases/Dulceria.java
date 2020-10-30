package Clases;

public class Dulceria {
    private String direccion;
    private String nombreNegocio;
    private Dulce[] dulces;
    private Empleado[] empleados;
    private Venta[] ventas;
    private static final int EMPLEADOS = 2;
    private static final int DULCES = 10;
    private static final int VENTAS = 50;


    public Dulceria(String direccion, String nombreNegocio) {
        this.direccion = direccion;
        this.nombreNegocio = nombreNegocio;
        this.dulces = new Dulce[DULCES];
        this.empleados = new Empleado[EMPLEADOS];
        this.ventas = new Venta[VENTAS];
    }


    public void agregarDulce(Dulce dulce) {
        boolean bandera = false;
        int i;
        for (i = 0; i < this.dulces.length; i++) {
            if (this.dulces[i] == null) {
                bandera = true;
                break;
            }
        }
        if (bandera) {
            this.dulces[i] = dulce;
        }
    }

    public int getVentas() {
        int total = 0;
        for (Venta venta : this.ventas) {
            if (venta != null)
                total += venta.cantidad * venta.precio;
        }

        return total;
    }

    public Dulce getDulceUnico(int codigo) {
        for (Dulce dulce: this.dulces) {
            if (dulce.getId() == codigo) {
                return dulce;
            }
        }
        return null;
    }

    public int getVentasPorEmpleado(String nombre) {
        int total = 0;
        for (Venta venta : this.ventas) {
            if (venta != null && venta.getNombre().equals(nombre))
                total += venta.cantidad * venta.precio;
        }
        return total;
    }

    public void agregarEmpleado(Empleado empleado) {
        boolean bandera = false;
        int i;
        for (i = 0; i < this.empleados.length; i++) {
            if (this.empleados[i] == null) {
                bandera = true;
                break;
            }
        }
        if (bandera) {
            this.empleados[i] = empleado;
        }
    }

    public void agregarVenta(String nombre, int cantidad, int codigoEmpleado, float precio) {
        Venta venta = new Venta(nombre, cantidad, codigoEmpleado, precio);
        for (int i = 0; i < this.ventas.length; i++) {
            if (this.ventas[i] == null) {
                this.ventas[i] = venta;
            }
        }
    }


    public Empleado[] getEmpleados() {
        return empleados;
    }

    public boolean encontrarEmpleado(int codigo) {
        boolean flag = false;
        for (Empleado empleado : this.getEmpleados()) {
            if (empleado.getCodigo() == codigo) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public Empleado getEmpleadoUnico(int codigo) {
        for (Empleado empleado : this.getEmpleados()) {
            if (empleado.getCodigo() == codigo) {
                return empleado;
            }
        }
        return null;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public static int getEMPLEADOS() {
        return EMPLEADOS;
    }

    public static int getDULCES() {
        return DULCES;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public Dulce[] getDulces() {
        return dulces;
    }

    public void setDulces(Dulce[] dulces) {
        this.dulces = dulces;
    }

    public static int ver_disponibilidad() {
        return DULCES;
    }

    public void setVentas(Venta[] ventas) {
        this.ventas = ventas;
    }

    public static int getVENTAS() {
        return VENTAS;
    }
}
