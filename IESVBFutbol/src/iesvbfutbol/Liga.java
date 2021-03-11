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
    private final ArrayList<Jornada> jornadas;

    public Liga() {
        this.equipos = new ArrayList();
        this.jornadas = new ArrayList();
        
        cargarEquipos();
    }
    
    private void cargarEquipos() {
        File fileEquipos = new File("src/datafutbol/equipos.txt");
        
        FileReader filereader = null;
        BufferedReader lector = null;   
            try {            
                filereader = new FileReader(fileEquipos);
                lector = new BufferedReader(filereader);  
                String cadenaLeida = lector.readLine();
                
                while (cadenaLeida != null && !cadenaLeida.equals("")) {
                    equipos.add(new Equipo(cadenaLeida));
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
    }
    
    private void cargarJornadas() { // NO ESTÁ HECHO
        File fileJornadas = new File("src/datafutbol/jornadas.txt");
        
        FileReader filereader = null;
        BufferedReader lector = null;   
            try {            
                filereader = new FileReader(fileEquipos);
                lector = new BufferedReader(filereader);  
                String cadenaLeida = lector.readLine();
                
                while (cadenaLeida != null && !cadenaLeida.equals("")) {
                    equipos.add(new Equipo(cadenaLeida));
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
    }
}
