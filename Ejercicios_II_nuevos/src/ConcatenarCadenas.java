

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
/**
 *
 * @author alumno
 */
public class ConcatenarCadenas {
    public static void main(String[] args) {
        String str1 = "Desarrollo";
        String str2 = "Web";
        String str3 = str1.concat(str2);
        System.out.println(str3); 
        
        String str4 = str1 + str2;       
        System.out.println(str4.toUpperCase());
        
    }   
}
