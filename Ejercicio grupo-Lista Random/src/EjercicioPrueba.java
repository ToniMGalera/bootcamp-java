import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EjercicioPrueba {
	 public static void main(String[] args) {
	        HashMap<String, Integer> estudiantesTechTalent = new HashMap<>();
	        estudiantesTechTalent.put("Laia", 23);
	        estudiantesTechTalent.put("Aurora", 30);
	        estudiantesTechTalent.put("Alexandre", 21);
	        estudiantesTechTalent.put("Jose", 26);
	        estudiantesTechTalent.put("Santos", 24);
	        estudiantesTechTalent.put("Manel", 26);
	        estudiantesTechTalent.put("Alejandro", 20);
	        estudiantesTechTalent.put("Isabel", 22);
	        estudiantesTechTalent.put("Toni", 23);
	        estudiantesTechTalent.put("Diego", 22);
	        estudiantesTechTalent.put("Sebas", 29);
	        estudiantesTechTalent.put("Abdel", 21);
	        estudiantesTechTalent.put("Joel", 19);
	        estudiantesTechTalent.put("Jessica", 22);
	        estudiantesTechTalent.put("Ana Maria", 29);

	        TreeMap<String, Integer> estudiantesOrdenados = new TreeMap<>(estudiantesTechTalent);
	        HashMap<String, Integer> grupo1 = new HashMap<>();
	        HashMap<String, Integer> grupo2 = new HashMap<>();
	        HashMap<String, Integer> grupo3 = new HashMap<>();
	        HashMap<String, Integer> grupo4 = new HashMap<>();
	        HashMap<String, Integer> grupo5 = new HashMap<>();

	        generarGrupos(estudiantesOrdenados, grupo1, grupo2, grupo3, grupo4, grupo5);
	    }

	    public static void generarGrupos(TreeMap<String, Integer> listaAlumnos, HashMap<String, Integer> grupo1,
	            HashMap<String, Integer> grupo2, HashMap<String, Integer> grupo3, HashMap<String, Integer> grupo4,
	            HashMap<String, Integer> grupo5) {

	        int grupo = 0;

	        for (Map.Entry<String, Integer> entry : listaAlumnos.entrySet()) {
	            String alumno = entry.getKey();
	            int edad = entry.getValue();

	            // Determinar el grupo actual
	            HashMap<String, Integer> grupoActual = switch (grupo) {
	                case 0 -> grupo1;
	                case 1 -> grupo2;
	                case 2 -> grupo3;
	                case 3 -> grupo4;
	                case 4 -> grupo5;
	                default -> throw new IllegalStateException("Unexpected value: " + grupo);
	            };

	            // Verificar si el grupo actual ya tiene 3 estudiantes
	            if (grupoActual.size() >= 3) {
	                grupo++; // Cambiar al siguiente grupo si el actual está lleno
	            }

	            // Agregar al grupo actual
	            grupoActual.put(alumno, edad);
	        }

	        // Imprimir los grupos ordenados alfabéticamente
	        System.out.println("Grupo1:\n " + grupo1.toString());
	        System.out.println("Grupo2:\n " + grupo2.toString());
	        System.out.println("Grupo3:\n " + grupo3.toString());
	        System.out.println("Grupo4:\n " + grupo4.toString());
	        System.out.println("Grupo5:\n " + grupo5.toString());
	    }
}
