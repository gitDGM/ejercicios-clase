/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author alumno
 */
public class Test {
    public static void main(String[] args) {
        
        Fichero fichero = new Fichero("src/test/equipos.txt");
        
        
        String[] equiposLineas = fichero.convertToArrayLineas();
        
        String[] equipos = new String[equiposLineas.length];
        
        for (int i = 0; i < equiposLineas.length; i++) {
            equipos[i] = equiposLineas[i].split(":")[1];
        }
        
        for (int i = 0; i < equipos.length; i++) {
            for (int k = 0; k < equipos.length; k++) {
                if (i != k) {
                    int golesLocal = (int)(Math.random() * 5);
                    int golesVisitante = (int)(Math.random() * 5);
                    System.out.println(equipos[i] + ":" + equipos[k] + ":" + golesLocal + ":" + golesVisitante);
                    
                }
            }
        }
        
    }
        /*
        for (int i = 0; i < 500; i++) {
            System.out.println(i + " - " + (char)i  );
        }
        while (true) {   
            int num = (int) (Math.random() * 101);
            if (num == 0 || num == 100) {
                System.out.println(num);
            }
        }
    }
*/
}
// Letras: (minus) 97 - 122 // (mayus) 65 - 90

// Numeros: 48 - 57