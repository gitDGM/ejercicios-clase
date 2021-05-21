/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import Conexion.Conexion;
import java.time.LocalDate;

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

    public void insertarPerro(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String raza, boolean pulgas) {
        String query = "INSERT INTO mascotas VALUES (NULL, '" + nombre + "', " + edad + ", " + estado + ", '" + fechaNacimiento.toString() + "', '" + raza + "', " + pulgas + ", null, null, null, null, null, null, null, 1);";

        System.err.println("QUERY: " + query);

        db.ejecutarModificar(query);
    }

}
