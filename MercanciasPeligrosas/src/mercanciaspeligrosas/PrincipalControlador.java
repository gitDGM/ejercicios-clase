/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercanciaspeligrosas;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class PrincipalControlador {
    
    // ATRIBUTOS DE LA CLASE
    private static final int NIVEL_PELIGROSIDAD_MAX = 5;
    private final ArrayList<Camion> camiones;
    private final ArrayList<Mercancia> mercancias;

    // CONSTRUCTOR
    public PrincipalControlador() {
        // LEEMOS E INSTANCIAMOS LAS MERCANCIAS DEL FICHERO TXT
        this.mercancias = leerMercanciasDeFichero();
        // ORDENAMOS EL ARRAYLIST POR PELIGROSIDAD
        ordenarMercanciasPorPeligrosidad();
        
        // LEEMOS E INSTANCIAMOS LOS CAMIONES SEGÚN LAS MERCANCIAS QUE HEMOS OBTENIDO
        this.camiones = generarCamiones();
        // GENERAMOS EL FICHERO BINARIO CON LOS CAMIONES INSTANCIADOS
        escribirCamionesEnFicheroBinario();
    }
    
    // MÉTODO PARA MOSTRAR LOS CAMIONES OBTENIDOS DEL FICHERO BINARIO
    // Y MOSTRAR LA EL TOTAL A PAGAR DE LOS CAMIONES
    public void gestionarMercancias() {
        ArrayList<Camion> camionesBinarios = generarCamionesDesdeBinario();
        visualizarCamionesBinarios(camionesBinarios);
        System.out.println("######## FACTURA ########");
        generarFacturaCamiones(camionesBinarios);
        System.out.println("#########################");
    }
    
    // MÉTODO PARA VISUALIZAR EL TOTAL PAGAR DE UN ARRAYLIST
    // DE CAMIONES QUE PASAMOS POR PARÁMETROS
    public void generarFacturaCamiones(ArrayList<Camion> camionesParametro) {
        double totalPagar = 0;
        for (Camion camion : camionesParametro) {
            switch (camion.obtenerPeligrosidad()) {
                case 1:
                    totalPagar += 3000;
                    break;
                case 2:
                    totalPagar += 2800;
                    break;
                case 3:
                    totalPagar += 2500;
                    break;
                case 4:
                    totalPagar += 2000;
                    break;
                case 5:
                    totalPagar += 1750;
                    break;
            }
        }
        System.out.println("TOTAL A PAGAR: " + totalPagar + "€");
    }
    
    // MÉTODO PARA VISUALIZAR EL ATRIBUTO CAMIONES
    public void visualizarCamiones() {
        for (Camion camion : camiones) {
            camion.visualizar();
        }
    }
    
    // MÉTODO PARA VISUALIZAR EL ARRAYLIST DE CAMIONES QUE PASAMOS POR PARÁMETROS
    public void visualizarCamionesBinarios(ArrayList<Camion> camionesBinarios) {
        for (Camion camionBinario : camionesBinarios) {
            camionBinario.visualizar();
        }
    }
    
    // MÉTODO PARA VISUALIZAR EL ATRIBUTO MERCANCIAS
    public void visualizarMercancias() {
        for (Mercancia mercancia : mercancias) {
            mercancia.visualizar();
        }
    }
        
    
    // MÉTODO ORDENAR POR PELIGROSIDAD LAS MERCANCIAS
    private void ordenarMercanciasPorPeligrosidad() {              
        for (int i = 0; i < mercancias.size() - 1; i++) {
            for (int k = 0; k < mercancias.size() - 1 - i; k++) {
                if (mercancias.get(k).obtenerPeligrosidad() > mercancias.get(k + 1).obtenerPeligrosidad()) {
                    Mercancia temp = mercancias.get(k);
                    mercancias.set(k, mercancias.get(k + 1));
                    mercancias.set(k + 1, temp);
                }
            }
        }
    }
    
    // MÉTODO PARA OBTENER LOS OBJETOS DE LOS CAMIONES DEL FICHERO BINARIO    
    private ArrayList<Camion> generarCamionesDesdeBinario() {
        File ficheroBinario = new File("archivos/comboy.bin");
        ArrayList<Camion> camionesFicheroBinarios = new ArrayList();        
        ObjectInputStream flujoEntrada = null;
        
        try {        
            flujoEntrada = new ObjectInputStream(new FileInputStream(ficheroBinario));   
            while (true) {                
                camionesFicheroBinarios.add((Camion)flujoEntrada.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (EOFException ex) {
            // FIN DE FICHERO
        } catch (ClassNotFoundException | IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if(flujoEntrada != null) {
                    flujoEntrada.close();
                } 
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
        
        return camionesFicheroBinarios;
    } 
    
    
    // MÉTODO PARA INSTANCIAR LOS CAMIONES SEGÚN LAS MERCANCIAS 
    // QUE HEMOS OBTENIDO DEL FICHERO DE TEXTO
    private ArrayList<Camion> generarCamiones() {
        ArrayList<Camion> camionesGenerados = new ArrayList();        
        
        for (int i = 1; i <= NIVEL_PELIGROSIDAD_MAX; i++) {
            ArrayList<Mercancia> mercanciasCamion = new ArrayList();
            
            for (Mercancia mercancia : mercancias) {
                if (mercancia.obtenerPeligrosidad() == i) {
                    mercanciasCamion.add(mercancia);
                }
            }
            
            // COMPROBAR SI HAY MERCANCIAS DE CIERTA PELIGROSIDAD
            if (mercanciasCamion.size() > 0) {
                camionesGenerados.add(new Camion(i, mercanciasCamion, i));
            }
        }
        
        return camionesGenerados;
    }
    
    
    // MÉTODO PARA LEER E INSTANCIAR LAS MERCANCIAS OBTENIDAS
    // DEL FICHERO DE TEXTO
    private ArrayList<Mercancia> leerMercanciasDeFichero() {
        File fichero = new File("archivos/mercancias.txt");
        ArrayList<Mercancia> mercanciasFichero = new ArrayList();
        
        FileReader filereader = null;
        BufferedReader lector = null;
              
        try {
            filereader = new FileReader(fichero);
            lector = new BufferedReader(filereader);
            int cantidadMercancias = Integer.parseInt(lector.readLine());
            
            for (int i = 0; i < cantidadMercancias; i++) {
                String[] mercanciaData = lector.readLine().split(";");
                mercanciasFichero.add(new Mercancia(mercanciaData[0], Integer.parseInt(mercanciaData[1])));                
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
        
        return mercanciasFichero;
    }
    
    // MÉTODO PARA ESCRIBIR LOS OBJETOS DE LOS CAMIONES EN EL FICHERO BINARIO
    private void escribirCamionesEnFicheroBinario() {
        File ficheroBinario = new File("archivos/comboy.bin");
        ObjectOutputStream flujoObjetos = null;

        try {
            flujoObjetos = new ObjectOutputStream(new FileOutputStream(ficheroBinario));
            for (Camion camion : camiones) {
                flujoObjetos.writeObject(camion);
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
    
}
