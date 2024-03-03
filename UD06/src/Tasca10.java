import java.util.Random;
import java.util.Scanner;
public class Tasca10 {

	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Solicitar tamaño del array
	        System.out.print("Ingrese el tamaño del array: ");
	        int tamañoArray = scanner.nextInt();

	        // Solicitar límites para los números primos
	        System.out.print("Ingrese el valor mínimo para los números primos: ");
	        int min = scanner.nextInt();
	        System.out.print("Ingrese el valor máximo para los números primos: ");
	        int max = scanner.nextInt();

	        // array de números primos aleatorios
	        int[] miArray = generarArrayDePrimos(tamañoArray, min, max);

	        // Mostrar el contenido del array y el número mayor
	        mostrarArrayYMayor(miArray);
	    }

	    // Método para generar un array de números primos aleatorios
	    static int[] generarArrayDePrimos(int tamaño, int min, int max) {
	        Random random = new Random();
	        int[] array = new int[tamaño];
	        int indice = 0;

	        while (indice < tamaño) {
	            int numeroAleatorio = random.nextInt((max - min) + 1) + min;

	            if (esPrimo(numeroAleatorio)) {
	                array[indice] = numeroAleatorio;
	                indice++;
	            }
	        }

	        return array;
	    }

	    // Método para verificar si un número es primo
	    static boolean esPrimo(int numero) {
	        if (numero <= 1) {
	            return false;
	        }

	        for (int i = 2; i <= Math.sqrt(numero); i++) {
	            if (numero % i == 0) {
	                return false;
	            }
	        }

	        return true;
	    }

	    // Método para mostrar el contenido del array y el número mayor
	    static void mostrarArrayYMayor(int[] array) {
	        int mayor = Integer.MIN_VALUE;

	        System.out.println("Contenido del array:");

	        for (int i = 0; i < array.length; i++) {
	            System.out.println("Posición " + i + ": " + array[i]);

	            if (array[i] > mayor) {
	                mayor = array[i];
	            }
	        }

	        System.out.println("El número mayor es: " + mayor);
	    }
	}