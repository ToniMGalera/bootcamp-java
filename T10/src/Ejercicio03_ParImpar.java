import java.util.Random;

class ExcepcionNumeroPar extends Exception {
    public ExcepcionNumeroPar(String mensaje) {
        super(mensaje);
    }
}

// Clase principal que genera un número aleatorio y determina si es par o impar
class Ejercicio03_ParImpar {
    // Método para generar un número aleatorio entre 0 y 999
    public int generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextInt(1000); // Se generará un número entre 0 y 999
    }

    // Método para determinar si un número es par o impar
    public void determinarParidad(int numero) throws ExcepcionNumeroPar {
        if (numero % 2 == 0) {
            throw new ExcepcionNumeroPar("Es par: " + numero);
        } else {
            System.out.println("Es impar: " + numero);
        }
    }

    // Método main dentro de la clase Ejercicio03_ParImpar
    public static void main(String[] args) {
        Ejercicio03_ParImpar generador = new Ejercicio03_ParImpar();

        try {
            int numeroAleatorio = generador.generarNumeroAleatorio();
            generador.determinarParidad(numeroAleatorio);
        } catch (ExcepcionNumeroPar e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finalizado");
        }
    }
}