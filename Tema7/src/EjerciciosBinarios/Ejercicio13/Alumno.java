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

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }
    
    public void mostrar() {
        int contador = 1;
        System.out.println(idMatricula + " - " + nombre + " " + apellidos);
        System.out.println("NOTAS:");
        for (int nota : notas) {
            System.out.println("Nota asignatura " + contador + ": " +  notas[contador - 1]);
            contador++;
        }
    }
}
