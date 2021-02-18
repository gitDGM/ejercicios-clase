/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class EmpresaMain {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Empresa> empresas = new ArrayList();
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Crear una empresa o varias");
            System.out.println("2.- Crear empleado en empresa");
            System.out.println("3.- Eliminar empleado de empresa");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    addEmpresa();
                    mostrarEmpresas();
                    break;
                case 2:
                    addEmpleado(getIndexEmpresa());
                    break;
                case 3:
                    removeEmpleado(getIndexEmpresa());
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static void addEmpresa() {
        do {
            System.out.println("Introduce el CIF:");
            String cif = "V83244053";
            System.out.println("Introduce el nombre:");
            String nombre = "Empresa SA";
            System.out.println("Introduce el telefono:");
            String telefono = "";
            System.out.println("Introduce la dirección:");
            String direccion = "";
            
            empresas.add(new Empresa(cif, nombre, telefono, direccion, new ArrayList()));
            
        } while (elegirOpcionContinuar("Quieres añadir otra empresa? (S/N)"));
    }  
    
    static void addEmpleado(int indexEmpresa) {
        if (indexEmpresa != 0) {
            System.out.println("Introduce el DNI:");
            String dni = "12345678A";
            System.out.println("Introduce el nombre:");
            String nombre = "Diego";
            System.out.println("Introduce el salario:");
            double salario = 1500;
            System.out.println("Introduce la edad:");
            int edad = 22;
            System.out.println("Introduce la teléfono:");
            String telefono = "";
            System.out.println("Introduce la dirección:");
            String direccion = "";
            
            empresas.get(indexEmpresa).addEmpleado(new Empleado(dni, nombre, salario, edad, telefono, direccion));
        }
    }
    
    static void removeEmpleado(int indexEmpresa) {
        int indexEmpleado = getIndexEmpleado();
        if (indexEmpresa != 0 && indexEmpleado != 0) {
            empresas.get(indexEmpresa).getEmpleados().remove(indexEmpleado);
        }
    }
    
    static void mostrarEmpresas() {
        for (Empresa empresa : empresas) {
            empresa.mostrar();
        }
    }
    
    static int getIndexEmpleado() {
        int indexEmpleado;
        do {
            System.out.println("##########################");
            for (int i = 0; i < empresas.size(); i++) {
                System.out.println((i + 1) + ".- " + empresas.get(i).getEmpleados().get(i).getNombre());
            }        
            System.out.println("##########################");
            indexEmpleado = introducirNumero("Elige una opción:");

        } while (indexEmpleado < 0 && indexEmpleado > empresas.size());  
        
        if (indexEmpleado != 0) {
            indexEmpleado -= 1;
        }
        
        return indexEmpleado;
    }
    
    static int getIndexEmpresa() {
        int indexEmpresa;
        do {
            System.out.println("##########################");
            for (int i = 0; i < empresas.size(); i++) {
                System.out.println((i + 1) + ".- " + empresas.get(i).getNombre());
            }
            System.out.println("0.- Salir");
            System.out.println("##########################");
            indexEmpresa = introducirNumero("Elige una opción:");
            
        } while (indexEmpresa < 0 && indexEmpresa > empresas.size()); 
        
        if (indexEmpresa != 0) {
            indexEmpresa -= 1;
        }
        
        return indexEmpresa;
    }
    
    static boolean tieneEmpleados(int indexEmpresa) {
        boolean tieneEmpleados = false;
        if (empresas.get(indexEmpresa).getEmpleados().size() > 0) {
            tieneEmpleados = true;
        }
        return tieneEmpleados;
    }
    
    static boolean elegirOpcionContinuar(String msg) {
        boolean opcion = true; 
        boolean noValido;
        
        do {
            System.out.println(msg);
            char letra = sc.next().charAt(0);
            
            switch (Character.toUpperCase(letra)) {
                case 'N':
                    opcion = false;
                    noValido = false;
                    break;
                case 'S':
                    opcion = true;
                    noValido = false;
                    break;
                default:
                    System.err.println("Opción no valida.");
                    noValido = true;
                    break;
            }
        } while (noValido);     
        
        return opcion;
    }      
    
    static int introducirNumero(String msg) {
         int numero = 0;        
         boolean noValido;
         do {
             System.out.println(msg);
             try {
                 numero = sc.nextInt();
                 noValido = false;
             } catch (InputMismatchException ex) {
                 System.err.println("Debe ser un número decimal.");
                 noValido = true;
                 sc.next();
             }
         } while (noValido);

         return numero;
     }
}