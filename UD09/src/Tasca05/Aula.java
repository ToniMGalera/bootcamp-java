package Tasca05;
import javax.swing.JOptionPane;
import java.util.Random;

public class Aula {
    private int id;
    private int capacidadMaxima;
    private String materia;
    private Profesor profesor;
    private Estudiante[] estudiantes;
    private int numEstudiantes;

    public Aula(int id, int capacidadMaxima, String materia, Profesor profesor) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.materia = materia;
        this.profesor = profesor;
        this.estudiantes = new Estudiante[capacidadMaxima];
        this.numEstudiantes = 0;
    }

    public boolean puedeDarseClase() {
    	 // Verificar disponibilidad del profesor
        if (!profesor.estaDisponible()) {
            return false;
        }

        // Verificar si el profesor da la asignatura correspondiente
        if (!profesor.getMateria().equalsIgnoreCase(materia)) {
            return false;
        }

        // Verificar si hay más del 50% de estudiantes
        int numAsistentes = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null && !estudiante.haceNovillos()) {
                numAsistentes++;
            }
        }
        return numAsistentes > (capacidadMaxima / 4);
    }

    private double calcularPorcentajeAlumnos() {
        int count = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null) {
                count++;
            }
        }
        return (double) count / capacidadMaxima * 100;
    }

    public void mostrarEstadoClase() {
        if (puedeDarseClase()) {
            int aprobados = contarAprobados();
            int aprobadas = contarAprobadas();
            JOptionPane.showMessageDialog(null, "Clase disponible. Aprobados: " + aprobados + " (Hombres) y " + aprobadas + " (Mujeres)");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede dar clase en este aula en este momento.");
        }
    }

    private int contarAprobados() {
        int count = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null && estudiante.getCalificacion() >= 5 && estudiante.getSexo().equals("Hombre")) {
                count++;
            }
        }
        return count;
    }

    private int contarAprobadas() {
        int count = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null && estudiante.getCalificacion() >= 5 && estudiante.getSexo().equals("Mujer")) {
                count++;
            }
        }
        return count;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (numEstudiantes < capacidadMaxima) {
            estudiantes[numEstudiantes++] = estudiante;
        } else {
            JOptionPane.showMessageDialog(null, "El aula está llena, no se puede agregar más estudiantes.");
        }
    }
 }
