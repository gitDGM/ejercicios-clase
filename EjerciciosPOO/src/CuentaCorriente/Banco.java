/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CuentaCorriente;

/**
 *
 * @author alumno
 */
public class Banco {
    private String nombre;
    private int capital;
    private String direccion;

    public Banco(String nombre, String direccion) {
        this.nombre = nombre;
        this.capital = 5200000;
        this.direccion = direccion;
    }
    
    public Banco(String nombre, int capital, String direccion) {
        this.nombre = nombre;
        this.capital = capital;
        this.direccion = direccion;        
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapital() {
        return capital;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
