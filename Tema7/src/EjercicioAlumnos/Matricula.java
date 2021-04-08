/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioAlumnos;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Matricula implements Serializable {
    private static final long serialVersionUID = 22222L;
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
