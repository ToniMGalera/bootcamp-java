package Tasca06;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class Espectador {
    private String nombre;
    private int edad;
    private double dinero;

    // Constructor
    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getDinero() {
        return dinero;
    }
}