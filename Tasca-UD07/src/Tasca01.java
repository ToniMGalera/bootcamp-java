import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tasca01 {
	public static void main(String[] args) {
        ArrayList<String> alumnos = new ArrayList<>();
        Map<String, Double> notasMedias = new HashMap<>();

        // Obtener el número de alumnos
        int numAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de alumnos:"));

        // Solicitar y almacenar información de cada alumno
        for (int i = 0; i < numAlumnos; i++) {
            String nombreAlumno = JOptionPane.showInputDialog("Ingrese el nombre del alumno " + (i + 1) + ":");
            double nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota de " + nombreAlumno + ":"));

            // Agregar el nombre del alumno a la lista
            alumnos.add(nombreAlumno);

            // Agregar la nota del alumno al diccionario
            notasMedias.put(nombreAlumno, nota);
        }

        // Calcular la nota media de todos los alumnos
        double sumaNotas = 0.0;
        for (double nota : notasMedias.values()) {
            sumaNotas += nota;
        }

        double notaMedia = sumaNotas / numAlumnos;

        // Mostrar la nota media
        JOptionPane.showMessageDialog(null, "La nota media del curso es: " + notaMedia);

        // Mostrar las notas individuales
        StringBuilder notasIndividuales = new StringBuilder("Notas individuales:\n");
        for (String alumno : alumnos) {
            double notaAlumno = notasMedias.get(alumno);
            notasIndividuales.append(alumno).append(": ").append(notaAlumno).append("\n");
        }

        JOptionPane.showMessageDialog(null, notasIndividuales.toString());
    }
}
