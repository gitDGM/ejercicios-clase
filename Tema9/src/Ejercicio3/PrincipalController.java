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

        db.ejecutarModificar(query);
    }

    public void insertarGato(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String color, boolean peloLargo) {
        String query = "INSERT INTO mascotas VALUES (NULL, '" + nombre + "', " + edad + ", " + estado + ", '" + fechaNacimiento.toString() + "', null, null , '" + color + "', " + peloLargo + ", null, null, null, null, null, 2);";

        db.ejecutarModificar(query);
    }

    public void insertarLoro(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, boolean pico, boolean vuela, String origen, boolean habla) {
        String query = "INSERT INTO mascotas VALUES (NULL, '" + nombre + "', " + edad + ", " + estado + ", '" + fechaNacimiento.toString() + "', null, null , null, null, " + pico + ", " + vuela + ", '" + origen + "', " + habla + ", null, 3);";

        db.ejecutarModificar(query);
    }

    public void insertarCanario(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, boolean pico, boolean vuela, String color, boolean canta) {
        String query = "INSERT INTO mascotas VALUES (NULL, '" + nombre + "', " + edad + ", " + estado + ", '" + fechaNacimiento.toString() + "', null, null , '" + color + "', null, " + pico + ", " + vuela + ", null, null, " + canta + ", 4);";

        db.ejecutarModificar(query);
    }

    public void eliminarMascota(int idMascota) {
        String query = "DELETE FROM mascotas WHERE idMascota=" + idMascota + ";";

        if (existeMascota(idMascota)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: No existe ninguna mascota con ese ID.");
        }
    }

    public boolean existeMascota(int idMascota) {
        String query = "SELECT count(idMascota) from mascotas WHERE idMascota=" + idMascota + ";";

        return !db.ejecutarObtener(query).get(0).equals("0");
    }

    public void listarDatosAnimales() {
        String query = "";
    }

}
