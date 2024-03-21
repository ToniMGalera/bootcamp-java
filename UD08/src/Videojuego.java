
public class Videojuego {
	 private String titulo;
	    private int numeroEntregas;
	    private boolean entregado;
	    private String genero;
	    private String creador;

	    // Constructor por defecto
	    public Videojuego() {
	        this.titulo = "Título por defecto";
	        this.numeroEntregas = 2;
	        this.entregado = false;
	        this.genero = "Género por defecto";
	        this.creador = "Creador por defecto";
	    }

	    // Constructor con título y creador, el resto por defecto
	    public Videojuego(String titulo, String creador) {
	        this.titulo = titulo;
	        this.numeroEntregas = 2;
	        this.entregado = false;
	        this.genero = "Género por defecto";
	        this.creador = creador;
	    }

	    // Constructor con todos los atributos excepto entregado
	    public Videojuego(String titulo, int numeroEntregas, String genero, String creador) {
	        this.titulo = titulo;
	        this.numeroEntregas = numeroEntregas;
	        this.entregado = false;
	        this.genero = genero;
	        this.creador = creador;
	    }

	    // Método para mostrar información del videojuego en la consola
	    public void mostrarInformacion() {
	        System.out.println("Título: " + titulo);
	        System.out.println("Número de entregas: " + numeroEntregas);
	        System.out.println("Entregado: " + entregado);
	        System.out.println("Género: " + genero);
	        System.out.println("Creador: " + creador);
	    }

	    // Método main para probar la clase Videojuego
	    public static void main(String[] args) {
	        // Crear un videojuego utilizando el constructor por defecto
	        Videojuego juego1 = new Videojuego();

	        // Mostrar la información del videojuego en la consola
	        System.out.println("Videojuego 1:");
	        juego1.mostrarInformacion();
	        System.out.println(); // Salto de línea para separar la información

	        // Crear un videojuego utilizando el constructor con título y creador
	        Videojuego juego2 = new Videojuego("Alan Wake", "Sam Lake");

	        // Mostrar la información del videojuego en la consola
	        System.out.println("Videojuego 2:");
	        juego2.mostrarInformacion();
	        System.out.println(); // Salto de línea para separar la información

	        // Crear un videojuego utilizando el constructor con todos los atributos excepto entregado
	        Videojuego juego3 = new Videojuego("Dark Souls II", 3, "RPG", "Hidetaka Miyazaki");

	        // Mostrar la información del videojuego en la consola
	        System.out.println("Videojuego 3:");
	        juego3.mostrarInformacion();
	    }
}
