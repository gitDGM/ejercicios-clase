/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioAlumnos;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Alumno {
    private final int idAlumno;
    private final ArrayList<Matricula> matriculas;

    public Alumno(int idAlumno, ArrayList<Matricula> matriculas) {
        this.idAlumno = idAlumno;
        this.matriculas = matriculas;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }
    
    public void mostrar() {
        System.out.println("ID Alumno: " + idAlumno);
        mostrarMatriculas();
    }
    
    private void mostrarMatriculas() {
        int contador = 1;
        System.out.println("Matriculas:");
        for (Matricula matricula : matriculas) {
            System.out.println("\tMatricula " + contador + " - Curso: " + matricula.getCurso() + " - " + matricula.getMedia());
            contador++;
        }        
    }
}
