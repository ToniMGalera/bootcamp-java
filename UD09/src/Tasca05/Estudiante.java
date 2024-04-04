package Tasca05;
import javax.swing.JOptionPane;
import java.util.Random;

public class Estudiante {
	    private String nombre;
	    private int edad;
	    private String sexo;
	    private int calificacion;

	    // Constructor
	    public Estudiante(String nombre, int edad, String sexo, int calificacion) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.sexo = sexo;
	        this.calificacion = calificacion;
	    }

	    // Métodos getter
	    public int getCalificacion() {
	        return calificacion;
	    }
	    public boolean haceNovillos() {
	        Random random = new Random();
	        return random.nextDouble() < 0.5;
	    }

	    public String getSexo() {
	        return sexo;
	    }
	}