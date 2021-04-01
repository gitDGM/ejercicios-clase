/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio12;

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
public class AplicacionClientes {

    private ArrayList<Cliente> clientes;

    public AplicacionClientes() {
        this.clientes = new ArrayList();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente clienteNuevo) {
        clientes.add(clienteNuevo);
    }

    public void removeCliente(int idCliente) {
        int indexCliente = buscarClientePorID(idCliente);
        if (indexCliente != -1) {
            clientes.remove(indexCliente);
        } else {
            System.err.println("ERROR: No existe un cliente con ese ID.");
        }
    }

    public void mostrarClientes() {
        System.out.println("id_cliente\tNombre\tTelefono");
        for (Cliente cliente : clientes) {
            cliente.mostrar();
        }
    }

    public void modificarNombreCliente(int idCliente, String nombre) {
        int indexCliente = buscarClientePorID(idCliente);
        if (indexCliente != -1) {
            clientes.get(indexCliente).setNombre(nombre);
        } else {
            System.err.println("ERROR: No existe un cliente con ese ID.");
        }
    }

    public void modificarTelefonoCliente(int idCliente, String telefono) {
        int indexCliente = buscarClientePorID(idCliente);
        if (indexCliente != -1) {
            clientes.get(indexCliente).setTelefono(telefono);
        } else {
            System.err.println("ERROR: No existe un cliente con ese ID.");
        }
    }

    public boolean buscarSiExiste(int idCliente) {
        return buscarClientePorID(idCliente) != -1;
    }
    
    public boolean siHayClientes() {
        return clientes.size() > 0;
    }
    
    public void cargarClientesDesdeFicheroBinario() {
        File fichero = new File("src/EjerciciosBinarios/Ejercicio12/clientes.dat");
        
        if (fichero.exists()) {
            ObjectInputStream flujoEntrada = null;    
            
            try {        
                flujoEntrada = new ObjectInputStream(new FileInputStream(fichero));
                clientes = (ArrayList<Cliente>) flujoEntrada.readObject();
            } catch (FileNotFoundException ex) {
                System.err.println("Error!!! El fichero no existe.");
            } catch (IOException | ClassNotFoundException ex) {
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
        }
    }
    
    public void guardarClientesEnFicheroBinario() {
        File fichero = new File("src/EjerciciosBinarios/Ejercicio12/clientes.dat");
        ObjectOutputStream flujoSalida = null;
        
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(fichero));
            flujoSalida.writeObject(clientes);
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if(flujoSalida != null) {
                    flujoSalida.close();
                } 
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
    }

    private int buscarClientePorID(int idCliente) {
        int index = -1;
        
        for (int i = 0; i < clientes.size() && index == -1; i++) {
            if (clientes.get(i).getId() == idCliente) {
                index = i;
            }
        }

        return index;
    }
}
