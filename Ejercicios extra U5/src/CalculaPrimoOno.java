import java.util.Scanner;
public class CalculaPrimoOno {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Ingresa número");
		int numero=scanner.nextInt();
		scanner.close();
		boolean esPrimo=verificarPrimo(numero);
		
		if (esPrimo) {
			System.out.println(numero + " es un número primo.");
		}else{
			 System.out.println(numero + " no es un número primo.");
		}
		
	}

}
