/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author alumno
 */
public class Funcionario {

    private final String idFuncionario;
    private final String dni;
    private final String nombre;
    private final String provincia;
    private final int edad;

    public Funcionario(String idFuncionario, String dni, String nombre, String provincia, int edad) {
        this.idFuncionario = idFuncionario;
        this.dni = dni;
        this.nombre = nombre;
        this.provincia = provincia;
        this.edad = edad;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getEdad() {
        return edad;
    }

}
