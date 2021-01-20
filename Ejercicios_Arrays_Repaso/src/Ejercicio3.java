
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Producto[] productos = new Producto[1];
        int contador = 0;
        char opcion;
        do {
            contador++;
            Producto[] temporalProductos = new Producto[contador];
            for (int i = 0; i < productos.length; i++) {
                temporalProductos[i] = productos[i];
            }
            System.out.println("Introduce el nombre del producto: ");
            String nombreProducto = sc.nextLine();
            System.out.println("Introduce el número de existencias disponibles: ");
            int existencias = sc.nextInt();
            System.out.println("Introduce el tipo (A/B): ");
            char tipo = Character.toUpperCase(sc.next().charAt(0));
            System.out.println("Introduce el precio del producto: ");
            double precio = sc.nextDouble();
            temporalProductos[contador - 1] = new Producto(nombreProducto, existencias, tipo, precio);
            productos = temporalProductos;
            System.out.println("¿Deseas introducir otro producto (S/N)?");
            opcion = Character.toUpperCase(sc.next().charAt(0));
            sc.nextLine();
        } while (opcion != 'N');
        
        int opcionMenu;
        do {
            System.out.println("########## MENU ##########");
            System.out.println("1.- Mostrar producto más caro");
            System.out.println("2.- Existencias de cada tipo de producto");
            System.out.println("3.- Productos por encima de los 1000 euros");
            System.out.println("4.- Producto más barato de tipo B");
            System.out.println("5.- Salir\n");
            System.out.println("Elige una opción: ");
            opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1:
                    mostrarProductoMasCaro(productos);
                    break;
                case 2:
                    mostrarExistenciasTipoProducto(productos);
                    break;
                case 3:
                    productosMasCaros1000(productos);
                    break;
                case 4:
                    productosMasBaratoTipo(productos, 'B');
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción fuera de rango.");
                    break;
            }
        } while (opcionMenu != 5);
    }
    
    static void mostrarExistenciasTipoProducto(Producto[] productos) {
        int existenciasA = 0;
        int existenciasB = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].tipo == 'A') {
                existenciasA += productos[i].existencias;
            } else {
                existenciasB += productos[i].existencias;
            }
        }
        System.out.println("Existencias de productos tipo A: " + existenciasA);
        System.out.println("Existencias de productos tipo B: " + existenciasB);
    }
    
    static Producto conseguirProductoMasCaro(Producto[] productos) {
        Producto productoMasCaro = productos[0];
        
        for(int i = 1; i < productos.length;i++) {
            if (productos[i].precio > productoMasCaro.precio) {
                productoMasCaro = productos[i];
            }
        }
        
        return productoMasCaro;
    }
    
    static void productosMasCaros1000(Producto[] productos) {
        int contador = 0;
        for(int i = 1; i < productos.length;i++) {
            if (productos[i].precio > 1000) {
                productos[i].mostrarDatos();
                contador++;
            }
        }
        if (contador > 0) {
            System.out.println("No hay resultados.");
        }
    }
    
    static void productosMasBaratoTipo(Producto[] productos, char tipo) {
        Producto masBarato = productos[0];
        boolean inicializado = false;
        for(int i = 0; i < productos.length;i++) {
            if (productos[i].tipo == tipo && !inicializado) {
                masBarato = productos[i];
            } else if (productos[i].tipo == tipo && inicializado && productos[i].precio < masBarato.precio) {
                masBarato = productos[i];
            }
        }
        
        System.out.println("Producto más barato de tipo B: " + masBarato.nombreProducto);
        System.out.println("Precio unitario: " + masBarato.precio);
    }
    
    static void mostrarProductoMasCaro(Producto[] productos) {
        System.out.println("Nombre del producto más caro: " + conseguirProductoMasCaro(productos).nombreProducto);
    }
}

class Producto {
    String nombreProducto;
    int existencias;
    char tipo;
    double precio;
    
    public Producto(String nombreProducto, int existencias, char tipo, double precio) {
        this.nombreProducto = nombreProducto;
        this.existencias = existencias;
        this.tipo = tipo;
        this.precio = precio;
    }
    
    public void mostrarDatos() {
        System.out.println("Nombre producto: " + nombreProducto);
        System.out.println("Existencias: " + existencias);
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: " + precio);
        System.out.println();
    }
}
