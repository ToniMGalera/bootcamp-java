package Tasca05;
import javax.swing.JOptionPane;
import java.util.Random;

public class Profesor {
    private String nombre;
    private int edad;
    private String sexo;
    private String materia;

    public Profesor(String nombre, int edad, String sexo, String materia) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.materia = materia;
    }

    public boolean estaDisponible() {
        return Math.random() >= 0.2;
    }

    public String getMateria() {
        return materia;
    }
}