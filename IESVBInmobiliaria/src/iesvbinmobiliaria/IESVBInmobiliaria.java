/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria;

import Conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class IESVBInmobiliaria {

    private final Conexion db;

    public IESVBInmobiliaria(String bbdd) {
        db = new Conexion(bbdd);
        db.conectar();
    }

    // INICIO GESTION
    public void insertarCliente(String nombre, String apellidos, String dni, String telefono) {
        String query = "SELECT * FROM clientes WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("INSERT INTO clientes VALUES (NULL, '" + nombre + "', '" + apellidos + "', '" + dni + "', '" + telefono + "' );");
        } else {
            System.err.println("ERROR: No es posible añadir este cliente, el DNI ya existe.");
        }
    }

    public void eliminarCliente(String dni) {
        String query = "SELECT * FROM clientes WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            db.ejecutarModificar("DELETE FROM clientes WHERE dni = '" + dni + "';");
        } else {
            System.err.println("ERROR: No existe ningún registro con ese DNI.");
        }
    }

    public void insertarEmpleado(String nombre, String apellidos, String dni, String telefono) {
        String query = "SELECT * FROM empleados WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("INSERT INTO empleados VALUES (NULL, '" + nombre + "', '" + apellidos + "', '" + dni + "', '" + telefono + "' );");
        } else {
            System.err.println("ERROR: No es posible añadir este empleado, ya existe un empleado con ese DNI.");
        }
    }

    public void eliminarEmpleado(String dni) {
        String query = "SELECT * FROM empleados WHERE dni = '" + dni + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            db.ejecutarModificar("DELETE FROM empleados WHERE dni = '" + dni + "';");
        } else {
            System.err.println("ERROR: No existe ningún registro con ese DNI.");
        }
    }

    public void insertarVivienda(String referenciaCatastral, String direccion, String localidad, String pais, double precio, int numPlantas, String dniPropietario) {
        String query = "SELECT * FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("INSERT INTO viviendas VALUES (NULL, '" + referenciaCatastral + "', '" + direccion + "', '" + localidad + "', '" + pais + "', " + precio + ", " + numPlantas + ", (SELECT idCliente FROM clientes WHERE dni = '" + dniPropietario + "'));");
        } else {
            System.err.println("ERROR: No es posible añadir esta vivienda, ya existe una vivienda con esa referencia catastral.");
        }
    }

    public void eliminarVivienda(String referenciaCatastral) {
        String query = "SELECT * FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            db.ejecutarModificar("DELETE FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';");
        } else {
            System.err.println("ERROR: No existe ningún registro con esa referencia catastral.");
        }
    }

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
            System.err.println("ATENCIÓN: Actualmente no hay registros de empleados.");
        }
    }

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
            System.err.println("ATENCIÓN: Actualmente no existe ese empleado.");
        }
    }

    public void listarViviendasPropietario(String dni) {
        String query = "SELECT idVivienda, referencia_catastral, direccion, localidad, pais, precio, numPlantas, clientes.dni FROM viviendas INNER JOIN clientes ON viviendas.idPropietario = clientes.idCliente WHERE idPropietario = (SELECT idCliente FROM cliente WHERE dni = '" + dni + "');";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            System.out.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-30s\n", "ID Vivienda", "Referencia Catastral", "Dirección", "Localidad", "Pais", "Precio", "Número de plantas", "DNI del Propietario");
            for (int i = 0; i < data.size(); i++) {
                String[] dataRegistro = data.get(i).split(";");
                System.out.printf("%-15s%-30s%-20s%-15s%-15s%-18s%-20s%-30s\n", dataRegistro[0], dataRegistro[1], dataRegistro[2], dataRegistro[3], dataRegistro[4], dataRegistro[5], dataRegistro[6], dataRegistro[7]);
            }
        } else {
            System.err.println("ATENCIÓN: Actualmente no existe ese empleado.");
        }
    }
    // FIN CONSULTAS

}
