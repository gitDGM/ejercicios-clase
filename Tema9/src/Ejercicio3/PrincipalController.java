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
        listarLoros();
        listarCanarios();

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

    public void listarLoros() {
        String query = "SELECT idMascota, nombre, edad, vivo, fecha_nacimiento, pico, vuela, origen, habla FROM mascotas WHERE tipo=3;";
        String verificarQuery = "SELECT count(idMascota) FROM mascotas WHERE tipo=3;";

        if (contieneDatos(verificarQuery)) {
            ArrayList<String> data = db.ejecutarObtener(query);

            System.out.println("##### LOROS #####");
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

    public void listarCanarios() {
        String query = "SELECT idMascota, nombre, edad, vivo, fecha_nacimiento, pico, vuela, color, canta FROM mascotas WHERE tipo=4;";
        String verificarQuery = "SELECT count(idMascota) FROM mascotas WHERE tipo=4;";

        if (contieneDatos(verificarQuery)) {
            ArrayList<String> data = db.ejecutarObtener(query);

            System.out.println("##### CANARIOS #####");
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

    public void mostrarDatosMascota(int idMascota) {
        String query = "select * from mascotas where idMascota = " + idMascota + " and tipo = (select tipo from mascotas where idMascota = " + idMascota + ");";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            int tipo = Integer.parseInt(data.get(0).split(";")[14]);
            switch (tipo) {
                case 1:
                    System.out.println("perro");
                    break;
                case 2:
                    System.out.println("gato");
                    break;
                case 3:
                    System.out.println("loro");
                    break;
                case 4:
                    System.out.println("canario");
                    break;
            }
        } else {
            System.err.println("ERROR: No existe ninguna mascota con ese ID.");
        }

    }

    public void mostrarPerro(int idMascota) {
        String query = "SELECT idMascota, nombre, edad, vivo, fecha_nacimiento, raza, pulgas FROM mascotas WHERE idMascota = " + idMascota + ";";

        ArrayList<String> data = db.ejecutarObtener(query);

        if (!data.isEmpty()) {
            String[] dataCampos = data.get(0).split(";");
            for (int i = 0; i < dataCampos.length; i++) {
                System.out.print(dataCampos[i] + "\t");
            }
            System.out.println();
        } else {
            System.err.println("ERROR: No existe ninguna mascota con ese ID.");
        }

        System.out.println("");
    }

    private boolean contieneDatos(String query) {
        return !db.ejecutarObtener(query).get(0).equals("0");
    }

}
