/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.Ejercicio3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 *
 * @author alumno
 */
public class NumerosController {
    private static final int N_NUMS = 10;
    private final TreeSet<Integer> arbolNumeros;
    private final HashSet<Integer> hashNumeros;
    private final LinkedHashSet<Integer> linkedHashNumeros;
    
    public NumerosController() {
        arbolNumeros = new TreeSet();
        hashNumeros = new HashSet();
        linkedHashNumeros = new LinkedHashSet();
        
        for (int i = 0; i < N_NUMS; i++) {
            addNumero(generarNumero());
        }
    }
    
    public void renovarNumeros() {
        vaciarEstructuras();
        for (int i = 0; i < N_NUMS; i++) {
            addNumero(generarNumero());
        }
    }
    
    public void mostrarArbol() {
        System.out.println("\n\n#### Estructura TreeSet ####\n");
        Iterator<Integer> it = arbolNumeros.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
        System.out.println("\n");
    }
    
    public void mostrarHash() {
        System.out.println("\n\n#### Estructura HashSet ####\n");
        Iterator<Integer> it = hashNumeros.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
        System.out.println("\n");
    }
    
    public void mostrarLinkedHash() {
        System.out.println("\n\n#### Estructura LinkedHashSet ####\n");
        Iterator<Integer> it = linkedHashNumeros.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
        System.out.println("\n");
    }
    
    private void addNumero(int numero) {
        arbolNumeros.add(numero);
        hashNumeros.add(numero);
        linkedHashNumeros.add(numero);
    }
    
    private int generarNumero() {
        
        ////
        // NO ES NECESARIO PORQUE LA PROPIA CLASE NO PERMITE DUPLICADOS
        /*         
        int numero;
        
        do {            
            numero = (int) (Math.random() * 100);
        } while (checkNum(numero));
        */     
        ////
        
        
        
        return (int) (Math.random() * 100);
    }
    
    private void vaciarEstructuras() {
        arbolNumeros.clear();
        hashNumeros.clear();
        linkedHashNumeros.clear();
    }
    
    
    ////
    // NO ES NECESARIO PORQUE LA PROPIA CLASE NO PERMITE DUPLICADOS
    /* 
    private boolean checkNum(int numero) {
        boolean existe = false;
        
        Iterator<Integer> it = linkedHashNumeros.iterator();
        while (it.hasNext() && !existe) {            
            existe = numero == it.next();
        }
        
        return existe;
    }
    */     
    ////
}
