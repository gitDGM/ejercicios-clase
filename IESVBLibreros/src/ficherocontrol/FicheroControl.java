/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherocontrol;

import iesvblibreros.Articulo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class FicheroControl {
    private static final String RUTA = "src/lanzador/";
    private final File fichero;

    public FicheroControl(String nombreFichero) {
        this.fichero = new File(RUTA + nombreFichero);
    }    

    public File getFichero() {
        return fichero;
    }
    
    public void guardarArticulos(ArrayList<Articulo> articulos) {
        
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {         
            filewriter = new FileWriter(fichero);
            escritor = new PrintWriter(filewriter);
            
            for (Articulo articulo : articulos) {
                escritor.println(articulo.getNombre() + " - " + articulo.getPrecio() + " - " + articulo.getExistencias());
            }
            
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
}
