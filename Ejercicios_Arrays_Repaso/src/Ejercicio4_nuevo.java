
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio4_nuevo {
    final static int N_PROVINCIAS = 3;
    final static int N_CIUDADES = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Provincia[] provincias = new Provincia[N_PROVINCIAS];
        
        for(int i = 0; i < provincias.length; i++) {
            System.out.println("Introduce el nombre de la provincia: ");
            String nombreProvincia = sc.nextLine();
            Ciudad[] ciudades = new Ciudad[N_CIUDADES];
            for(int j = 0; j < ciudades.length; j++) {
                System.out.println("Introduce el nombre de la ciudad: ");
                String nombreCiudad = sc.nextLine();
                System.out.println("Introduce la cantidad de población: ");
                int poblacion = sc.nextInt();
                sc.nextLine();
                ciudades[j] = new Ciudad(nombreCiudad, poblacion);
            }
            provincias[i] = new Provincia(nombreProvincia, ciudades);
        }
        mostrarDatosEjercicio(provincias);
    }
    
    static void mostrarDatosEjercicio(Provincia[] provincias) {
        
        for (int i = 0; i < provincias.length; i++) {
            Ciudad ciudadMayorPoblacion = conseguirCiudadMayorPoblacion(provincias[i].ciudades);
            System.out.println("##### " + provincias[i].nombre + " #####");
            System.out.println("Ciudad con más población: " + ciudadMayorPoblacion.nombre);
            System.out.println("Población: " + ciudadMayorPoblacion.poblacion);
            System.out.println("###################\n");
        }
    }
    
    static Ciudad conseguirCiudadMayorPoblacion(Ciudad[] ciudades) {
        Ciudad ciudad = ciudades[0];
        
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i].poblacion > ciudad.poblacion) {
                ciudad = ciudades[i];
            }
        }
        
        return ciudad;
    }
}

class Provincia {
    String nombre;
    Ciudad[] ciudades;
    
    public Provincia(String nombre, Ciudad[] ciudades) {
        this.nombre = nombre;
        this.ciudades = ciudades;
    }
}

class Ciudad {
    String nombre;
    int poblacion;
    
    public Ciudad(String nombre, int poblacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
    }
}