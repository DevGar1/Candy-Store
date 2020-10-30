import Clases.Dulce;
import Clases.Dulceria;
import Clases.Empleado;
import Clases.Venta;

import java.util.Arrays;
import java.util.Scanner;

public class Tienda {
    public static void iniciar(Dulceria dulceria) {
        for (int i = 0; i < 2; i++) {
            Empleado empleado = new Empleado();
            empleado.setEdad((int) Math.floor(Math.random() * (60 - 18 + 1) + 18));
            empleado.setNombreEm("empleado " + i + 1);
            empleado.setTurno("Matutino");
            dulceria.agregarEmpleado(empleado);
        }

        for (int i = 0; i < 9; i++) {
            Dulce dulce = new Dulce();
            dulce.setCantidad_disponible((int) Math.floor(Math.random() * (10 - 1 + 1) + 1));
            dulce.setNombreProducto("Dulce " + i + 1);
            dulce.setPrecio((int) Math.floor(Math.random() * (60 - 18 + 1) + 18));
            dulceria.agregarDulce(dulce);
        }
    }

    public static void empleado(Dulceria dulceria) {
        int opc = 0;
        Scanner console = new Scanner(System.in);

        System.out.println("Ingresa tu código de empleado para acceder: ");
        int code = console.nextInt();
        console.next();
        Empleado empleado;
        if (dulceria.encontrarEmpleado(code)) {
            empleado = dulceria.getEmpleadoUnico(code);
            while (opc != 4) {
                System.out.println("1.Ver Información Personal\n");
                System.out.println("2.Ver Información de producto\n");
                System.out.println("3.Vender\n");
                System.out.println("4. Salir\n");
                opc = console.nextInt();

                switch (opc) {
                    case 1: {
                        System.out.println(empleado);
                        break;
                    }
                    case 2: {
                        int idProducto;
                        boolean flag = false;
                        System.out.println("Ingresa el número del producto [Si quieres consultarlos, presiona cero]: ");
                        idProducto = console.nextInt();
                        Dulce[] dulces = dulceria.getDulces();

                        if (idProducto == 0) {
                            for (Dulce dulce : dulces) {
                                if (dulce != null)
                                    System.out.println(dulce + "\n");
                            }
                            System.out.println(" Ingresa número: ");
                            idProducto = console.nextInt();
                        }
                        for (Dulce dulce : dulces) {
                            if (dulce.getId() == idProducto) {
                                System.out.println("\t\t\t\t Aqui Está tu producto");
                                System.out.println(dulce);
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            System.out.println("No existe ese dulce");
                        }
                        break;
                    }
                    case 3: {
                        int masDulces = 1;
                        int cantidad = 1;
                        while (masDulces != 0) {
                            System.out.println("Ingresa el código del dulce\n");
                            masDulces = console.nextInt();
                            Dulce dulce = dulceria.getDulceUnico(masDulces);
                            if (dulce != null) {
                                System.out.println("Cuantos quieres?\n");
                                cantidad = console.nextInt();
                                dulceria.agregarVenta(dulce.getNombreProducto(), cantidad, empleado.getCodigo(), dulce.getPrecio());
                            }
                            System.out.println("Preciona 0 para salir o cualquier otra tecla para agregar productos\n");
                            masDulces = console.nextInt();
                        }
                        break;
                    }
                }
            }
        } else {
            empleado = null;
            System.out.println("No se encuentra tu empleado\n\n");
        }

    }

    public static void admin(Dulceria dulceria) {
        int opc = 0;
        Scanner console = new Scanner(System.in);

        while (opc != 6) {
            System.out.println("\t\t\t\t--Menu--\n\n");
            System.out.println("1.Ver Información de empleado\n");
            System.out.println("2.Ver Información de producto\n");
            System.out.println("3.Ver inventario\n");
            System.out.println("4.Consultar ganancias\n");
            System.out.println("5.Consultar ganancias por empleado\n");
            System.out.println("6. Salir\n");
            opc = console.nextInt();

            switch (opc) {
                case 1: {
                    int idEmpleado;
                    boolean flag = false;
                    System.out.println("Ingresar numero de empleado [Si quieres consultarlos, presiona cero]: ");
                    idEmpleado = console.nextInt();
                    Empleado[] empleados = dulceria.getEmpleados();

                    if (idEmpleado == 0) {
                        for (Empleado empleado : empleados) {
                            if (empleado != null)
                                System.out.println(empleado + "\n");
                        }
                        System.out.println(" Ingresa número: ");
                        idEmpleado = console.nextInt();
                    }
                    for (Empleado empleado : empleados) {
                        if (empleado.getCodigo() == idEmpleado) {
                            System.out.println("\t\t\t\t Aqui Está tu empleado");
                            System.out.println(empleado);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("No existe ese empleado");
                    }
                    break;
                }
                case 2: {
                    int idProducto;
                    boolean flag = false;
                    System.out.println("Ingresa el número del producto [Si quieres consultarlos, presiona cero]: ");
                    idProducto = console.nextInt();
                    Dulce[] dulces = dulceria.getDulces();

                    if (idProducto == 0) {
                        for (Dulce dulce : dulces) {
                            if (dulce != null)
                                System.out.println(dulce + "\n");
                        }
                        System.out.println(" Ingresa número: ");
                        idProducto = console.nextInt();
                    }
                    for (Dulce dulce : dulces) {
                        if (dulce.getId() == idProducto) {
                            System.out.println("\t\t\t\t Aqui Está tu producto");
                            System.out.println(dulce);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("No existe ese dulce");
                    }
                    break;
                }
                case 3: {
                    Dulce[] dulces = dulceria.getDulces();
                    if (dulces.length < 1) {
                        System.out.println("No tienes dulces");
                    }
                    for (Dulce dulce : dulces) {
                        System.out.println(dulce);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Lo vendido ha sido: \n");
                    System.out.println("$" + dulceria.getVentas());
                    break;
                }
                case 5: {
                    Empleado[] empleados = dulceria.getEmpleados();
                    System.out.println(Arrays.toString(empleados));
                    boolean flag = false;
                    String nombreEmpleado = null;
                    int code;
                    System.out.println("\n\n Ingresa código de usuario");
                    code = console.nextInt();
                    for (Empleado empleado : empleados) {
                        if (empleado.getCodigo() == code) {
                            nombreEmpleado = empleado.getNombreEm();
                            flag = true;
                        }
                    }
                    if (flag) {
                        System.out.println("Lo vendido por " + nombreEmpleado);
                        System.out.println("\n$" + dulceria.getVentasPorEmpleado(nombreEmpleado));
                    }

                    break;
                }
                default:
                    System.out.println(" Número Incorrecto");
            }
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Dulceria dulceria = new Dulceria("Av siempre viva", "Dulceria de Mou");
        Tienda.iniciar(dulceria);
        int opc = 0;
        while (opc != 3) {
            System.out.println("---------- Bienvenidos a la dulceria " + dulceria.getNombreNegocio() + "----------\n\n");
            System.out.println("-Porfavor indiquenos que tipo de ususario es: \n");
            System.out.println("1.Administrador\n2.Empleado\n3.Usted quiere salir\n");
            opc = console.nextInt();
            switch (opc) {
                case 1: {
                    System.out.println("Vamos a ingresar como Administrador...\n\n");
                    Tienda.admin(dulceria);
                    break;
                }
                case 2: {
                    System.out.println("Vamos a ingresar como empleado...\n");
                    Tienda.empleado(dulceria);
                }
                case 3: {
                    System.out.println("Gracias por confiar en nosotros");
                    break;
                }
            }
        }

    }
}