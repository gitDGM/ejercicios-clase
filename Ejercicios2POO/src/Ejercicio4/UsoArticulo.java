/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class UsoArticulo {
    public static void main(String[] args) {
        ArrayList<Articulo> articulos = new ArrayList<>();
        try {            
            articulos.add(new Articulo("Manzana", 5.0, 21, 50));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        articulos.get(0).imprimir();
        System.out.println("PVP: " + articulos.get(0).getPVP());
        System.out.println("PVP con descuento de 10%: " + articulos.get(0).getPVPDescuento(10));
        int vendidos = 15;
        if (articulos.get(0).vender(vendidos)) {
            System.out.println("Has vendido " + vendidos + " articulos.");
        } else {
            System.out.println("Cantidad inválida.");
        }
        int almacenados = 50;
        if (articulos.get(0).almacenar(almacenados)) {
            System.out.println("Has almacenado " + almacenados + " articulos.");
        } else {
            System.out.println("Cantidad inválida.");
        }
        articulos.get(0).imprimir();
    }
}
