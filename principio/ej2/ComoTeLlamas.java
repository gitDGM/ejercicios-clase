import java.util.Scanner;
public class ComoTeLlamas {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.printf("Cómo te llamas?: ");
	String name = sc.nextLine();
	System.out.printf("Tu nombre es %s%n", name);
    }
}
