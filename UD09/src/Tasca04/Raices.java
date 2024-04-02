package Tasca04;
import javax.swing.JOptionPane;

public class Raices {
    private double a;
    private double b;
    private double c;

    // Constructor
    public Raices(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Método para calcular el discriminante
    public double getDiscriminante() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    // Método para verificar si tiene dos soluciones
    public boolean tieneRaices() {
        return getDiscriminante() >= 0;
    }

    // Método para verificar si tiene una única solución
    public boolean tieneRaiz() {
        return getDiscriminante() == 0;
    }

    // Método para calcular las raíces y mostrarlas
    public void calcular() {
        if (tieneRaices()) {
            double x1 = (-b + Math.sqrt(getDiscriminante())) / (2 * a);
            double x2 = (-b - Math.sqrt(getDiscriminante())) / (2 * a);
            JOptionPane.showMessageDialog(null, "Las soluciones son: x1 = " + x1 + ", x2 = " + x2);
        } else if (tieneRaiz()) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "La solución única es: x = " + x);
        } else {
            JOptionPane.showMessageDialog(null, "No existen soluciones reales.");
        }
    }
}