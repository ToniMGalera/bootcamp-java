import java.util.Scanner;
public class SumaProgresiva {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		 System.out.println("Introduce numero: ");
		 int numero=scanner.nextInt();
		 scanner.close();
		 
		 int suma=0;
		 for (int i =numero; i>0; i--) {
			 suma+=i;
			 
		 }
		System.out.println("La suma de "+ numero + " es: " + suma); 

	}

}
