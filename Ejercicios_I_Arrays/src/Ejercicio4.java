
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrEjer4 = new int[10];
        int mayor = 0;
                
        for (int i = 0; i < arrEjer4.length; i++) {
            System.out.println("Introduce un número: ");
            arrEjer4[i] = sc.nextInt();
            if (i == 0) {
                mayor = arrEjer4[i];
            } else if (arrEjer4[i] > mayor) {
                mayor = arrEjer4[i];
            }
        }
        
        for (int i = 0; i < arrEjer4.length; i++) {
            if (mayor == arrEjer4[i]) {
                System.out.println((i + 1) + ".- " + arrEjer4[i]);
            }
        }
        
        System.out.println(mayor);
    }
}
