import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class RepasoAntesExamen {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        String[][] cadenasAlAzar = new String[8][8];
        boolean inicializado = false;
        do {
            System.out.println("#######################"); 
            System.out.println("1. Almacenar cadenas en el array");
            System.out.println("2. Mostrar cadena diciendo su posición");
            System.out.println("3. Borrar cadena diciendo su posición");
            System.out.println("4. Salir");
            System.out.println("#######################");
            System.out.println("Elige una opción: ");         
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    //almacenarCaracteresAlAzar(ARRAY, LongitudMinima, LogitudMaxima)       
                    cadenasAlAzar = almacenarCaracteresAlAzar(cadenasAlAzar, 8, 16);
                    inicializado = true;
                    //mostrarArray2D(cadenasAlAzar);
                    //contarCaracteresArray(cadenasAlAzar);
                    break;
                case 2:
                    try {
                        mostrarPosicionArrayPorUsuario(cadenasAlAzar, inicializado);
                    } catch (Exception e) {
                        System.err.println("ATENCIÓN: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        cadenasAlAzar = borrarElementoArrayPosicionPorUsuario(cadenasAlAzar, inicializado);
                    } catch (Exception e) {
                        System.err.println("ATENCIÓN: " + e.getMessage());
                    }    
                    //mostrarArray2D(cadenasAlAzar);
                    break;
                case 4:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.err.println("Has introducido un valor fuera de rango.");
                    break;
            }
        } while(opcion != 4);
    }
    
    /* FUNCIÓN PARA LA OPCION 1 */
    
    static String[][] almacenarCaracteresAlAzar(String[][] matriz, int longitudMin, int longitudMax) {
        String[] caracteres = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz".split("");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int longitudCadena = (int)(Math.random() * (longitudMax - longitudMin + 1) + longitudMin);
                matriz[i][j] = "";
                for (int k = 0; k < longitudCadena; k++) {
                    int caracterAleatorio = (int)(Math.random() * (caracteres.length - 1));
                    matriz[i][j] += caracteres[caracterAleatorio];
                }
            }
        }
        
        return matriz;
    }
    
    /* FUNCIÓN PARA LA OPCION 2 */
    
    static void mostrarPosicionArrayPorUsuario(String[][] matriz, boolean flagInicializado) throws Exception {
        if (!flagInicializado) {
            throw new Exception("Debes almacenar cadenas antes de usar esta opción.");
        } else {
            int fila, columna;            
  
            /* OBTENER FILA */
            do {
                System.out.println("Introduce el valor de la fila (1-" + matriz.length +"):");
                fila = sc.nextInt();
                if (fila <= 0 || fila > matriz.length) {
                    System.err.println("ALERTA: Fuera de rango, prueba otra vez.");
                }
            } while(fila <= 0 || fila > matriz.length);
            
            /* OBTENER COLUMNA */
            do {
                System.out.println("Introduce el valor de la columna (1-" + matriz[0].length +"):");
                columna = sc.nextInt();
                if (columna <= 0 || columna > matriz[0].length) {
                    System.err.println("ALERTA: Fuera de rango, prueba otra vez.");
                }
            } while(columna <= 0 || columna > matriz[0].length);
            
            System.out.println("Cadena en la fila " + fila + " y columna " + columna + " es: " + matriz[fila - 1][columna - 1]);
        }
    }
    
    /* FUNCIÓN PARA LA OPCION 3 */
    
    static String[][] borrarElementoArrayPosicionPorUsuario(String[][] matriz, boolean flagInicializado) throws Exception{
        if (!flagInicializado) {
            throw new Exception("Debes almacenar cadenas antes de usar esta opción.");
        } else {
            int fila, columna;
            
            /* OBTENER FILA */
            do {
                System.out.println("Introduce el valor de la fila (1-" + matriz.length +"):");
                fila = sc.nextInt();
                if (fila <= 0 || fila > matriz.length) {
                    System.err.println("ALERTA: Fuera de rango, prueba otra vez.");
                }
            } while(fila <= 0 || fila > matriz.length);
            
            /* OBTENER COLUMNA */
            do {
                System.out.println("Introduce el valor de la columna (1-" + matriz[0].length +"):");
                columna = sc.nextInt();
                if (columna <= 0 || columna > matriz[0].length) {
                    System.err.println("ALERTA: Fuera de rango, prueba otra vez.");
                }
            } while(columna <= 0 || columna > matriz[0].length);
            
            matriz[fila - 1][columna - 1] = null;
        }
        
        return matriz;        
    }
    
    /* FUNCIONES PARA PROBAR */
    
    static void mostrarArray1D(String[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i] + "\t");
        }
    }
    
    static void mostrarArray2D(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.print("\n\n");
        }
    }
    
    static void contarCaracteresArray(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j].length() + "\t");
            }
            System.out.print("\n\n");
        }
    }
}
