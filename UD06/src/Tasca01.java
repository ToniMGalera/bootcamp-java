import java.util.Scanner;
public class Tasca01 {

	public static void main (String [] args) {
		Scanner scanner = new Scanner (System.in);
	System.out.println("¿Qué figura desea calcular? (Círculo / Triangulo / Cuadrado): ");
	String figura= scanner.nextLine();
	
	switch (figura.toLowerCase()) {
	case "círculo":
		double radio = pedirValor("radio");
		System.out.println("El área del círculo es: "+ calcularAreaCirculo(radio));
		break;
	case "triangulo":
		double base= pedirValor ("base");
		double altura= pedirValor ("altura");
		System.out.println("El area del triángulo es: "+ calcularAreaTriangulo(base, altura));
		break;
	case "cuadrado":
		double lado= pedirValor ("lado");
		System.out.println("El área del cuadrado es: " + calcularAreaCuadrado(lado));
		break;
	default :
		System.out.println("Figura no reconocida. Por favor, ingrese círculo, triangulo o cuadrado.");
        break;
	}
	scanner.close ();
	}

public static double calcularAreaCirculo(double radio) {
    return Math.PI * Math.pow(radio, 2);
}

public static double calcularAreaTriangulo(double base, double altura) {
    return (base * altura) / 2;
}

public static double calcularAreaCuadrado(double lado) {
    return Math.pow(lado, 2);
}
public static double pedirValor(String nombre) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el valor de " + nombre + ": ");
    return scanner.nextDouble();
}}