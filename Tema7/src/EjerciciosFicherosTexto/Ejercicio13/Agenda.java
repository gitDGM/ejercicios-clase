/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Agenda {
    private static final int CONTACTOS_MAX = 20;
    private final ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList();
        
        File datos = new File("src/EjerciciosFicherosTexto/Ejercicio13/agenda.txt");
        
        if (datos.exists() && comprobarSiHayDatosGuardados(datos)) {            
            cargarDatosGuardados(datos);
        }
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    
    public void addContacto(String nombre, String telefono) {
        if (contactos.size() < CONTACTOS_MAX && !comprobarSiExiste(nombre)) {
            contactos.add(new Contacto(nombre, telefono));
        } else {
            if (contactos.size() == CONTACTOS_MAX) {
                System.err.println("ATENCIÓN: Has llegado al límite y no se añadió.");
            } else {
                System.err.println("ATENCIÓN: El contacto que ya existía y no se ha añadido.");
            }
        }
    }
    
    public void guardarContactos() {
        for (int i = 0; i < contactos.size(); i++) {
            escribirContacto(contactos.get(i));
        }
    }
    
    public void mostrarContactos() {
        for (int i = 0; i < contactos.size(); i++) {
            contactos.get(i).mostrar();
        }
    }
    
    public void mostrarContactosCadena(String cadena) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().startsWith(cadena)) {
                contactos.get(i).mostrar();
            }
        }
    }
    
    private boolean comprobarSiExiste(String nombre) {
        boolean repetido = false;
        
        for (int i = 0; i < contactos.size() && !repetido; i++) {
            repetido = contactos.get(i).getNombre().equals(nombre);
        }
        
        return repetido;
    }
    
    private void escribirContacto(Contacto contacto) {
        File fichero = new File("src/EjerciciosFicherosTexto/Ejercicio13/agenda.txt");
        
        if (fichero.exists()) {
            fichero.delete();
        }        
        
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {         
            filewriter = new FileWriter(fichero, true);
            escritor = new PrintWriter(filewriter);
            escritor.println(contacto.getNombre() + ":" + contacto.getTelefono());            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filewriter != null) filewriter.close();
                if (escritor != null) escritor.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());                    
            }
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
    
    private void cargarDatosGuardados(File fichero) {
        try {
            String cadenaDatos = ficheroToString(fichero);  
            String[] filasContactos = cadenaDatos.split("\n");
            
            for (int i = 0; i < filasContactos.length && i < CONTACTOS_MAX + 1; i++) {
                String[] filaContacto = filasContactos[i].split(":");
                addContacto(filaContacto[0], filaContacto[1]);
            }
            
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
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
