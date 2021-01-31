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

    public static FechaHora fechaActualLocalDate() {
        LocalDate fechaActual = LocalDate.now();
        FechaHora fechaActualInstance = new FechaHora();

        fechaActualInstance.year = fechaActual.getYear();
        fechaActualInstance.month = fechaActual.getMonthValue();
        fechaActualInstance.day = fechaActual.getDayOfMonth();
        fechaActualInstance.hour = 0;
        fechaActualInstance.minutes = 0;
        fechaActualInstance.seconds = 0;

        return fechaActualInstance;
    }

    public static FechaHora fechaActualLocalTime() {
        LocalTime fechaActual = LocalTime.now();
        FechaHora fechaActualInstance = new FechaHora();

        fechaActualInstance.year = 0;
        fechaActualInstance.month = 1;
        fechaActualInstance.day = 1;
        fechaActualInstance.hour = fechaActual.getHour();
        fechaActualInstance.minutes = fechaActual.getMinute();
        fechaActualInstance.seconds = fechaActual.getSecond();

        return fechaActualInstance;
    }

    public static FechaHora fechaActualLocalDateTime() {
        LocalDateTime fechaActual = LocalDateTime.now();
        FechaHora fechaActualInstance = new FechaHora();

        fechaActualInstance.year = fechaActual.getYear();
        fechaActualInstance.month = fechaActual.getMonthValue();
        fechaActualInstance.day = fechaActual.getDayOfMonth();
        fechaActualInstance.hour = fechaActual.getHour();
        fechaActualInstance.minutes = fechaActual.getMinute();
        fechaActualInstance.seconds = fechaActual.getSecond();

        return fechaActualInstance;
    }

    public static FechaHora fechaAleatoriaLocalDate() {
        FechaHora fechaAleatoria = new FechaHora();
        fechaAleatoria.year = FechaHora.generarYearAleatorio();
        fechaAleatoria.month = FechaHora.generarMonthAleatorio();
        fechaAleatoria.day = FechaHora.generarDayAleatorio(fechaAleatoria.month, fechaAleatoria.year);
        fechaAleatoria.hour = 0;
        fechaAleatoria.minutes = 0;
        fechaAleatoria.seconds = 0;

        return fechaAleatoria;
    }

    public static FechaHora fechaAleatoriaLocalTime() {
        FechaHora fechaAleatoria = new FechaHora();
        fechaAleatoria.year = 0;
        fechaAleatoria.month = 1;
        fechaAleatoria.day = 1;
        fechaAleatoria.hour = FechaHora.generarHoraAleatorio();
        fechaAleatoria.minutes = FechaHora.generarMinutoAleatorio();
        fechaAleatoria.seconds = FechaHora.generarSegundoAleatorio();

        return fechaAleatoria;
    }

    public static FechaHora fechaAleatoriaLocalDateTime() {
        FechaHora fechaAleatoria = new FechaHora();
        fechaAleatoria.year = FechaHora.generarYearAleatorio();
        fechaAleatoria.month = FechaHora.generarMonthAleatorio();
        fechaAleatoria.day = FechaHora.generarDayAleatorio(fechaAleatoria.month, fechaAleatoria.year);
        fechaAleatoria.hour = FechaHora.generarHoraAleatorio();
        fechaAleatoria.minutes = FechaHora.generarMinutoAleatorio();
        fechaAleatoria.seconds = FechaHora.generarSegundoAleatorio();

        return fechaAleatoria;
    }

    public static FechaHora fechaStringLocalDate(String cadena) {
        LocalDate fechaString = LocalDate.parse(cadena);
        FechaHora fecha = new FechaHora();
        fecha.year = fechaString.getYear();
        fecha.month = fechaString.getMonthValue();
        fecha.day = fechaString.getDayOfMonth();
        fecha.hour = 0;
        fecha.minutes = 0;
        fecha.seconds = 0;

        return fecha;
    }

    public static FechaHora fechaStringLocalTime(String cadena) {
        LocalTime fechaString = LocalTime.parse(cadena);
        FechaHora fecha = new FechaHora();
        fecha.year = 0;
        fecha.month = 1;
        fecha.day = 1;
        fecha.hour = fechaString.getHour();
        fecha.minutes = fechaString.getMinute();
        fecha.seconds = fechaString.getSecond();

        return fecha;
    }

    public static FechaHora fechaStringLocalDateTime(String cadena) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaString = LocalDateTime.parse(cadena, formateador);
        FechaHora fecha = new FechaHora();
        fecha.year = fechaString.getYear();
        fecha.month = fechaString.getMonthValue();
        fecha.day = fechaString.getDayOfMonth();
        fecha.hour = fechaString.getHour();
        fecha.minutes = fechaString.getMinute();
        fecha.seconds = fechaString.getSecond();

        return fecha;
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

    private static int generarYearAleatorio() {
        int maxYear = 2900;
        int minYear = 1500;
        int year = (int) ((Math.random() * (maxYear - minYear + 1) + minYear));

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
