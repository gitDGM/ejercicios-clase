/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
/**
 *
 * @author alumno
 */
public class FechaHora {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int seconds;
    private LocalDate fechaLocalDate;
    private LocalTime fechaLocalTime;
    private LocalDateTime fechaLocalDateTime;

    public FechaHora(int day, int month, int year, int hour, int minute, int seconds, LocalDate fechaLocalDate, LocalTime fechaLocalTime, LocalDateTime fechaLocalDateTime) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
        this.fechaLocalDate = fechaLocalDate;
        this.fechaLocalTime = fechaLocalTime;
        this.fechaLocalDateTime = fechaLocalDateTime;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setFechaLocalDate(LocalDate fechaLocalDate) {
        this.fechaLocalDate = fechaLocalDate;
    }

    public void setFechaLocalTime(LocalTime fechaLocalTime) {
        this.fechaLocalTime = fechaLocalTime;
    }

    public void setFechaLocalDateTime(LocalDateTime fechaLocalDateTime) {
        this.fechaLocalDateTime = fechaLocalDateTime;
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

    public int getMinute() {
        return minute;
    }

    public int getSeconds() {
        return seconds;
    }

    public LocalDate getFechaLocalDate() {
        return fechaLocalDate;
    }

    public LocalTime getFechaLocalTime() {
        return fechaLocalTime;
    }

    public LocalDateTime getFechaLocalDateTime() {
        return fechaLocalDateTime;
    }
    
    
}
