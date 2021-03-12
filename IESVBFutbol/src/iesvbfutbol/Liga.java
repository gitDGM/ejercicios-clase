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
        cargarPartidos();
    }
    
    public void mostrarClasificacion() {
        
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
    
    private void cargarPartidos() {
        File filePartidos = new File("src/datafutbol/partidos.txt");
        
        FileReader fr = null;
        BufferedReader lector = null;   
        try {            
            fr = new FileReader(filePartidos);
            lector = new BufferedReader(fr);  
            String cadenaLeida = lector.readLine();

            while (cadenaLeida != null && !cadenaLeida.equals("")) {
                partidos.add(instanciarPartido(cadenaLeida));
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
    
    private Partido instanciarPartido(String lineaPartido) {
        String[] dataPartido = lineaPartido.split(":");
        
        Equipo equipoLocal = new Equipo(buscarNombreEquipoFromIndex(Integer.parseInt(dataPartido[0])));
        Equipo equipoVisitante = new Equipo(buscarNombreEquipoFromIndex(Integer.parseInt(dataPartido[1])));
        
        return new Partido(equipoLocal, equipoVisitante, Integer.parseInt(dataPartido[2]), Integer.parseInt(dataPartido[3]));
    }
    
    private String buscarNombreEquipoFromIndex(int index) {
        return equipos.get(index - 1).getNombre();
    }
}
