/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio19 {
    final static int CANTIDAD_BOLAS = 10;
    public static void main(String[] args) {
        
        /* CLASE BOLA */    
        class Bola {
            int numero;
            int vecesSacada;
            
            public Bola(int numero) {
                this.numero = numero;
                vecesSacada = 0;
            }
        }        
        Bola[] bolas = new Bola[CANTIDAD_BOLAS];    
        
        
        /* INICIALIZAR BOLAS */
        for (int i = 0; i < 10; i++) {
            bolas[i] = new Bola(i + 1);
        }
        
        int[] vecesBolas = new int[CANTIDAD_BOLAS];
        while (comprobarVeces5(vecesBolas)) {            
            int bolaSacada = (int)(Math.random() * 10 + 1);
            
            for (int i = 0; i < 10; i++) {
                if (bolaSacada == bolas[i].numero) {
                    bolas[i].vecesSacada++;
                }
                vecesBolas[i] = bolas[i].vecesSacada;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Bola " + (i + 1) + "\t|| Veces: " + bolas[i].vecesSacada);
        }
    }
    
    static boolean comprobarVeces5(int[] vecesBolas) {        
        if (vecesBolas[4] == 3) {
            return false;
        } else {
            return true;
        }
    }
    
    
}
