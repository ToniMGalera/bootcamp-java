import java.util.Scanner;

public class UD505 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Ingresar un número: ");
		
	int numero=scanner.nextInt();
	if (numero % 2 == 0) {
		System.out.println("El número " +numero+ " es divisible de 2.");
		
	} else {
		
		System.out.println("El número " + numero + " no es divisible entre 2.");

	}
	scanner.close();
	}

}
