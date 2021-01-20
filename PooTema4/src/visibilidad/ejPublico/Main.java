/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visibilidad.ejPublico;

import visibilidad.ejPrivado.*;
import visibilidad.ejProtegido.*;
import visibilidad.ejDefault.*;

/**
 *
 * @author alumno
 */
public class Main {

    public static void main(String[] args) {
        Protegido protegido = new Protegido(2);
        Default predeterminado = new Default(2);
        Privado privado = new Privado(2);
        Publico publico = new Publico(2);
        
        System.out.println(protegido);
        System.out.println(predeterminado);
        System.out.println(privado);
        System.out.println(publico.numero);
    }
}
