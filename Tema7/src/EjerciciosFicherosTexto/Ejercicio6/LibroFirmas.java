/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio6;


import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class LibroFirmas {
    private final ArrayList<Firma> firmas = new ArrayList();
    
    public void addFirma(String nombre) {
        if (!comprobarRepetido(nombre)) {
            firmas.add(new Firma(nombre));
        } else {
            System.err.println("ATENCIÓN: Firma repetida.");
        }
    }
    
    public void mostrar() {
        int index = 1;
        for (Firma firma : firmas) {
            System.out.println(index + ".- " + firma.getNombre());
            index++;
        }
    }
    
    private boolean comprobarRepetido(String nombre) {
        boolean repetido = false;
        
        for (int i = 0; i < firmas.size() && !repetido; i++) {
            repetido = firmas.get(i).getNombre().equals(nombre);
        }
        
        return repetido;
    }
}
