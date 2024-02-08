import java.util.Scanner;

public class UD56 {

		public static void main(String [] args) {
			// Constante IVA
			final double IVA=0.21;
//			crear objetp Scanner
		Scanner scanner=new Scanner(System.in);
//		Solicitar precio
		System.out.println("Ingrese el precio del producto: ");
//		con IVA
		double precioSinIVA=scanner.nextDouble();
//		Sin IVA
		double precioConIVA=precioSinIVA * (1+IVA);
//		Muestra resultado
		System.out.println("El precio con IVA es: " + precioConIVA);
		
		scanner.close();
		}
}
