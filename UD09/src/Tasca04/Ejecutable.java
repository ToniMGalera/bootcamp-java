package Tasca04;
import javax.swing.JOptionPane;

public class Ejecutable {
    public static void main(String[] args) {
        // Obtener los coeficientes de la ecuación de segundo grado
        double a = Double.parseDouble(JOptionPane.showInputDialog("Introduce el coeficiente 'a'"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Introduce el coeficiente 'b'"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Introduce el coeficiente 'c'"));

        // Crear objeto Raices con los coeficientes dados
        Raices raices = new Raices(a, b, c);

        // Calcular y mostrar las raíces
        raices.calcular();
    }
}
