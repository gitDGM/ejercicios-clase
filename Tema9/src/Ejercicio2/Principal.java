/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author alumno
 */
public class Principal {

    private static final Ejercicio1.PrincipalController db = new Ejercicio1.PrincipalController("tienda");
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar fabricante");
            System.out.println("2.- Insertar producto");
            System.out.println("3.- Eliminar producto");
            System.out.println("4.- Modificar producto");
            System.out.println("5.- Mostrar producto de un fabricante");
            System.out.println("6.- Generar fichero de texto (Productos >= 500€)");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }
}
