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
            System.err.println("ERROR: No es posible añadir este cliente, el DNI ya existe.");
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
}
