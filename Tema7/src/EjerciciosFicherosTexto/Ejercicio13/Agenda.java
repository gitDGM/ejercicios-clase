/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Agenda {
    private final ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList();
        
        File datos = new File("src/EjerciciosFicherosTexto/Ejercicio13/agenda.txt");
        
        if (datos.exists() && comprobarSiHayDatosGuardados(datos)) {            
            cargarDatosGuardados();
        }
    }
    
    private boolean comprobarSiHayDatosGuardados(File datos) {
        boolean result = false;
        
        if (datos.exists()) {
            try {                
                String cadenaDatos = ficheroToString(datos);
                result = !cadenaDatos.equals("");
            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
                result = false;
            }
        }
        
        return result;
    }
    
    private void cargarDatosGuardados() {
        String cadenaDatos = ficheroToString(fichero)
    }
    
    private String ficheroToString(File fichero) throws Exception {        
        String texto = ""; 
        if (fichero.exists()) {
            FileReader filereader = null;
            BufferedReader lector = null;

            try {

                filereader = new FileReader(fichero);
                lector = new BufferedReader(filereader);

                String cadenaLeida = lector.readLine();
                while (cadenaLeida != null) {
                    texto += cadenaLeida + "\n";
                    cadenaLeida = lector.readLine();
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            } finally {
                try {
                    if (filereader != null) filereader.close();
                    if (lector != null) lector.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                    
                }
            }       
        } else {
            throw new Exception("El archivo no existe.");
        }
        
        return texto;
    }
}
