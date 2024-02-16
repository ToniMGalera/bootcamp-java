import java.util.Scanner;

public class Tasca06 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un número entero positivo: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("Por favor, ingresa un número entero positivo.");
        } else {
            int cantidadCifras = contarCifras(numero);
            System.out.println("El número de cifras es: " + cantidadCifras);
        }

        scanner.close();
    }

    public static int contarCifras(int numero) {
        if (numero == 0) {
            return 1; // Si el número es 0, tiene una cifra
        }

        int cifras = 0;

        while (numero != 0) {
            cifras++;
            numero /= 10; // División por 10 para quitar la última cifra
        }

        return cifras;
    }
}
