/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import Conexion.Conexion;
import java.time.LocalDate;
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

        listarPerros();
        listarGatos();

    }

    public void listarPerros() {
        String query = "SELECT idMascota, nombre, edad, vivo, fecha_nacimiento, raza, pulgas FROM mascotas WHERE tipo=1;";
        String verificarQuery = "SELECT count(idMascota) FROM mascotas WHERE tipo=1;";

        if (contieneDatos(verificarQuery)) {
            ArrayList<String> data = db.ejecutarObtener(query);

            System.out.println("##### PERROS #####");
            for (int i = 0; i < data.size(); i++) {
                String[] dataFila = data.get(i).split(";");

                for (String campo : dataFila) {
                    System.out.print(campo + "\t");
                }
                System.out.println();
            }
            System.out.println("##################\n");
        }
    }

    public void listarGatos() {
        String query = "SELECT idMascota, nombre, edad, vivo, fecha_nacimiento, color, pelo_largo FROM mascotas WHERE tipo=2;";
        String verificarQuery = "SELECT count(idMascota) FROM mascotas WHERE tipo=2;";

        if (contieneDatos(verificarQuery)) {
            ArrayList<String> data = db.ejecutarObtener(query);

            System.out.println("##### GATOS #####");
            for (int i = 0; i < data.size(); i++) {
                String[] dataFila = data.get(i).split(";");

                for (String campo : dataFila) {
                    System.out.print(campo + "\t");
                }
                System.out.println();
            }
            System.out.println("##################\n");
        }
    }

    private boolean contieneDatos(String query) {
        return !db.ejecutarObtener(query).get(0).equals("0");
    }

}
