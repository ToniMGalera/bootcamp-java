import java.util.Scanner;
public class Tasca12 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Ingresa el tamaño del array: ");
	        int tamanoArray = obtenerEnteroPositivo(scanner);

	        int[] arrayOriginal = new int[tamanoArray];
	        llenarArrayConAleatorios(arrayOriginal);

	        System.out.println("Ingresa el dígito por el cual quieres filtrar (de 0 a 9): ");
	        int digitoFiltrar = obtenerDigito(scanner);

	        int[] arrayFiltrado = filtrarPorDigito(arrayOriginal, digitoFiltrar);

	        // Mostrar contenido del array original
	        mostrarArray("Array Original:", arrayOriginal);

	        // Mostrar contenido del array filtrado
	        mostrarArray("Array Filtrado por el dígito " + digitoFiltrar + ":", arrayFiltrado);

	        scanner.close();
	    }

	    public static void llenarArrayConAleatorios(int[] array) {
	        for (int i = 0; i < array.length; i++) {
	            array[i] = (int) (Math.random() * 300) + 1; // Números aleatorios entre 1 y 300
	        }
	    }

	    public static int[] filtrarPorDigito(int[] array, int digito) {
	        int contador = 0;

	        // Contar cuántos números en el array terminan en el dígito indicado
	        for (int numero : array) {
	            if (numero % 10 == digito) {
	                contador++;
	            }
	        }

	        // Crear un nuevo array con el tamaño del contador
	        int[] arrayFiltrado = new int[contador];
	        int indiceFiltrado = 0;

	        // Llenar el array filtrado con los números que terminan en el dígito
	        for (int numero : array) {
	            if (numero % 10 == digito) {
	                arrayFiltrado[indiceFiltrado++] = numero;
	            }
	        }

	        return arrayFiltrado;
	    }

	    public static void mostrarArray(String mensaje, int[] array) {
	        System.out.print(mensaje + " ");
	        for (int elemento : array) {
	            System.out.print(elemento + " ");
	        }
	        System.out.println();
	    }

	    public static int obtenerEnteroPositivo(Scanner scanner) {
	        while (true) {
	            try {
	                int numero = Integer.parseInt(scanner.nextLine());
	                if (numero > 0) {
	                    return numero;
	                } else {
	                    System.out.println("Por favor, ingresa un número entero positivo.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Error: Ingresa un número válido.");
	            }
	        }
	    }

	    public static int obtenerDigito(Scanner scanner) {
	        while (true) {
	            try {
	                int digito = Integer.parseInt(scanner.nextLine());
	                if (digito >= 0 && digito <= 9) {
	                    return digito;
	                } else {
	                    System.out.println("Por favor, ingresa un dígito válido (de 0 a 9).");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Error: Ingresa un número válido.");
	            }
	        }
	    }
	}

