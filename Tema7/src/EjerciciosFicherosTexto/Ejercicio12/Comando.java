/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class Comando {
    
    
    public boolean comp(File fichero1, File fichero2) {
        boolean iguales = true;
        
        try {
            String cadenaFichero1 = ficheroToString(fichero1);
            String cadenaFichero2 = ficheroToString(fichero2);             
            
            iguales = logicaComp(cadenaFichero1, cadenaFichero2);
            
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        
        
        return iguales;
    }
    
    private boolean logicaComp(String fichero1, String fichero2) {
        boolean iguales = true;
        int cantidadLetrasFichero1 = 0;
        int cantidadLetrasFichero2 = 0;
        
        String[] lineasFichero1 = fichero1.split("\n");
        String[] lineasFichero2 = fichero2.split("\n");        
        
        for (int i = 0; i < lineasFichero1.length && iguales; i++) {
            
            String[] palabrasLineaFichero1 = lineasFichero1[i].split(" ");
            String[] palabrasLineaFichero2 = lineasFichero2[i].split(" ");
            
            for (int j = 0; j < palabrasLineaFichero1.length && iguales; j++) {
                
            String[] letrasPalabraFichero1 = palabrasLineaFichero1[j].split("");
            String[] letrasPalabraFichero2 = palabrasLineaFichero2[j].split("");
                
                for (int k = 0; k < letrasPalabraFichero1.length && iguales; k++) {
                    cantidadLetrasFichero1 += letrasPalabraFichero1.length;
                    cantidadLetrasFichero2 += letrasPalabraFichero2.length;   
                    iguales = letrasPalabraFichero1[k].equals(letrasPalabraFichero2[k]);
                    if (!iguales) {
                        System.out.println("DIFERENCIA ENCONTRADA EN:");
                        System.out.println("LINEA: " + (i + 1));
                        System.out.println("PALABRA: " + (j + 1));
                        System.out.println("CARACTER: " + (k + 1) + "\n");
                    }
                }
            }
        }        
        
        iguales = cantidadLetrasFichero1 == cantidadLetrasFichero2;
        
        
        
        return iguales;
    }
    
    private String ficheroToString(File fichero) throws Exception {
        
        String texto = ""; 
        if (fichero.exists()) {
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
                    if (filereader != null) filereader.close();
                    if (lector != null) lector.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                    
                }
            }       
        } else {
            throw new Exception("El archivo no existe.");
        }
        
        return texto;
    }
}
