
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Introduce el año actual: ");
		int yearActual = sc.nextInt();
		System.out.print("Introduce tu año de nacimiento: ");
		int yearNacimiento = sc.nextInt();
		System.out.println("Su edad es: " + (yearActual - yearNacimiento));
		
	}

}