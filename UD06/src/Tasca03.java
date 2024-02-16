import java.util.Scanner;
public class Tasca03 {
	
	public static void main (String [] args) {
		Scanner scanner=new Scanner(System.in);
	System.out.println("Ingresa numero: ");
	int numero=scanner.nextInt();
	
	boolean esPrimo = esNumeroPrimo(numero);
	
	if (esPrimo) {
		System.out.println(numero+ " es número primo.");
	}else{
		System.out.println(numero+ " no es número primo.");
	}
	scanner.close();
	
	}
	public static boolean esNumeroPrimo (int numero) {
	if (numero <=1){
			return false;
	}
	for (int i=2; i<= numero / 2; i++) {
		if (numero %i==0) {
			return false;
			
		}
		}
	return true;
	}
	}
