
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diego
 */
public class FechaHoraTest {

    public static void main(String[] args) {
        FechaHora fecha1 = FechaHora.fechaActualLocalDate();
        FechaHora fecha2 = FechaHora.fechaActualLocalTime();
        FechaHora fecha3 = FechaHora.fechaActualLocalDateTime();
        FechaHora fecha4 = FechaHora.fechaAleatoriaLocalDateTime();
        System.out.println("FECHA 1: " + fecha1.getFechaFormato("dd-M-y"));
        System.out.println("FECHA 2: " + fecha2.getFechaFormato("HH:mm:ss"));
        System.out.println("FECHA 3: " + fecha3.getFechaFormato("dd-M-y HH:mm:ss"));
        System.out.println("FECHA 4: " + fecha4.getFechaFormato("dd-M-y HH:mm:ss"));

        System.out.println("\n###############################\n");

        fecha1.avanzarYears(5);
        fecha2.avanzarHora(13);
        fecha3.avanzarDays(20);
        fecha4.avanzarMinutos(500);
        System.out.println("FECHA 1: " + fecha1.getFechaFormato("dd-M-y"));
        System.out.println("FECHA 2: " + fecha2.getFechaFormato("HH:mm:ss"));
        System.out.println("FECHA 3: " + fecha3.getFechaFormato("dd-M-y HH:mm:ss"));
        System.out.println("FECHA 4: " + fecha4.getFechaFormato("dd-M-y HH:mm:ss"));

        System.out.println("\n###############################\n");

        FechaHora fecha5 = FechaHora.fechaStringLocalDate("2021-05-08");
        System.out.println("FECHA 5: " + fecha5.getFechaFormato("dd-M-y"));
    }
}
