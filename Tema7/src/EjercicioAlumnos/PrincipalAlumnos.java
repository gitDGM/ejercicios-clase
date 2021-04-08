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
public class PrincipalAlumnos {
    public static void main(String[] args) {
        AlumnoController controladorAlumnos = new AlumnoController();
        
        controladorAlumnos.mostrarAlumnos();
        //controladorAlumnos.guardarDatosEnFicheroBinario();
    }
}
