package excepcionespersonalizadas;

//custom.exceptions/CustomException.java
public class CustomException extends Exception {
	
	private String mensaje;
	
	public CustomException(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}