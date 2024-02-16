import java.util.Scanner;
public class Tasca04 {

	public static void main (String [] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Ingresa numero ");
		int numero=scanner.nextInt();
		
		long factorial=calcularFactorial(numero);
		System.out.println("El factorial de " + numero + " es: " + factorial);
	
	scanner.close();
	}
	public static long calcularFactorial(int numero) {
        if (numero < 0) {
	
        	System.out.println("No se puede calcular");
        	return -1;
        }
        long resultado=1;
        
        for(int i=1; i<= numero; i++) {
        	resultado *=i;
        	
        }
        return resultado;
        	
        }
}
