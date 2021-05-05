/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicasClase.EjercicioArticulos;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author alumno
 */
public class ArticuloController {
    private final Stack<Articulo> articulos;

    public ArticuloController() {
        articulos = new Stack();
    }
    
    public void agregarArticulo(Articulo nuevoArticulo) {
        if (!existeArticulo(nuevoArticulo)) {
            articulos.push(nuevoArticulo);
        } else {
            System.err.println("ERROR: Ya existe un articulo con ese código.");
        }
    }
    
    public void mostrar() {
        Iterator<Articulo> it = articulos.iterator();
        while (it.hasNext()) {
            Articulo next = it.next();
            if (next.getStock() < 100) {
                System.out.println(next.toString());
            }
        }
    }
    
    public boolean estaVacia() {
        return articulos.isEmpty();
    }
    
    private boolean existeArticulo(Articulo nuevoArticulo) {
        boolean existe = false;
        if (!estaVacia()) {
            Iterator<Articulo> it = articulos.iterator();
            while (it.hasNext() && !existe) {
                Articulo next = it.next();
                existe = next.getCodigo() == nuevoArticulo.getCodigo();                
            }
        }
        
        return existe;        
    }
}
