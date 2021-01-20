
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio20 {
    final static int TAM_ALBUM = 50;
    public static void main(String[] args) {
        
        class Cromo {
            int id_cromo;
            int cantidad = 0;
            boolean conseguido = false;
            
            public Cromo(int id_cromo) {
                this.id_cromo = id_cromo;
            }
        }
        
        Cromo[] cromos = new Cromo[TAM_ALBUM];
        int cromosComprados = 0;
        
        for (int i = 0; i < cromos.length; i++) {
            cromos[i] = new Cromo(i + 1);
        }
        
        boolean[] cromosConseguidos = new boolean[TAM_ALBUM];
        Arrays.fill(cromosConseguidos, false);
        
        while (!comprobarSiCompletado(cromosConseguidos)) {
            int cromoObtenido = (int)(Math.random() * TAM_ALBUM + 1);
            
            cromos[cromoObtenido - 1].cantidad++;
            //System.out.println(cromos[cromoObtenido - 1].conseguido);
            if (!cromos[cromoObtenido - 1].conseguido) {
                cromos[cromoObtenido - 1].conseguido = !cromos[cromoObtenido - 1].conseguido;
                cromosConseguidos[cromoObtenido - 1] = cromos[cromoObtenido - 1].conseguido;
            }
            
            //System.out.println((cromoObtenido - 1) + " - " + cromos[cromoObtenido - 1].conseguido);
            cromosComprados++;
            //System.out.println(cromosComprados);
        }       
        
        for (int i = 0; i < cromos.length; i++) {
            System.out.println("ID Cromo: " + cromos[i].id_cromo + "\t|| Veces repetido: " + cromos[i].cantidad);
        }
        System.out.println("##############################################");
        System.out.println("Cromos comprados: " + cromosComprados);
        System.out.println("##############################################");
    }
    
    static boolean comprobarSiCompletado(boolean[] cromosConseguidos) {
        int contador = 0;
        for (int i = 0; i < cromosConseguidos.length; i++) {
            if (cromosConseguidos[i]) {
                contador++;
            }
        }
        //System.out.println(contador);
        if (contador == cromosConseguidos.length) {
            return true;
        } else {
            return false;
        }
    }
}
