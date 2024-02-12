import java.util.Scanner;

public class UD510 {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
			System.out.println("Introducir nº de ventas: ");
			int numeroVentas=scanner.nextInt();
			 double sumaVentas = 0;

			 for (int numero=1; numero <= numeroVentas; numero++){
			
			 System.out.println("Introduce la venta " + numero + ": ");
			 double venta = scanner.nextDouble();
	            sumaVentas += venta;
			 }

		        // Mostrar la suma de las ventas
		        System.out.println("La suma de todas las ventas es: " + sumaVentas);
	}

}
			
		
