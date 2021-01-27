/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio11;

/**
 *
 * @author alumno
 */
public class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    public Hora(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }
    
    public void mostarHora() {
        String str = "";
        if (this.hora < 10) {
            str += "0" + this.hora + ":";
        } else {
            str += this.hora + ":";
        }
        if (this.minuto < 10) {
            str += "0" + this.minuto + ":";
        } else {
            str += this.minuto + ":";
        }
        if (this.segundo < 10) {
            str += "0" + this.segundo;
        } else {
            str += this.segundo;
        }
        System.out.println("Hora: " + str);
    }
    
    public void avanzarUnSegundo() {
        if (this.segundo + 1 == 60) {
            this.segundo = 0;
            avanzarUnMinuto();
        } else {
            this.segundo++;
        }
    }
    
    private void avanzarUnMinuto() {
        if (this.minuto + 1 == 60) {
            this.minuto = 0;
            avanzarUnaHora();
        } else {
            this.minuto++;
        }
    }
    
    private void avanzarUnaHora() {
        if (this.hora + 1 == 24) {
            this.hora = 0;
        } else {
            this.hora++;
        }
    }
    
    public void retrocederUnSegundo() {
        if (this.segundo - 1 < 0) {
            this.segundo = 59;
            retrocederUnMinuto();
        } else {
            this.segundo--;
        }
    }
    
    private void retrocederUnMinuto() {
        if (this.minuto - 1 < 0) {
            this.minuto = 59;
            retrocederUnaHora();
        } else {
            this.minuto--;
        }
    }
    
    private void retrocederUnaHora() {
        if (this.hora - 1 < 0) {
            this.hora = 23;
        } else {
            this.hora--;
        }
    }
}
