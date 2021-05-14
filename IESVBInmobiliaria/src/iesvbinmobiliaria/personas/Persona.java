/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria.personas;

/**
 *
 * @author alumno
 */
public class Persona {

    private final int idPersona;
    private final String nombre;
    private final String apellidos;
    private final String dni;
    private String telefono;

    public Persona(int idPersona, String nombre, String apellidos, String dni, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
