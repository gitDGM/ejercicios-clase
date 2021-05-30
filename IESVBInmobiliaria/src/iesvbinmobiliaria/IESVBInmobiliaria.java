/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria;

import Conexion.Conexion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class IESVBInmobiliaria {

    private final Conexion db;
    private final static String RUTA = "src/XXXX/";

    public IESVBInmobiliaria(String bbdd) {
        db = new Conexion(bbdd);
        db.conectar();
    }

    // INICIO GESTION
    
    // Método para insertar clientes en la base de datos
    public void insertarCliente(String nombre, String apellidos, String dni, String telefono) {
        String query = "SELECT * FROM clientes WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("INSERT INTO clientes VALUES (NULL, '" + nombre + "', '" + apellidos + "', '" + dni + "', '" + telefono + "' );");
        } else {
            System.err.println("ERROR: No es posible añadir este cliente, el DNI ya existe.");
        }
    }

    // Método para eliminar clientes en la base de datos
    public void eliminarCliente(String dni) {
        String query = "SELECT * FROM clientes WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            db.ejecutarModificar("DELETE FROM clientes WHERE dni = '" + dni + "';");
        } else {
            System.err.println("ERROR: No existe ningún registro con ese DNI.");
        }
    }

    // Método para insertar empleados en la base de datos
    public void insertarEmpleado(String nombre, String apellidos, String dni, String telefono) {
        String query = "SELECT * FROM empleados WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("INSERT INTO empleados VALUES (NULL, '" + nombre + "', '" + apellidos + "', '" + dni + "', '" + telefono + "' );");
        } else {
            System.err.println("ERROR: No es posible añadir este empleado, ya existe un empleado con ese DNI.");
        }
    }

    // Método para eliminar empleados en la base de datos
    public void eliminarEmpleado(String dni) {
        String query = "SELECT * FROM empleados WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            db.ejecutarModificar("DELETE FROM empleados WHERE dni = '" + dni + "';");
        } else {
            System.err.println("ERROR: No existe ningún registro con ese DNI.");
        }
    }

    // Método para insertar vivienda en la base de datos
    public void insertarVivienda(String referenciaCatastral, String direccion, String localidad, String pais, double precio, int numPlantas, String dniPropietario) {
        String queryVivienda = "SELECT * FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';";
        String queryPropietario = "SELECT * FROM clientes WHERE dni = '" + dniPropietario + "';";

        ArrayList<String> dataVivienda = db.ejecutarObtener(queryVivienda);
        ArrayList<String> dataPropietario = db.ejecutarObtener(queryPropietario);

        if (dataVivienda.isEmpty() && !dataPropietario.isEmpty()) {
            db.ejecutarModificar("INSERT INTO viviendas VALUES (NULL, '" + referenciaCatastral + "', '" + direccion + "', '" + localidad + "', '" + pais + "', " + precio + ", " + numPlantas + ", (SELECT idCliente FROM clientes WHERE dni = '" + dniPropietario + "'));");
        } else {
            System.err.println("ERROR: No es posible añadir esta vivienda, ya existe una vivienda con esa referencia catastral o no existe ningún cliente con ese DNI.");
        }
    }

    // Método para eliminar vivienda en la base de datos
    public void eliminarVivienda(String referenciaCatastral) {
        String query = "SELECT * FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            db.ejecutarModificar("DELETE FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';");
        } else {
            System.err.println("ERROR: No existe ningún registro con esa referencia catastral.");
        }
    }

    // Método para insertar ventas en la base de datos
    public void insertarVenta(String dniComprador, String dniEmpleado, String referenciaCatastral) {
        String queryComprador = "SELECT idCliente FROM clientes WHERE dni = '" + dniComprador + "';";
        String queryEmpleado = "SELECT idEmpleado FROM empleados WHERE dni = '" + dniEmpleado + "';";
        String queryVivienda = "SELECT idVivienda FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';";

        ArrayList<String> dataComprador = db.ejecutarObtener(queryComprador);
        ArrayList<String> dataEmpleado = db.ejecutarObtener(queryEmpleado);
        ArrayList<String> dataVivienda = db.ejecutarObtener(queryVivienda);

        if (!dataComprador.isEmpty() && !dataEmpleado.isEmpty() && !dataVivienda.isEmpty()) {
            int idComprador = Integer.parseInt(dataComprador.get(0));
            int idEmpleado = Integer.parseInt(dataEmpleado.get(0));
            int idVivienda = Integer.parseInt(dataVivienda.get(0));
            db.ejecutarModificar("INSERT INTO ventas VALUES (NULL, " + idComprador + ", " + idEmpleado + ", " + idVivienda + ");");
        } else {
            System.err.println("ERROR: No es posible añadir este cliente, el DNI ya existe.");
        }
    }
    // FIN GESTION

    // INICIO CONSULTAS
    
    // Método para mostrar los clientes de la base de datos
    public void listarClientes() {
        String query = "SELECT * FROM clientes;";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-15s%-20s%-11s%-11s\n", "ID Cliente", "Nombre", "Apellidos", "DNI", "Teléfono");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-15s%-20s%-11s%-11s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no hay registros de clientes.");
        }
    }

    // Método para mostrar un cliente de la base de datos pasando el dni.
    public void listarCliente(String dni) {
        String query = "SELECT * FROM clientes WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-15s%-20s%-11s%-11s\n", "ID Cliente", "Nombre", "Apellidos", "DNI", "Teléfono");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-15s%-20s%-11s%-11s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no existe ese cliente.");
        }
    }

    // Método para mostrar los empleados de la base de datos
    public void listarEmpleados() {
        String query = "SELECT * FROM empleados;";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-15s%-20s%-11s%-11s\n", "ID Empleado", "Nombre", "Apellidos", "DNI", "Teléfono");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-15s%-20s%-11s%-11s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no hay registros de empleados.");
        }
    }

    // Método para mostrar los empleados de la base de datos pasando el dni.
    public void listarEmpleado(String dni) {
        String query = "SELECT * FROM empleados WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-15s%-20s%-11s%-11s\n", "ID Empleado", "Nombre", "Apellidos", "DNI", "Teléfono");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-15s%-20s%-11s%-11s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no existe ese empleado.");
        }
    }

    // Método para mostrar las viviendas de la base de datos
    public void listarViviendas() {
        String query = "SELECT idVivienda, referencia_catastral, direccion, localidad, pais, precio, numPlantas, clientes.dni FROM viviendas INNER JOIN clientes ON viviendas.idPropietario = clientes.idCliente;";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-30s\n", "ID Vivienda", "Referencia Catastral", "Dirección", "Localidad", "Pais", "Precio", "Número de plantas", "DNI del Propietario");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-30s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4], dataRegistro[5], dataRegistro[6], dataRegistro[7]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no hay registros de viviendas.");
        }
    }

    // Método para mostrar las viviendas de la base de datos pasando la referencia catastral.
    public void listarVivienda(String referenciaCatastral) {
        String query = "SELECT idVivienda, referencia_catastral, direccion, localidad, pais, precio, numPlantas, clientes.dni FROM viviendas INNER JOIN clientes ON viviendas.idPropietario = clientes.idCliente WHERE referencia_catastral = '" + referenciaCatastral + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-30s\n", "ID Vivienda", "Referencia Catastral", "Dirección", "Localidad", "Pais", "Precio", "Número de plantas", "DNI del Propietario");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-30s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4], dataRegistro[5], dataRegistro[6], dataRegistro[7]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no existe ninguna vivienda con esa referencia catastral.");
        }
    }

    // Método para mostrar las viviendas de la base de datos pasando el dni del propietario
    public void listarViviendasPropietario(String dni) {
        String query = "SELECT idVivienda, referencia_catastral, direccion, localidad, pais, precio, numPlantas, clientes.dni FROM viviendas INNER JOIN clientes ON viviendas.idPropietario = clientes.idCliente WHERE idPropietario = (SELECT idCliente FROM clientes WHERE dni = '" + dni + "');";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-30s\n", "ID Vivienda", "Referencia Catastral", "Dirección", "Localidad", "Pais", "Precio", "Número de plantas", "DNI del Propietario");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-30s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4], dataRegistro[5], dataRegistro[6], dataRegistro[7]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no tenemos ninguna vivienda vinculada a ese propietario.");
        }
    }

    // Método para mostrar los movimientos de la base de datos
    public void listarMovimientos() {
        String query = "SELECT idVenta, clientes.dni, empleados.dni, viviendas.referencia_catastral FROM ventas INNER JOIN clientes ON ventas.idComprador = clientes.idCliente INNER JOIN empleados ON ventas.idEmpleado = empleados.idEmpleado INNER JOIN viviendas ON ventas.idVivienda = viviendas.idVivienda;";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-30s%-20s%-20s\n", "ID Movimiento", "DNI Comprador", "DNI Empleado", "Referencia Catastral");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-30s%-20s%-20s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no tenemos ninguna vivienda vinculada a ese propietario.");
        }
    }
    // FIN CONSULTAS

    // INICIO INFORMES
    
    // Método para generar informe de los movimientos
    public void generarInformeMovimientos() {
        File fichero = new File(RUTA + "informe_movimientos.txt");
        FileWriter filewriter = null;
        PrintWriter escritor = null;

        try {
            ArrayList<String> data = db.ejecutarObtener("SELECT idVenta, clientes.dni, empleados.dni, viviendas.referencia_catastral FROM ventas INNER JOIN clientes ON ventas.idComprador = clientes.idCliente INNER JOIN empleados ON ventas.idEmpleado = empleados.idEmpleado INNER JOIN viviendas ON ventas.idVivienda = viviendas.idVivienda;");

            filewriter = new FileWriter(fichero);
            escritor = new PrintWriter(filewriter);
            escritor.printf("%-15s%-30s%-20s%-20s\n", "ID Movimiento", "DNI Comprador", "DNI Empleado", "Referencia Catastral");
            if (!data.isEmpty()) {
                for (int i = 0; i < data.size(); i++) {
                    String[] dataRegistro = data.get(i).split(";");
                    escritor.printf("%-15s%-30s%-20s%-20s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filewriter != null) {
                    filewriter.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Método para generar informe de los clientes
    public void generarInformeClientes() {
        File fichero = new File(RUTA + "informe_clientes.txt");
        FileWriter filewriter = null;
        PrintWriter escritor = null;

        try {
            ArrayList<String> data = db.ejecutarObtener("SELECT * FROM clientes;");

            filewriter = new FileWriter(fichero);
            escritor = new PrintWriter(filewriter);
            escritor.printf("%-15s%-15s%-20s%-11s%-11s\n", "ID Cliente", "Nombre", "Apellidos", "DNI", "Teléfono");
            if (!data.isEmpty()) {
                for (int i = 0; i < data.size(); i++) {
                    String[] dataRegistro = data.get(i).split(";");
                    escritor.printf("%-15s%-15s%-20s%-11s%-11s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filewriter != null) {
                    filewriter.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Método para generar informe de los empleados
    public void generarInformeEmpleados() {
        File fichero = new File(RUTA + "informe_empleados.txt");
        FileWriter filewriter = null;
        PrintWriter escritor = null;

        try {
            ArrayList<String> data = db.ejecutarObtener("SELECT * FROM empleados;");

            filewriter = new FileWriter(fichero);
            escritor = new PrintWriter(filewriter);
            escritor.printf("%-15s%-15s%-20s%-11s%-11s\n", "ID Empleado", "Nombre", "Apellidos", "DNI", "Teléfono");
            if (!data.isEmpty()) {
                for (int i = 0; i < data.size(); i++) {
                    String[] dataRegistro = data.get(i).split(";");
                    escritor.printf("%-15s%-15s%-20s%-11s%-11s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filewriter != null) {
                    filewriter.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Método para generar informe de las viviendas
    public void generarInformeViviendas() {
        File fichero = new File(RUTA + "informe_viviendas.txt");
        FileWriter filewriter = null;
        PrintWriter escritor = null;

        try {
            ArrayList<String> data = db.ejecutarObtener("SELECT idVivienda, referencia_catastral, direccion, localidad, pais, precio, numPlantas, clientes.dni FROM viviendas INNER JOIN clientes ON viviendas.idPropietario = clientes.idCliente;");

            filewriter = new FileWriter(fichero);
            escritor = new PrintWriter(filewriter);
            escritor.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-20s\n", "ID Vivienda", "Referencia Catastral", "Dirección", "Localidad", "Pais", "Precio", "Número de plantas", "DNI del Propietario");
            if (!data.isEmpty()) {
                for (int i = 0; i < data.size(); i++) {
                    String[] dataRegistro = data.get(i).split(";");
                    escritor.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-20s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4], dataRegistro[5], dataRegistro[6], dataRegistro[7]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filewriter != null) {
                    filewriter.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    // FIN INFORMES

}
