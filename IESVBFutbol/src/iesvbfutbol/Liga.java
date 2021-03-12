/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbfutbol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Liga {
    private final ArrayList<Equipo> equipos;
    private final ArrayList<Partido> partidos;

    public Liga() {
        this.equipos = new ArrayList();
        this.partidos = new ArrayList();
        
        cargarEquipos();
    }
    
    private void cargarEquipos() {
        File fileEquipos = new File("src/datafutbol/equipos.txt");
        
        FileReader fr = null;
        BufferedReader lector = null;   
            try {            
                fr = new FileReader(fileEquipos);
                lector = new BufferedReader(fr);  
                String cadenaLeida = lector.readLine();
                
                while (cadenaLeida != null && !cadenaLeida.equals("")) {
                    equipos.add(new Equipo(cadenaLeida));
                    cadenaLeida = lector.readLine();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    if (fr != null) fr.close();
                    if (lector != null) lector.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                    
                }
            }   
    }
    
    private void cargarPartidos() { // NO ESTÁ HECHO
        File filePartidos = new File("src/datafutbol/partidos.txt");
        
        FileReader fr = null;
        BufferedReader lector = null;   
            try {            
                fr = new FileReader(filePartidos);
                lector = new BufferedReader(fr);  
                String cadenaLeida = lector.readLine();
                
                while (cadenaLeida != null && !cadenaLeida.equals("")) {
                    //partidos.add(new Partido(cadenaLeida));
                    cadenaLeida = lector.readLine();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    if (fr != null) fr.close();
                    if (lector != null) lector.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                    
                }
            }   
    }
}
