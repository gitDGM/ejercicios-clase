/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria;

import Conexion.Conexion;

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

}
