import java.util.Scanner;
public class Tasca08 {

	 public static void main(String[] args) {
	        // Crear un array de 10 posiciones
	        int[] miArray = new int[10];

	        // Llamar al método para rellenar valores
	        rellenarValores(miArray);

	        // Mostrar el índice y el valor del array
	        mostrarArray(miArray);
	    }

	    // Método para rellenar valores en el array
	    static void rellenarValores(int[] array) {
	        Scanner scanner = new Scanner(System.in);
	        for (int i = 0; i < array.length; i++) {
	            System.out.print("Ingrese el valor para la posición " + (i + 1) + ": ");
	            array[i] = scanner.nextInt();
	        }
	      
	    }

	    // Método para mostrar el índice y el valor del array
	    static void mostrarArray(int[] array) {
	        for (int i = 0; i < array.length; i++) {
	            System.out.println("Índice " + i + ": " + array[i]);
	        }
	    }
	}
