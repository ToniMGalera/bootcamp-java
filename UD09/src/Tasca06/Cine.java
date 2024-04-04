package Tasca06;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class Cine {
    private Pelicula pelicula;
    private double precio;
    private int filas;
    private int columnas;
    private Asiento[][] asientos;
    private Random random;

    public Cine(Pelicula pelicula, double precio, int filas, int columnas) {
        this.pelicula = pelicula;
        this.precio = precio;
        this.filas = filas;
        this.columnas = columnas;
        this.asientos = new Asiento[filas][columnas];
        this.random = new Random();
        // Inicializar los asientos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = new Asiento(i + 1, (char) ('A' + j));
            }
        }
    }

    //info peli
    public void mostrarInformacionPelicula() {
        JOptionPane.showMessageDialog(null, "Película en reproducción: " + pelicula.getTitulo() +
            "\nDuración: " + pelicula.getDuracion() + " minutos" +
            "\nEdad mínima: " + pelicula.getEdadMinima() + " años" +
            "\nDirector: " + pelicula.getDirector() +
            "\nPrecio de la entrada: $" + precio);
    }

    //mostrar estado asientos
    public void mostrarEstadoAsientos() {
        StringBuilder estadoAsientos = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                estadoAsientos.append(asientos[i][j].estaOcupado() ? "X " : "O ");
            }
            estadoAsientos.append("\n");
        }
        JOptionPane.showMessageDialog(null, "Estado de los asientos:\n" + estadoAsientos.toString());
    }

    //sentar espectador aleatoriamente si hay espacio libre
    public boolean sentarEspectador(Espectador espectador) {
        int intentos = filas * columnas;
        while (intentos > 0) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            Asiento asiento = asientos[fila][columna];
            if (!asiento.estaOcupado() && espectador.getEdad() >= pelicula.getEdadMinima() && espectador.getDinero() >= precio) {
                asiento.setEspectador(espectador);
                return true;
            }
            intentos--;
        }
        return false;
    }
}
