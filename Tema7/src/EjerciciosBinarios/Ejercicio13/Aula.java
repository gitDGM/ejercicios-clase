/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio13;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author 0017610
 */
public class Aula {
    private static final File FICHERO = new File("src/EjerciciosBinarios/Ejercicio13/notasdaw1.dat");
    private static final int ALUMNOS_MAX = 20;
    private ArrayList<Alumno> alumnos;

    public Aula() {
        if (FICHERO.exists()) {
            cargarDatosDeFicheroBinario();
        } else {
            alumnos = new ArrayList();
        }
    }
    
    public void addAlumno(Alumno nuevoAlumno) {
        if (alumnos.size() + 1 <= ALUMNOS_MAX && existeAlumno(getIndexAlumno(nuevoAlumno.getIdMatricula()))) {
            alumnos.add(nuevoAlumno);
        } else {
            System.err.println("ERROR: No se ha añadido el alumno porque el aula ha llegado a su límite.");
        }
    }
    
    public void mostrarAlumnos() {
        for (Alumno alumno : alumnos) {
            alumno.mostrar();
        }
    }
    
    public void guardarDatosEnFicheroBinario() {
        ObjectOutputStream flujoObjetos = null;

        try {
            flujoObjetos = new ObjectOutputStream(new FileOutputStream(FICHERO));
            for (Alumno alumno : alumnos) {
                flujoObjetos.writeObject(alumno);
            }
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
    
    private void cargarDatosDeFicheroBinario() {
        ObjectInputStream flujoObjetos = null;
        try {
            flujoObjetos = new ObjectInputStream(new FileInputStream(FICHERO));
            while (true) {                
                alumnos.add((Alumno) flujoObjetos.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (EOFException ex) {
            // FIN DE FICHERO
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
    }
    
    private boolean existeAlumno(int index) {
        return index != -1;
    }
    
    private int getIndexAlumno(int idMatricula) {
        int index = -1;
        
        for (int i = 0; i < alumnos.size() && index == -1; i++) {
            if (alumnos.get(i).getIdMatricula() == idMatricula) {
                index = i;
            }
        }
        
        return index;
    }
}
