package Tasca05;
import javax.swing.JOptionPane;
import java.util.Random;

public class Ejecutable {
    public static void main(String[] args) {
    	Profesor profesor = new Profesor("Benito Camela", 49, "masculino", "matemáticas");
    	Estudiante estudiante1 = new Estudiante("Arnau Montes", 24, "indefinido", 10);
    	Estudiante estudiante2 = new Estudiante("Maria", 21, "femenino", 4);
    	Estudiante estudiante3 = new Estudiante("Manolo Lama", 60, "masculino", 2);
    	Estudiante estudiante4 = new Estudiante("Josep", 18, "femenino", 9);
    	Estudiante estudiante5 = new Estudiante("Miguel", 76, "masculino", 8);

        //Crear aula
    	Aula aula = new Aula(1, 20, "matemáticas", profesor);
        aula.agregarEstudiante (estudiante1);
        aula.agregarEstudiante (estudiante2);
        aula.agregarEstudiante (estudiante3);
        aula.agregarEstudiante (estudiante4);
        aula.agregarEstudiante (estudiante5);

        //Mostrar estado de la clase
        aula.mostrarEstadoClase();
    }
}