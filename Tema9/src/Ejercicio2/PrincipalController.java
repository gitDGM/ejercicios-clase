/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import Conexion.Conexion;
import java.util.regex.Matcher;
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
        System.out.println(query);
        db.ejecutarModificar(query);
    }

    private boolean verificarDNI(String dni) {

        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Matcher matcher = patron.matcher(dni);

        return matcher.matches();
    }

}
