/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import Conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class PrincipalController {

    private final Conexion db;

    public PrincipalController(String bbdd) {
        db = new Conexion(bbdd);
        db.conectar();
    }

    public void buscarFabricante() {
        ArrayList<String> data = db.ejecutarObtener("SELECT * FROM fabricante");

        System.out.println(data.get(0));
    }

    public void insertarFabricante(String nombreFabricante) {
        db.ejecutarModificar("INSERT INTO fabricante VALUES (NULL, '" + nombreFabricante + "');");
    }

    public void insertarProducto(String nombreProducto, double precio, int idFabricante) {
        String query = "INSERT INTO producto VALUES (NULL, '" + nombreProducto + "', " + precio + ", " + idFabricante + ");";

        if (existeFabricante(idFabricante)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: El fabricante no existe.");
        }

    }

    public void borrarProducto(int idProducto) {
        String query = "DELETE FROM producto WHERE codigo=" + idProducto + ";";

        if (existeProducto(idProducto)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: El producto no existe.");
        }
    }

    public void modificarProducto(int idProducto, double nuevoPrecio) {
        String query = "UPDATE producto set precio=" + nuevoPrecio + " where codigo=" + idProducto + ";";

        if (existeProducto(idProducto)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: El producto no existe.");
        }
    }

    public void modificarProducto(int idProducto, boolean existe, double nuevoPrecio) {
        String query = "UPDATE producto set precio=" + nuevoPrecio + " where codigo=" + idProducto + ";";

        if (existe) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: El producto no existe.");
        }
    }

    public void mostrarProductosFrabricante(int idFabricante) {
        String query = "SELECT * FROM producto where codigo_fabricante=" + idFabricante;

        if (existeFabricante(idFabricante)) {
            ArrayList<String> resultado = db.ejecutarObtener(query);
            mostrarTablaProducto(resultado);
        } else {
            System.err.println("ERROR: El fabricante no existe.");
        }
    }

    public void generarFicheroProductos(double precioMin) {
        String query = "SELECT * FROM producto where precio >= " + precioMin + ";";
        String queryVerificar = "SELECT COUNT(codigo) FROM producto where precio >= " + precioMin + ";";

        if (contieneDatos(queryVerificar)) {
            ArrayList<String> resultado = db.ejecutarObtener(query);
            mostrarTablaProducto(resultado);
        }
    }

    public boolean existeProducto(int idProducto) {
        String query = "SELECT count(codigo) from producto where codigo=" + idProducto + ";";
        boolean existe;

        existe = !db.ejecutarObtener(query).get(0).equals("0");

        return existe;
    }

    public boolean contieneDatos(String query) {
        return !db.ejecutarObtener(query).get(0).equals("0");
    }

    public boolean existeFabricante(int idFabricante) {
        String query = "SELECT count(codigo) from fabricante where codigo=" + idFabricante + ";";
        boolean existe;

        existe = !db.ejecutarObtener(query).get(0).equalsIgnoreCase("0");

        return existe;
    }

    private void mostrarTablaProducto(ArrayList<String> data) {

        for (int i = 0; i < data.size(); i++) {
            System.out.println("\n####### PRODUCTOS ########");
            String[] dataFila = data.get(i).split(";");
            for (String campo : dataFila) {
                System.out.print(campo + "\t");
            }
            System.out.println("\n##########################\n");
        }
    }
}
