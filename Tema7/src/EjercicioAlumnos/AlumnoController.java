/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioAlumnos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class AlumnoController {
    private static final File FICHERO = new File("src/EjercicioAlumnos/matriculas_alumnos.txt");
    private final ArrayList<Alumno> alumnos;

    public AlumnoController() {
        alumnos = new ArrayList();
        if (FICHERO.exists()) {
            leerAlumnosDeFichero();
        }
    }
    
    public int getIndexAlumno(int idAlumno) {
        int index = -1;
        
        for (int i = 0; i < alumnos.size() && index == -1; i++) {
            if (alumnos.get(i).getIdAlumno() == idAlumno) {
                index = i;
            }
        }
        
        return index;
    } 
    
    public boolean siExisteAlumno(int idAlumno) {
        boolean existe = false;
        
        if (alumnos.size() > 0) {
            existe = getIndexAlumno(idAlumno) != -1;
        }
        
        return existe;
    }
    
    public void mostrarAlumnos() {
        for (Alumno alumno : alumnos) {
            alumno.mostrar();
        }
    }
    
    private void leerAlumnosDeFichero() {      
        String alumnosData = ficheroToString();
        
        for (String alumnoData : alumnosData.split("\n")) {
            String[] alumnoDataArray = alumnoData.split(";");
            
            
            int idAlumno = Integer.parseInt(alumnoDataArray[0]);
            
            if (!siExisteAlumno(idAlumno)) {
                int curso = Integer.parseInt(alumnoDataArray[1]);
                
                ArrayList<Matricula> matriculas = new ArrayList();
                ArrayList<Integer> notasMatricula = new ArrayList();
                
                for(int i = 2; i < alumnoDataArray.length; i++) {
                    notasMatricula.add(Integer.parseInt(alumnoDataArray[i]));
                }
                
                matriculas.add(new Matricula(curso, getMediaNotas(notasMatricula)));
                
                alumnos.add(new Alumno(idAlumno, matriculas));
            } else {
                int indexAlumno = getIndexAlumno(idAlumno);                
                int curso = Integer.parseInt(alumnoDataArray[1]);
                
                ArrayList<Integer> notasMatricula = new ArrayList();                
                for(int i = 2; i < alumnoDataArray.length; i++) {
                    notasMatricula.add(Integer.parseInt(alumnoDataArray[i]));
                }
                
                alumnos.get(indexAlumno).getMatriculas().add(new Matricula(curso, getMediaNotas(notasMatricula)));
                
            }
        }
    }
    
    private double getMediaNotas(ArrayList<Integer> notas) {
        double media = 0;
        
        for (int nota : notas) {
            media += nota;
        }
        
        return media / (double) notas.size();
    }
    
    private String ficheroToString() {
        
        String texto = "";        
        FileReader filereader = null;
        BufferedReader lector = null;
        
        try {
            
            filereader = new FileReader(FICHERO);
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
        
        return texto;
    }    
}
