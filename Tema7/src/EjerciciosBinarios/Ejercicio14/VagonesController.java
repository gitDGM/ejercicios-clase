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
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class VagonesController {

    private static final File FICHERO = new File("src/EjerciciosBinarios/Ejercicio14/Vagones.dat");
    private final ArrayList<Vagon> vagones;

    public VagonesController() {
        if (siExisteFichero()) {
            vagones = cargarVagonesDeFichero();
        } else {
            vagones = new ArrayList();
        }
    }

    public void addVagon(Vagon nuevoVagon) {
        if (getIndexVagon(nuevoVagon.getIdVagon()) == -1) {
            vagones.add(nuevoVagon);
        } else {
            System.err.println("ERROR: Ya existe un vagón con ese ID.");
        }
    }

    public void removeVagon(int idVagon) {
        int index = getIndexVagon(idVagon);
        if (index != -1) {
            vagones.remove(index);
        } else {
            System.err.println("ERROR: No se ha encontrado una locomotora con ese ID.");
        }
    }

    public void mostrarVagones() {
        for (Vagon vagon : vagones) {
            vagon.mostrar();
        }
    }

    public void guardarVagonesEnFichero() {
        ObjectOutputStream flujoObjetos = null;

        try {
            flujoObjetos = new ObjectOutputStream(new FileOutputStream(FICHERO));
            for (Vagon vagon : vagones) {
                flujoObjetos.writeObject(vagon);
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

    private ArrayList cargarVagonesDeFichero() {
        ArrayList<Vagon> vagonesData = new ArrayList();

        ObjectInputStream flujoObjetos = null;
        try {
            flujoObjetos = new ObjectInputStream(new FileInputStream(FICHERO));
            while (true) {
                vagonesData.add((Vagon) flujoObjetos.readObject());
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

        return vagonesData;
    }

    private int getIndexVagon(int idVagon) {
        int index = -1;

        for (int i = 0; i < vagones.size() && index == -1; i++) {
            if (vagones.get(i).getIdVagon() == idVagon) {
                index = i;
            }
        }

        return index;
    }

    private boolean siExisteFichero() {
        return FICHERO.exists();
    }

}
