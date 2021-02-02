
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
        FechaHora fecha1 = new FechaHora();
        FechaHora fecha2 = new FechaHora(1500, 3000);
        FechaHora fecha3 = new FechaHora("24-05-2021 00:00:00", "dd-M-yyyy HH:mm:ss");
        System.out.println("FECHA 1: " + fecha1.getFechaFormato("dd-M-y"));
        System.out.println("FECHA 2: " + fecha2.getFechaFormato("HH:mm:ss"));
        System.out.println("FECHA 3: " + fecha3.getFechaFormato("dd-M-y HH:mm:ss"));

        System.out.println("\n###############################\n");

        fecha1.avanzarYears(5);
        fecha2.avanzarHora(13);
        fecha3.avanzarDays(20);
        System.out.println("FECHA 1: " + fecha1.getFechaFormato("dd-M-y"));
        System.out.println("FECHA 2: " + fecha2.getFechaFormato("HH:mm:ss"));
        System.out.println("FECHA 3: " + fecha3.getFechaFormato("dd-M-y HH:mm:ss"));
    }
}
