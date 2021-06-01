/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

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

    public void insertarComunidad(String nombre) {
        String query = "SELECT * FROM comunidad WHERE nombre = '" + nombre + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (data.isEmpty()) {
            db.ejecutarModificar("INSERT INTO comunidad VALUES (NULL, '" + nombre + "');");
        } else {
            System.err.println("ERROR: Ya existe una comunidad con ese nombre.");
        }
    }

    public void eliminarComunidad(String nombre) {
        String query = "SELECT * FROM comunidad WHERE nombre = '" + nombre + "';";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            db.ejecutarModificar("DELETE FROM comunidad WHERE nombre = '" + nombre + "';");
        } else {
            System.err.println("ERROR: No existe ninguna comunidad con ese nombre.");
        }
    }
}
