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

    private Conexion db;

    public PrincipalController(String bbdd) {
        db = new Conexion(bbdd);
        db.conectar();
    }

    public void buscarFabricante() {
        ArrayList<String> data = db.ejecutarObtener("SELECT * FROM fabricante");

        System.out.println(data.get(0));
    }
}
