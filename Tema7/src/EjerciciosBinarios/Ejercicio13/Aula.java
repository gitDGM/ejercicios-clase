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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author 0017610
 */
public class Aula {
    private static final File FICHERO = new File("src/EjerciciosBinarios/Ejercicio13/notasdaw1.dat");
    private ArrayList<Alumno> alumnos;

    public Aula() {
        if (FICHERO.exists()) {
            cargarDatosDeFicheroBinario();
        } else {
            alumnos = new ArrayList();
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
}
