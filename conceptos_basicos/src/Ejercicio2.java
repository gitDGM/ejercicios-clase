
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Introduce tu edad: ");
		int edad = sc.nextInt();
		System.out.println("Su edad dentro de 5 años será: " + (edad + 5));

	}

}