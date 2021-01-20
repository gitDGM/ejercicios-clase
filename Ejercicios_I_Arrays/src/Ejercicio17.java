/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio17 {
    final static int FILAS = 30;
    final static int COLUMNAS = 5;
    
    public static void main(String[] args) {
        int[][] notas = new int[FILAS][COLUMNAS];
        notas = rellenarArray(notas);
        
        mostrarDatosAsignaturas(notas);
        mostrarDatosAlumnos(notas);
    }    
    
    /* FUNCIONES DE ALUMNOS */ 
    
    static int[] contarAprobadosAlumnos(int[][] notas) {
        int[] aprobados = new int[notas.length];
        
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] >= 5) {
                    aprobados[i] += 1;
                }
            }
        }
        
        return aprobados;
    }
    
    static int[] contarSuspensosAlumnos(int[][] notas) {
        int[] suspensos = new int[notas.length];
        
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] < 5) {
                    suspensos[i] += 1;
                }
            }
        }
        
        return suspensos;
    }
    
    static double[] mediaNotasAlumnos(int[][] notas) {
        double[] mediasAlumnos = new double[notas.length];
        
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                mediasAlumnos[i] += notas[i][j];
            }            
        }
        
        for (int i = 0; i < mediasAlumnos.length; i++) {
            mediasAlumnos[i] /= (double)notas[i].length;
        }
        
        return mediasAlumnos;
    }   
    
    static void mostrarDatosAlumnos(int[][] notas) {
        double[] mediaAlumnos = mediaNotasAlumnos(notas);
        int[] aprobadosAlumnos = contarAprobadosAlumnos(notas);
        int[] suspensosAlumnos = contarSuspensosAlumnos(notas);
        
        for (int i = 0; i < notas.length; i++) {
            System.out.println("");
            System.out.println("####### Alumno " + (i + 1) + " #######");
            System.out.println("Aprobados:\t" + aprobadosAlumnos[i]);
            System.out.println("Suspensos:\t" + suspensosAlumnos[i]);
            System.out.println("Media:\t\t" + mediaAlumnos[i]);
            System.out.println("#########################");
        } 
    }   
    
    /* FUNCIONES DE ASIGNATURAS */
    
    static int[] contarAprobadosAsignaturas(int[][] notas) {
        int[] aprobados = new int[notas[0].length];
        
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] >= 5) {
                    aprobados[j] += 1;
                }
            }
        }
        
        return aprobados;
    }
    
    static int[] contarSuspensosAsignaturas(int[][] notas) {
        int[] suspensos = new int[notas[0].length];
        
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] < 5) {
                    suspensos[j] += 1;
                }
            }
        }
        
        return suspensos;
    }
    
    static double[] mediaNotasAsignaturas(int[][] notas) {
        double[] mediasAsignaturas = new double[notas[0].length];
        
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                mediasAsignaturas[j] += notas[i][j];
            }            
        }
        
        for (int i = 0; i < mediasAsignaturas.length; i++) {
            mediasAsignaturas[i] /= (double)notas.length;
        }
        
        return mediasAsignaturas;
    }
    
    static void mostrarDatosAsignaturas(int[][] notas){
        double[] mediasAsignaturas = mediaNotasAsignaturas(notas);
        int[] aprobadosAsignaturas = contarAprobadosAsignaturas(notas);
        int[] suspensosAsignaturas = contarSuspensosAsignaturas(notas);
        mostrarArray2D(notas);
        for (int i = 0; i < notas[i].length; i++) {
            System.out.println("");
            System.out.println("###### Asignatura " + (i + 1) + " ######");
            System.out.println("Aprobados:\t" + aprobadosAsignaturas[i]);
            System.out.println("Suspensos:\t" + suspensosAsignaturas[i]);
            System.out.println("Media:\t\t" + mediasAsignaturas[i]);
            System.out.println("##########################");
        }        
    }
    
    /* FUNCIONES GENERALES */    
    
    static int[][] rellenarArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 10);
            }
        }
        return array;
    }
    
    static void mostrarArray1D(int[] array) {
        for (int i = 0; i < array.length; i++) {            
            System.out.print(array[i] + "\t");
        }        
        System.out.println();
    }
    
    static void mostrarArray1D(double[] array) {
        for (int i = 0; i < array.length; i++) {            
            System.out.print(array[i] + "\t");
        }        
        System.out.println();
    }
    
    static void mostrarArray2D(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
}
