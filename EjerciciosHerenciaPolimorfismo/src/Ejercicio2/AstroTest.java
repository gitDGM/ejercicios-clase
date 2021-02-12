/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class AstroTest {
    
    private static ArrayList<Astro> astros = new ArrayList<Astro>();
    public static void main(String[] args) {
        double radioEcuatorial = 2000;
        double rotacionSobreEje = 30;     
        double masa = 3000;        
        double temperatura = 25;      
        double gravedad = 10;   
        double distanciaSol = 3000;
        double orbitaSol = 3000;        
        double distanciaPlaneta = 3000;      
        double orbitaPlanetaria = 3000;  
        
        
        Planeta p1 = new Planeta("Tierra", distanciaSol, orbitaSol, radioEcuatorial, rotacionSobreEje, masa, temperatura, gravedad);  
        p1.muestra();
        
        ///
        Satelite s1 = new Satelite("Luna", distanciaPlaneta, orbitaPlanetaria, p1, radioEcuatorial, rotacionSobreEje, masa, temperatura, gravedad);
        
        s1.muestra();
        p1.muestra();
        
    }
}
