
public class Serie {
	private String titulo;
    private int numeroTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    // Constructor por defecto
    public Serie() {
        this.titulo = "Título por defecto";
        this.numeroTemporadas = 3;
        this.entregado = false;
        this.genero = "Género por defecto";
        this.creador = "Creador por defecto";
    }

    // Constructor con título y creador, el resto por defecto
    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = 3;
        this.entregado = false;
        this.genero = "Género por defecto";
        this.creador = creador;
    }

    // Constructor con todos los atributos excepto entregado
    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.entregado = false;
        this.genero = genero;
        this.creador = creador;
    }

    // Método para mostrar información de la serie en la consola
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Número de temporadas: " + numeroTemporadas);
        System.out.println("Entregado: " + entregado);
        System.out.println("Género: " + genero);
        System.out.println("Creador: " + creador);
    }

    // Método main para probar la clase Serie
    public static void main(String[] args) {
        // Crear una serie utilizando el constructor por defecto
        Serie serie1 = new Serie();

        // Mostrar la información de la serie en la consola
        System.out.println("Serie 1:");
        serie1.mostrarInformacion();
        System.out.println(); // Salto de línea para separar la información

        // Crear una serie utilizando el constructor con título y creador
        Serie serie2 = new Serie("Breaking Bad", "Vince Gilligan");

        // Mostrar la información de la serie en la consola
        System.out.println("Serie 2:");
        serie2.mostrarInformacion();
        System.out.println(); // Salto de línea para separar la información

        // Crear una serie utilizando el constructor con todos los atributos excepto entregado
        Serie serie3 = new Serie("Game of Thrones", 8, "Fantasía", "George R. R. Martin");

        // Mostrar la información de la serie en la consola
        System.out.println("Serie 3:");
        serie3.mostrarInformacion();
    }
}
