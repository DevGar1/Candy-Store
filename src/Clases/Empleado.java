package Clases;

public class Empleado {
    private final int codigo;
    private int edad;
    private String nombreEm;
    private String turno;
    private static int codigoEmpleado;


    public Empleado() {
        this.codigo = 100 + (++Empleado.codigoEmpleado);
    }


    public int getCodigo() {
        return codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombreEm() {
        return nombreEm;
    }

    public void setNombreEm(String nombreEm) {
        this.nombreEm = nombreEm;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public static int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public static void setCodigoEmpleado(int codigoEmpleado) {
        Empleado.codigoEmpleado = codigoEmpleado;
    }

    @Override
    public String toString() {
        return "\ncodigo=" + codigo + "\t\tedad=" + edad + "\t\tnombreEm=" + nombreEm + "\t\tturno=" + turno + '\n';
    }
}
