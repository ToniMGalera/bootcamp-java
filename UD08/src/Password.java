import java.util.Random;
public class Password {
	public static void main(String[] args) {
        // Crear una contraseña
        Password password1 = new Password();
        
        password1.mostrarContraseña();

        // Crear una contraseña con longitud
        Password password2 = new Password();
        // Mostrar la contraseña generada
        password2.mostrarContraseña();
    }
	 // Atributos
    private int longitud;
    private String contraseña;

    // Constructor por defecto
    public Password() {
        this.longitud = 8;
        this.contraseña = generarContraseñaAleatoria(this.longitud);
    }

    // Constructor con longitud personalizada
    public Password(int longitud) {
        this.longitud = longitud;
        this.contraseña = generarContraseñaAleatoria(this.longitud);
    }

    // Método para generar una contraseña aleatoria
    private String generarContraseñaAleatoria(int longitud) {
        String caracteres = "ABCÇDEFGHIJKLMNOPQRSTUVWXYZabcçdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(longitud);
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    // Método para mostrar la contraseña
    public void mostrarContraseña() {
        System.out.println("Contraseña: " + contraseña);
    }

    // Getters y setters
    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContraseña() {
        return contraseña;
    }
}