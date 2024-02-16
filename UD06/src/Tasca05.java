import java.util.Scanner;
public class Tasca05 {

	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Ingresa un número decimal para convertir a binario: ");
	        int numeroDecimal = scanner.nextInt();

	        String binario = convertirABinario(numeroDecimal);

	        System.out.println("El número binario es: " + binario);

	        scanner.close();
	    }

	    public static String convertirABinario(int numeroDecimal) {
	        if (numeroDecimal == 0) {
	            return "0"; // Caso especial: 0 en decimal es 0 en binario
	        }

	        StringBuilder resultadoBinario = new StringBuilder();

	        while (numeroDecimal > 0) {
	            int residuo = numeroDecimal % 2; // Calcula el residuo de la división por 2
	            resultadoBinario.insert(0, residuo); // Agrega el residuo al inicio del resultado binario
	            numeroDecimal /= 2; // Divide el número por 2 para la siguiente iteración
	        }

	        return resultadoBinario.toString();
	}

}
