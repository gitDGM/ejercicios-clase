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

    public void insertarCasa(String referenciaCatastral, String direccion, String localidad, String pais, double precio, int numPlantas, String dniPropietario) {
        String query = "SELECT * FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("INSERT INTO viviendas VALUES (NULL, '" + referenciaCatastral + "', '" + direccion + "', '" + localidad + "', '" + pais + "', " + precio + ", NULL, " + numPlantas + ", (SELECT idCliente FROM clientes WHERE dni = '" + dniPropietario + "'));");
        } else {
            System.err.println("ERROR: No es posible añadir esta casa, ya existe una casa con esa referencia catastral.");
        }
    }

    public void insertarPiso(String referenciaCatastral, String direccion, String localidad, String pais, double precio, boolean duplex, String dniPropietario) {
        String query = "SELECT * FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("INSERT INTO viviendas VALUES (NULL, '" + referenciaCatastral + "', '" + direccion + "', '" + localidad + "', '" + pais + "', " + precio + ", " + duplex + ", NULL, (SELECT idCliente FROM clientes WHERE dni = '" + dniPropietario + "'));");
        } else {
            System.err.println("ERROR: No es posible añadir este piso, ya existe un piso con esa referencia catastral.");
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
        String query = "SELECT * FROM viviendas WHERE referencia_catastral = '" + referenciaCatastral + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("");
        } else {
            System.err.println("ERROR: No es posible añadir este cliente, el DNI ya existe.");
        }
    }
}
