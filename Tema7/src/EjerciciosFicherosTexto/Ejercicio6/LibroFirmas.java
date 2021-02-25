/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio6;


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
public class LibroFirmas {
    private static final String RUTA = "src/EjerciciosFicherosTexto/Ejercicio6/";
    private final ArrayList<Firma> firmas;
    
    public LibroFirmas() {
        firmas = new ArrayList();
        cargarFicheroFirmas();
    }
    
    public void addFirma(String nombre) {
        if (!comprobarRepetido(nombre)) {
            firmas.add(new Firma(nombre));
            escribirFicheroFirma(nombre);
        } else {
            System.err.println("ATENCIÓN: Firma repetida.");
        }
    }
    
    public void mostrar() {
        int index = 1;
        System.out.println("\n###### LIBRO DE FIRMAS ######");
        for (Firma firma : firmas) {
            System.out.println(index + ".- " + firma.getNombre());
            index++;
        }
    }
    
    private void escribirFicheroFirma(String nombreFirma) {
        File fichero = new File(RUTA + "firmas.txt");
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {         
            filewriter = new FileWriter(fichero, true);
            escritor = new PrintWriter(filewriter);
            
            escritor.println(nombreFirma);
            
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
    
    private void cargarFicheroFirmas() {
        File fichero = new File(RUTA + "firmas.txt");
        
        FileReader filereader = null;
        BufferedReader lector = null;
              
        try {
            filereader = new FileReader(fichero);
            lector = new BufferedReader(filereader);        
            
            String firmaLeida = lector.readLine();
            while (firmaLeida != null) {   
                firmas.add(new Firma(firmaLeida));
                firmaLeida = lector.readLine();
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
    }
    
    private boolean comprobarRepetido(String nombre) {
        boolean repetido = false;
        
        for (int i = 0; i < firmas.size() && !repetido; i++) {
            repetido = firmas.get(i).getNombre().equals(nombre);
        }
        
        return repetido;
    }
}
