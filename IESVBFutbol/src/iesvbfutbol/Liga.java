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
        
        cargarPartidosEnEquipos();
        ordenarClasificacionPorPuntos();
    }
    
    public void mostrarClasificacion() {
        for(Equipo equipo : equipos) {
            equipo.mostrar();
        }
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
                equipos.add(instanciarEquipo(cadenaLeida));
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
    
    private Equipo instanciarEquipo(String lineaPartido) {
        String[] dataEquipo = lineaPartido.split(":");
        
        return new Equipo(Integer.parseInt(dataEquipo[0]), dataEquipo[1]);
    }
    
    private Partido instanciarPartido(String lineaPartido) {
        String[] dataPartido = lineaPartido.split(":");
        
        Equipo equipoLocal = new Equipo(Integer.parseInt(dataPartido[0]),buscarNombreEquipoFromIndex(Integer.parseInt(dataPartido[0])));
        Equipo equipoVisitante = new Equipo(Integer.parseInt(dataPartido[1]),buscarNombreEquipoFromIndex(Integer.parseInt(dataPartido[1])));
        
        return new Partido(equipoLocal, equipoVisitante, Integer.parseInt(dataPartido[2]), Integer.parseInt(dataPartido[3]));
    }
    
    private void cargarPartidosEnEquipos() {
        for(Partido partido : partidos) {
            int indexEquipoLocal = buscarIndexEquipoFromNombre(partido.getEquipoLocal().getNombre());
            int indexEquipoVisitante = buscarIndexEquipoFromNombre(partido.getEquipoVisitante().getNombre());  
            
            darPuntosPartidoEquipos(partido, indexEquipoLocal, indexEquipoVisitante);
            
            aumentarGolesEquipoPorPartido(indexEquipoLocal, partido);
            aumentarGolesEquipoPorPartido(indexEquipoVisitante, partido);
        }
    }
    
    private void aumentarGolesEquipoPorPartido(int index, Partido partido) {
        equipos.get(index).aumentarGolesFavor(partido.getGolesLocal());
        equipos.get(index).aumentarGolesContra(partido.getGolesVisitante());
    }
    
    private void darPuntosPartidoEquipos(Partido partido, int indexEquipoLocal, int indexEquipoVisitante) {
        if (partido.getGolesLocal() > partido.getGolesVisitante()) {
            equipos.get(indexEquipoLocal).ganar();
        } else if (partido.getGolesLocal() == partido.getGolesVisitante()) {
            equipos.get(indexEquipoLocal).empatar();
            equipos.get(indexEquipoVisitante).empatar();
        } else {
            equipos.get(indexEquipoVisitante).ganar();
        }
    }
    
    private void ordenarClasificacionPorPuntos() {
        for (int i = 0; i < equipos.size() - 1; i++) {
            for (int k = 0; k < equipos.size() - i - 1; k++) {
                if (equipos.get(k).getPuntos() < equipos.get(k + 1).getPuntos()) {
                    Equipo temp = equipos.get(k + 1);
                    equipos.set(k + 1, equipos.get(k));
                    equipos.set(k, temp);
                }
            }
        }
    }
    
    private String buscarNombreEquipoFromIndex(int index) {
        return equipos.get(index).getNombre();
    }
    
    private int buscarIndexEquipoFromNombre(String nombreEquipo) {
        boolean encontrado = false;
        int index;
        
        for (index = 0; index < equipos.size() && !encontrado; index++) {
            if (nombreEquipo.equals(equipos.get(index).getNombre())) {
                encontrado = true;
            }
        }
        
        return index - 1;
    }
}
