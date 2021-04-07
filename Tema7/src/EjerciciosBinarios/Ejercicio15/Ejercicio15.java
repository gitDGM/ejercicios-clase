/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author alumno
 */
public class Ejercicio15 {
    private static final String RUTA = "src/EjerciciosBinarios/Ejercicio15/";
    public static void main(String[] args) {
        File ficheroBinario = new File(RUTA + "textoBinario.dat");
        
        if (ficheroBinario.exists()) {
            System.out.println(cargarTextoDeFicheroBinario(ficheroBinario));
        } else {
            String texto = ficheroToString();
            guardarTextoEnFicheroBinario(texto);            
        }
        
    }
    
    private static void guardarTextoEnFicheroBinario(String texto) {
        ObjectOutputStream flujoObjetos = null;

        try {
            flujoObjetos = new ObjectOutputStream(new FileOutputStream(new File(RUTA + "textoBinario.dat")));
            flujoObjetos.writeObject(texto);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (flujoObjetos != null) {
                    flujoObjetos.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    private static String ficheroToString() {
        
        String texto = "";        
        FileReader filereader = null;
        BufferedReader lector = null;
        
        try {
            
            filereader = new FileReader(new File(RUTA + "texto.txt"));
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
        
        return texto;
    }
    
    private static String cargarTextoDeFicheroBinario(File ficheroBinario) {
        String cadena = "";
         
        ObjectInputStream flujoObjetos = null;
        try {
            flujoObjetos = new ObjectInputStream(new FileInputStream(ficheroBinario));
            cadena = (String) flujoObjetos.readObject();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (flujoObjetos != null) {
                    flujoObjetos.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return cadena;
    }
}
