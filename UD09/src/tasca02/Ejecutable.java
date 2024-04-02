package tasca02;
import javax.swing.JOptionPane;

public class Ejecutable {
    public static void main(String[] args) {
        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        series[0] = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
        series[1] = new Serie("Game of Thrones", 8, "Fantasía", "David Benioff");
        series[2] = new Serie("The Office", 9, "Comedia", "Greg Daniels");
        series[3] = new Serie("Aquí no hay quien viva", 6, "Comedia", "Alberto Caballero");
        series[4] = new Serie("The Boys", 4, "Comedia", "Eric Kripke");

        videojuegos[0] = new Videojuego("Fallout New Vegas", 40, "RPG", "Obsidian");
        videojuegos[1] = new Videojuego("Grand Theft Auto IV", 60, "Acción", "Rockstar Games");
        videojuegos[2] = new Videojuego("God of War Ragnarok", 35, "Acción-aventura", "Santa Monica");
        videojuegos[3] = new Videojuego("Red Dead Redemption 2", 70, "Acción-aventura", "Rockstar Games");
        videojuegos[4] = new Videojuego("The Curse of Monkey Island", 8, "Aventura gráfica", "LucasArts");

        series[0].entregar();
        series[1].entregar();
        series[2].entregar();
        series[3].entregar();
        series[4].entregar();
        videojuegos[0].entregar();
        videojuegos[1].entregar();
        videojuegos[2].entregar();
        videojuegos[3].entregar();
        videojuegos[4].entregar();

        // ContarSeries y juegos
        int seriesEntregadas = contarEntregados(series);
        int videojuegosEntregados = contarEntregados(videojuegos);

        //Videojuego con más horas y la serie con más temporadas
        Videojuego videojuegoMasHoras = obtenerMayor(videojuegos);
        Serie serieMasTemporadas = obtenerMayor(series);

        //resultados
        JOptionPane.showMessageDialog(null,
                "Series entregadas: " + seriesEntregadas + "\n" +
                "Videojuegos entregados: " + videojuegosEntregados + "\n" +
                "Videojuego con más horas estimadas: " + videojuegoMasHoras + "\n" +
                "Serie con más temporadas: " + serieMasTemporadas);
    }

    // Método para contar objetos entregados
    public static int contarEntregados(Entregable[] objetos) {
        int contador = 0;
        for (Entregable objeto : objetos) {
            if (objeto.isEntregado()) {
                contador++;
            }
        }
        return contador;
    }

    // Método para obtener el objeto con mayor atributo
    public static <T extends Entregable> T obtenerMayor(T[] objetos) {
        T mayor = objetos[0];
        for (int i = 1; i < objetos.length; i++) {
            if (objetos[i].compareTo(mayor) > 0) {
                mayor = objetos[i];
            }
        }
        return mayor;
    }
}