/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioComunidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class ListadoComunidades {

    // ATRIBUTOS
    private final ArrayList<Comunidad> listadoComunidades;

    // CONSTRUCTOR
    public ListadoComunidades() {
        listadoComunidades = new ArrayList();
        
        // CARGAMOS LAS COMUNIDADES DEL FICHERO
        cargarComunidades();
        
        // ORDENAMOS SEGÚN LAS POBLACIONES MEDIAS
        ordenarComunidadesPorPoblacionMedia();
    }

    // GETTER
    public ArrayList<Comunidad> getComunidades() {
        return listadoComunidades;
    }

    // MÉTODO PARA AÑADIR UNA COMUNIDAD AL LISTADO
    public void addComunidad(Comunidad nuevaComunidad) {
        listadoComunidades.add(nuevaComunidad);
    }
    
    // MÉTODO PARA MOSTRAR TODAS LAS POBLACIONES Y
    // SUS POBLACIONES
    public void mostrar() {
        for (Comunidad comunidad : listadoComunidades) {
            comunidad.mostrar();
            System.out.println();
        }
    }

    // MÉTODO PARA MOSTRAR TODAS LAS POBLACIONES CON SU MEDIA DE POBLACIÓN
    public void mostrarMediaPoblacion() {
        for (Comunidad comunidad : listadoComunidades) {
            comunidad.mostrarMediaPoblacion();
            System.out.println();
        }
    }

    // MÉTODO BUBBLESORT PARA ORDENAR POR LA POBLACIÓN MEDIA DE CADA
    // COMUNIDAD
    private void ordenarComunidadesPorPoblacionMedia() {
        for (int i = 0; i < listadoComunidades.size() - 1; i++) {
            for (int k = 0; k < listadoComunidades.size() - i - 1; k++) {
                if (listadoComunidades.get(k).getMediaPoblacion() < listadoComunidades.get(k + 1).getMediaPoblacion()) {
                    Comunidad temp = listadoComunidades.get(k + 1);
                    listadoComunidades.set(k + 1, listadoComunidades.get(k));
                    listadoComunidades.set(k, temp);
                }
            }
        }
    }

    // MÉTIDO PARA CARGAR COMUNIDADES DESDE EL FICHERO
    private void cargarComunidades() {
        File fichero = new File("src/EjercicioComunidades/comunidades.txt");

        // ARRAY CON LAS LINEAS QUE TIENE EL ARCHIVO
        String[] dataComunidades = ficheroToString(fichero).split("\n");

        // AÑADIMOS A EL LISTADO DE LAS COMUNIDADES LAS COMUNIDADES
        // QUE INSTANCIAMOS CON OTRO MÉTODO
        for (int i = 0; i < dataComunidades.length; i++) {
            addComunidad(instanciarComunidad(dataComunidades[i]));
        }
    }

    // MÉTODO PARA INSTANCIAR UNA COMUNIDAD CON
    // DE LOS DATOS CORRESPONDIENTES A UNA COMUNIDAD
    // Y SUS POBLACIONES
    private Comunidad instanciarComunidad(String lineaComunidad) {
        String[] dataComunidad = lineaComunidad.split(":");

        String nombreComunidad = dataComunidad[0];
        ArrayList<Integer> poblaciones = new ArrayList();

        for (int i = 1; i < dataComunidad.length; i++) {
            poblaciones.add(Integer.parseInt(dataComunidad[i]));
        }

        return new Comunidad(nombreComunidad, poblaciones);
    }

    // MÉTODO PARA CONVERTIR UNA FICHERO A STRING
    private String ficheroToString(File fichero) {

        String texto = "";
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
                if (filereader != null) {
                    filereader.close();
                }
                if (lector != null) {
                    lector.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return texto;
    }
}
