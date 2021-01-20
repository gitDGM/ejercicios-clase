/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class UsoPerro {
    public static void main(String[] args) {
        Perro chiuahua = new Perro('a', 2);
        
        System.out.println("Edad del chiguagua: " + chiuahua.getEdad());
        chiuahua.envejecer();
        System.out.println("El chiguagua ha envejecido un año.");
        System.out.println("Edad del chiguagua: " + chiuahua.getEdad());
        
        int years = 5;
        chiuahua.envejecer(years);
        System.out.println("El chiguagua ha envejecido " + years + " años.");
        System.out.println("Edad del chiguagua: " + chiuahua.getEdad());
    }       
}
