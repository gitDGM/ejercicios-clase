/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Buscaminas {
    private final int[][] tableroJuego;
    private final String[][] tableroJugador;
    private final int cantidadMinas;
    private int minasEncontradas;
    private boolean terminado;
    
    public Buscaminas(int ancho, int alto, int cantidadMinas) {
        tableroJuego = generarTableroJuego(ancho, alto, cantidadMinas);
        tableroJugador = generarTableroJugador(ancho, alto);
        this.cantidadMinas = cantidadMinas;
        minasEncontradas = 0;
        terminado = false;
    }

    public int[][] getTableroJuego() {
        return tableroJuego;
    }

    public int getCantidadMinas() {
        return cantidadMinas;
    }

    public int getMinasEncontradas() {
        return minasEncontradas;
    }

    public String[][] getTableroJugador() {
        return tableroJugador;
    }

    public boolean isTerminado() {
        return terminado;
    }
    
    public void setMinasEncontradas(int minasEncontradas) {
        this.minasEncontradas = minasEncontradas;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }
    
    public void fin() {
        this.terminado = true;
    }
    
    public void insertarCasilla(int posX, int posY) {
        this.tableroJugador[posY][posX] = "" + contarMinasAlrededor(posX, posY);
    }
    
    public void mostrarTableroJuego() {
        filaSuperior();
        for(int i = 0; i < tableroJuego.length; i++) {
            System.out.print(i + "\t");
            for (int k = 0; k < tableroJuego[i].length; k++) {
                System.out.print(tableroJuego[i][k] + " ");
            }
            System.out.println();
        }
    }
    
    public void mostrarTableroJugador() {
        filaSuperior();
        for(int i = 0; i < tableroJugador.length; i++) {
            System.out.print(i + "\t");
            for (int k = 0; k < tableroJugador[i].length; k++) {
                System.out.print(tableroJugador[i][k] + " ");
            }
            System.out.println();
        }
    }
    
    private int contarMinasAlrededor(int posX, int posY) {
        int minasAlrededor = 0;
        
        if (posY >= 1 && posX >= 1 && posY <= (tableroJuego.length - 2) && posX <= (tableroJuego[0].length - 2)) {
            if (tableroJuego[posY - 1][posX - 1] == 1) {
                minasAlrededor++;
            }
            if (tableroJuego[posY - 1][posX] == 1) {
                minasAlrededor++;
            }
            if (tableroJuego[posY - 1][posX + 1] == 1) {
                minasAlrededor++;
            }
            if (tableroJuego[posY][posX - 1] == 1) {
                minasAlrededor++;
            }
            if (tableroJuego[posY][posX + 1] == 1) {
                minasAlrededor++;
            }
            if (tableroJuego[posY + 1][posX - 1] == 1) {
                minasAlrededor++;
            } 
            if (tableroJuego[posY + 1][posX] == 1) {
                minasAlrededor++;
            }
            if (tableroJuego[posY + 1][posX + 1] == 1) {
                minasAlrededor++;
            }
        }
        
        return minasAlrededor;
    }
    
    private int[][] generarTableroJuego(int ancho, int alto, int cantidadMinas) {
        int[][] tableroNuevo = new int[alto][ancho];
        
        for (int i = 0; i < cantidadMinas; i++) {
            int posX;
            int posY;
            do {                
                posX = (int) (Math.random() * ancho);
                posY = (int) (Math.random() * alto);                
            } while (tableroNuevo[posY][posX] == 1);            
            tableroNuevo[posY][posX] = 1;
        }
        
        return tableroNuevo;
    }
    
    private void filaSuperior() {        
        System.out.print("\t");
        for (int i = 0; i < tableroJuego[0].length; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    
    private String[][] generarTableroJugador(int ancho, int alto) {
        String[][] tableroNuevo = new String[alto][ancho];
        
        for (int i = 0; i < alto; i++) {
            for (int k = 0; k < ancho; k++) {
                tableroNuevo[i][k] = "o";
            }            
        }
        
        return tableroNuevo;
    }
}
