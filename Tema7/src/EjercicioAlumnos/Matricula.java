/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioAlumnos;

/**
 *
 * @author alumno
 */
public class Matricula {
    private int curso;
    private double media;

    public Matricula(int curso, double media) {
        this.curso = curso;
        this.media = media;
    }

    public int getCurso() {
        return curso;
    }

    public double getMedia() {
        return media;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
