package Tasca03;
import java.util.Random;
import javax.swing.JOptionPane;

public class Ejecutable {
    public static void main(String[] args) {
        // Crear objetos Libro
        Libro libro1 = new Libro("9788420433196", "La novia gitana", "Carmen Mola", 408);
        Libro libro2 = new Libro("9781852860820", "The Killing Joke", "Alan Moore", 64);

        // Mostrar los libros por pantalla
        JOptionPane.showMessageDialog(null, libro1.toString());
        JOptionPane.showMessageDialog(null, libro2.toString());

//		// cuál tiene más pags
//		String mensaje = (libro1.getNumeroPaginas() > libro2.getNumeroPaginas())
//				? "El libro 1 tiene más páginas que el libro 2."
//				: (libro1.getNumeroPaginas() < libro2.getNumeroPaginas())
//						? "El libro 2 tiene más páginas que el libro 1."
//						: "Ambos libros tienen la misma cantidad de páginas.";
//
//		JOptionPane.showMessageDialog(null, mensaje);
//	}
//}
        if (libro1.getNumeroPaginas() > libro2.getNumeroPaginas()) {
            JOptionPane.showMessageDialog(null, "El libro 1 tiene más páginas que el libro 2.");
        } else if (libro1.getNumeroPaginas() < libro2.getNumeroPaginas()) {
            JOptionPane.showMessageDialog(null, "El libro 2 tiene más páginas que el libro 1.");
        } else {
            // x si ambos tienen las mismas páginas para elegir uno al azar
            Random random = new Random();
            int randomIndex = random.nextInt(2); // Genera un número aleatorio entre 0 y 1
            Libro[] libros = {libro1, libro2};
            JOptionPane.showMessageDialog(null, "Ambos libros tienen la misma cantidad de páginas.\nSe elige el siguiente libro:\n" + libros[randomIndex].toString());
        }
    }
}