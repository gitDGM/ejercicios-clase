/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio13;

/**
 *
 * @author 0017610
 */
public class Alumno {
    private int idMatricula;
    private String nombre;
    private String apellidos;
    private int[] notas;

    public Alumno(int idMatricula, String nombre, String apellidos, int[] notas) {
        this.idMatricula = idMatricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.notas = notas;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int[] getNotas() {
        return notas;
    }
     
    
    
}
