/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alumno
 */
public class FechaHora {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;
    private int seconds;
    
    
    // CONSTRUCTOR DE FECHA ACTUAL
    public FechaHora() {
        LocalDateTime fechaActual = LocalDateTime.now();
        year = fechaActual.getYear();
        month = fechaActual.getMonthValue();
        day = fechaActual.getDayOfMonth();
        hour = fechaActual.getHour();
        minutes = fechaActual.getMinute();
        seconds = fechaActual.getSecond();
    }
    
    
    // CONSTRUCTOR DE FECHA ALEATORIA ENTRE DOS AÑOS
    public FechaHora(int yearMin, int yearMax) {
        year = generarYearAleatorio(yearMin, yearMax);
        month = generarMonthAleatorio();
        day = generarDayAleatorio(this.month, this.year);
        hour = generarHoraAleatorio();
        minutes = generarMinutoAleatorio();
        seconds = generarSegundoAleatorio();
        
    }
    
    // CONSTRUCTOR DE FECHA DADA COMO STRING Y CON SU FORMATO
    public FechaHora(String fechaString, String formato) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime fecha = LocalDateTime.parse(fechaString, formateador);    
        
        year = fecha.getYear();
        month = fecha.getMonthValue();
        day = fecha.getDayOfMonth();
        hour = fecha.getHour();
        minutes = fecha.getMinute();
        seconds = fecha.getSecond();
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getFechaFormato(String formato) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime fecha = LocalDateTime.of(this.year, this.month, this.day, this.hour, this.minutes, this.seconds);

        return fecha.format(formateador);
    }

    public void avanzarYears(int years) {
        LocalDateTime fecha = LocalDateTime.of(this.year, this.month, this.day, this.hour, this.minutes, this.seconds);
        fecha = fecha.plusYears(years);
        this.year = fecha.getYear();
    }

    public void avanzarMonths(int months) {
        LocalDateTime fecha = LocalDateTime.of(this.year, this.month, this.day, this.hour, this.minutes, this.seconds);
        fecha = fecha.plusMonths(months);
        this.year = fecha.getYear();
        this.month = fecha.getMonthValue();
    }

    public void avanzarDays(int days) {
        LocalDateTime fecha = LocalDateTime.of(this.year, this.month, this.day, this.hour, this.minutes, this.seconds);
        fecha = fecha.plusDays(days);
        this.year = fecha.getYear();
        this.month = fecha.getMonthValue();
        this.day = fecha.getDayOfMonth();
    }

    public void avanzarHora(int hours) {
        LocalDateTime fecha = LocalDateTime.of(this.year, this.month, this.day, this.hour, this.minutes, this.seconds);
        fecha = fecha.plusHours(hours);
        this.year = fecha.getYear();
        this.month = fecha.getMonthValue();
        this.day = fecha.getDayOfMonth();
        this.hour = fecha.getHour();
    }

    public void avanzarMinutos(int minutes) {
        LocalDateTime fecha = LocalDateTime.of(this.year, this.month, this.day, this.hour, this.minutes, this.seconds);
        fecha = fecha.plusMinutes(minutes);
        this.year = fecha.getYear();
        this.month = fecha.getMonthValue();
        this.day = fecha.getDayOfMonth();
        this.hour = fecha.getHour();
        this.minutes = fecha.getMinute();
    }

    public void avanzarSegundos(int seconds) {
        LocalDateTime fecha = LocalDateTime.of(this.year, this.month, this.day, this.hour, this.minutes, this.seconds);
        fecha = fecha.plusSeconds(seconds);
        this.year = fecha.getYear();
        this.month = fecha.getMonthValue();
        this.day = fecha.getDayOfMonth();
        this.hour = fecha.getHour();
        this.minutes = fecha.getMinute();
        this.seconds = fecha.getSecond();
    }

    @Override
    public String toString() {

        return this.day + "-" + this.month + "-" + this.year + " " + this.hour + ":" + this.minutes + ":" + this.seconds;
    }

    private static int generarYearAleatorio(int yearMin, int yearMax) {
        
        if (yearMin > yearMax) {
            int temp = yearMin;
            yearMin = yearMax;
            yearMax = temp;
        }
        
        int year = (int) ((Math.random() * (yearMax - yearMin + 1) + yearMin));

        return year;
    }

    private static int generarMonthAleatorio() {
        int month = (int) (Math.random() * (12 - 1 + 1) + 1);

        return month;
    }

    private static int generarDayAleatorio(int month, int year) {
        int day = 0;
        switch (month) {
            case 1:
                day = (int) (Math.random() * (31 - 1 + 1) + 1);
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0) {
                    day = (int) (Math.random() * (29 - 1 + 1) + 1);
                } else {
                    day = (int) (Math.random() * (28 - 1 + 1) + 1);
                }
                break;
            case 3:
                day = (int) (Math.random() * (31 - 1 + 1) + 1);
                break;
            case 4:
                day = (int) (Math.random() * (30 - 1 + 1) + 1);
                break;
            case 5:
                day = (int) (Math.random() * (31 - 1 + 1) + 1);
                break;
            case 6:
                day = (int) (Math.random() * (30 - 1 + 1) + 1);
                break;
            case 7:
                day = (int) (Math.random() * (31 - 1 + 1) + 1);
                break;
            case 8:
                day = (int) (Math.random() * (31 - 1 + 1) + 1);
                break;
            case 9:
                day = (int) (Math.random() * (30 - 1 + 1) + 1);
                break;
            case 10:
                day = (int) (Math.random() * (31 - 1 + 1) + 1);
                break;
            case 11:
                day = (int) (Math.random() * (30 - 1 + 1) + 1);
                break;
            case 12:
                day = (int) (Math.random() * (31 - 1 + 1) + 1);
                break;
        }

        return day;
    }

    private static int generarHoraAleatorio() {
        int hour = (int) (Math.random() * 24);

        return hour;
    }

    private static int generarMinutoAleatorio() {
        int minute = (int) (Math.random() * 60);

        return minute;
    }

    private static int generarSegundoAleatorio() {
        int segundo = (int) (Math.random() * 60);

        return segundo;
    }
}
