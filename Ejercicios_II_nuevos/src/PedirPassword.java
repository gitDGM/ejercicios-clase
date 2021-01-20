/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class PedirPassword {
    public static void main(String[] args) {
        String user = "diego";
        String password = "test";
        String userInput;
        String passwordInput;
        String [] arrUser;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce usuario: ");
        userInput = sc.nextLine();
        System.out.print("Introduce contraseña: ");
        passwordInput = sc.nextLine();
        if (password.equals(passwordInput) && user.equals(userInput)) {
            System.out.println("Dentro");
        }
    }
}
