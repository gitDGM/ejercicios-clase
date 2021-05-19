/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import Conexion.Conexion;
import java.util.regex.Pattern;

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

    public void insertarFuncionario(String nombre, String provincia, int edad) {
        String query = "INSERT INTO funcionarios VALUES (null, '" + nombre + "', '" + provincia + "', " + edad + ");";
        db.ejecutarModificar(query);
    }

    public void insertarContribuyente(String dni, String nombre, String poblacion, int idFuncionario, double importe, boolean pagar) {
        String query = "INSERT INTO contribuyentes values (null, '" + dni + "', '" + nombre + "', '" + poblacion + "', " + idFuncionario + ", " + importe + ", " + pagar + ", NOW());";

        if (existeFuncionario(idFuncionario) && verificarDNI(dni)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: No ha sido posible añadir el contribuyente.");
        }
    }

    public boolean existeFuncionario(int idFuncionario) {
        String query = "SELECT count(idFuncionario) from funcionarios where idFuncionario=" + idFuncionario + ";";
        boolean existe;

        existe = !db.ejecutarObtener(query).get(0).equals("0");

        return existe;
    }

    public boolean existeContribuyente(String dni) {
        String query = "SELECT count(dni) from contribuyentes where dni='" + dni + "';";

        return !db.ejecutarObtener(query).get(0).equals("0");
    }

    public void eliminarContribuyente(String dni) {
        String query = "DELETE FROM contribuyentes where dni='" + dni + "';";

        if (existeContribuyente(dni)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: No existe ningún contribuyente con ese DNI.");
        }
    }

    private boolean verificarDNI(String dni) {
        String dniRegex = "\\d{8}[A-HJ-NP-TV-Z]";

        return Pattern.matches(dniRegex, dni);
    }
}
