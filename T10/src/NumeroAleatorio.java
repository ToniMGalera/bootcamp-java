import java.util.Random;

	public class NumeroAleatorio {
	    public static void main(String[] args) {
	        try {
	            int numero = generarNumeroAleatorio();
	            determinarParidad(numero);
	        } catch (ParidadException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    public static int generarNumeroAleatorio() {
	        Random random = new Random();
	        return random.nextInt(1000); // Genera un número aleatorio entre 0 y 999
	    }

	    public static void determinarParidad(int numero) throws ParidadException {
	        if (numero % 2 == 0) {
	            throw new ParidadException("El número " + numero + " es par.");
	        } else {
	            throw new ParidadException("El número " + numero + " es impar.");
	        }
	    }
	}

	class ParidadException extends Exception {
	    public ParidadException(String mensaje) {
	        super(mensaje);
	    }
	}