/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvblibreros;


import ficherocontrol.FicheroControl;
import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class Libreria {
    // ATRIBUTOS
    private final ArrayList<Articulo> articulos;

    // CONSTRUCTOR
    public Libreria() {
        articulos = new ArrayList();
    }
    
    // GETTERS Y SETTERS
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }
    
    // METODO PARA AGREGAR UN ARTICULO
    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }
    
    // METODO PARA ELIMINAR UN ARTICULO
    // Lo busco por su nombre, consiguiendo el index,
    // luego lo borro utilizando su index.
    public void eliminarArticulo(String nombre) {
        int indexArticulo = buscarArticuloPorNombre(nombre);
        if (indexArticulo != -1) {
            articulos.remove(indexArticulo);
        } else {
            System.err.println("El articulo buscado no existe.");
        }
    }
    
    // METODO PARA MOSTRAR UN ARTICULO
    // Lo busco por su nombre, consiguiendo el index,
    // luego lo muestro utilizando su index.
    public void mostrarArticulo(String nombre) {
        int indexArticulo = buscarArticuloPorNombre(nombre);
        if (indexArticulo != -1) {
            System.out.println();
            articulos.get(indexArticulo).mostrarArticulo();
            System.out.println();
        } else {
            System.err.println("El articulo buscado no existe.");
        }
    }
    
    public void mostrarArticulos() {
        if (!articulos.isEmpty()) {
            for (Articulo articulo : articulos) {
                articulo.mostrarArticulo();
                System.out.println();
            }
        } else {
            System.err.println("ATENCION: No existen articulos.");
        }
    }
    
    // METODO PARA BORRAR TODOS LOS ARTICULOS
    public void borrarTodos() {
        if (!articulos.isEmpty()) {           
            for (int i = 0; i < articulos.size(); i++) {
                articulos.remove(i);
            }
            System.out.println("ATENCION: Todos los articulos han sido eliminados.");
        } else {
            System.out.println("ATENCION: No hay articulos para eliminar.");            
        }
    }
    
    // METODO PARA MOSTRAR EL INVENTARIO
    public void mostrarInventario() {
        System.out.println("Inventario: " + calcularInventario() + "\n");
    }
    
    
    // EJERCICIO 14    
    
    public void guardarArticulos() {
        FicheroControl fileController = new FicheroControl("salida.txt");        
        fileController.guardarArticulos(articulos);
    }
    
    ///////////////
    
    
    
    // METODO PARA CALCULAR EL INVENTARIO
    private double calcularInventario() {
        double inventario = 0;
        
        if (!articulos.isEmpty()) {
            for (Articulo articulo : articulos) {
                inventario += articulo.getPrecio() * articulo.getExistencias();
            }
        }
        
        return inventario;
    }
    
    // METODO PRIVADO PARA BUSCAR EL INDEX DE UN ARTICULO
    private int buscarArticuloPorNombre(String nombre) {
        int indexArticulo = -1;
        for (int i = 0; i < articulos.size() && indexArticulo == -1; i++) {
            if (articulos.get(i).getNombre().equals(nombre)) {
                indexArticulo = i;
            }
        }
        return indexArticulo;
    }
    
}
