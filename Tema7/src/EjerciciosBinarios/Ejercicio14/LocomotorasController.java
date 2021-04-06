/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio14;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class LocomotorasController implements Serializable {
    private static final File FICHERO = new File("src/EjerciciosBinarios/Ejercicio14/Locomotoras.dat");
    private final ArrayList<Locomotora> locomotoras;

    public LocomotorasController() {
        if (siExisteFichero()) {
            locomotoras = cargarLocomotorasDeFichero();
        } else {
            locomotoras = new ArrayList();
        }
    }
    
    public void addLocomotora(Locomotora nuevaLocomotora) {
        locomotoras.add(nuevaLocomotora);
    }
    
    public void removeLocomotora(int idLocomotora) {
        int index = getIndexLocomotora(idLocomotora);
        if (index != -1) {
            locomotoras.remove(getIndexLocomotora(idLocomotora));            
        } else {
            System.err.println("ERROR: No se ha encontrado una locomotora con ese ID.");
        }
    }
    
    public void mostrarLocomotoras() {
        for (Locomotora locomotora : locomotoras) {
            locomotora.mostrar();
        }
    }

    public void guardarLocomotorasEnFichero() {
        ObjectOutputStream flujoObjetos = null;

        try {
            flujoObjetos = new ObjectOutputStream(new FileOutputStream(FICHERO));
            for (Locomotora locomotora : locomotoras) {
                flujoObjetos.writeObject(locomotora);
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

    private ArrayList cargarLocomotorasDeFichero() {
        ArrayList<Locomotora> locomotorasData = new ArrayList();
        
        ObjectInputStream flujoObjetos = null;
        try {
            flujoObjetos = new ObjectInputStream(new FileInputStream(FICHERO));
            while (true) {                
                locomotorasData.add((Locomotora) flujoObjetos.readObject());
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

        return locomotorasData;
    }
    
    private int getIndexLocomotora(int idLocomotora) {
        int index = -1;
        
        for (int i = 0; i < locomotoras.size() && index == -1; i++) {
            if (locomotoras.get(i).getIdLocomotora() == idLocomotora) {
                index = i;
            }
        }
        
        return index;
    }

    private boolean siExisteFichero() {
        return FICHERO.exists();
    }
}
