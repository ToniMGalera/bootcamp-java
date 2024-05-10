import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero {
    private int numeroAleatorio;
    private int intentos;

    public AdivinaNumero() {
        Random random = new Random();
        numeroAleatorio = random.nextInt(500) + 1;
        intentos = 0;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bienvenido a Adivina el Número!");
        System.out.println("El número a adivinar está entre 1 y 500.");

        while (true) {
            System.out.print("Introduce tu intento: ");
            try {
                int intento = scanner.nextInt();
                intentos++;

                if (intento == numeroAleatorio) {
                    System.out.println("¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
                    break;
                } else if (intento < numeroAleatorio) {
                    System.out.println("El número a adivinar es mayor.");
                } else {
                    System.out.println("El número a adivinar es menor.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número válido.");
                intentos++;
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        AdivinaNumero juego = new AdivinaNumero();
        juego.jugar();
    }
}
