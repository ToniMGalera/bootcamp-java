
public class CustomExceptionExample {
	public static void main(String[] args) {
        try {
            // Iniciamos un bloque try
            System.out.println("Empieza el bucle...");

            // Creamos un objeto de nuestra excepción personalizada y la lanzamos
            throw new MyCustomException("Es personalizada, ole");
            
        } catch (MyCustomException e) {
            // Capturamos y manejamos la excepción personalizada
            System.out.println("Capturada");
            System.out.println("Mensaje de la excepción: " + e.getMessage());
        } finally {
            System.out.println("Se acabó");
        }
    } 
}

class MyCustomException extends Exception {
    // Constructor que acepta un mensaje de error
    public MyCustomException(String message) {
        super(message);
    }
}