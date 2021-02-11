/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composicion.Ejercicio4y5;

/**
 *
 * @author alumno
 */
public class Etiqueta {
    private static int numEtiquetas = 0;
    private int idEtiqueta;
    private String destinatario;
    private String direccion;

    public Etiqueta(String destinatario, String direccion) {
        idEtiqueta = numEtiquetas + 1;
        this.destinatario = destinatario;
        this.direccion = direccion;
        numEtiquetas++;
    }
    
    public static int getNextID() {
        numEtiquetas++;
        return numEtiquetas;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getDireccion() {
        return direccion;
    }

    public static int getNumEtiquetas() {
        return numEtiquetas;
    }

    public int getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(int idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }  
}
