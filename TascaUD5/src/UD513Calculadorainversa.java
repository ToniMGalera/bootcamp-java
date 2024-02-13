import javax.swing.JOptionPane;
	
public class UD513Calculadorainversa {
	    public static void main(String[] args) {
	        // Solicitar operandos y operador al usuario
	        int operando1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer operando (entero):"));
	        int operando2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo operando (entero):"));
	        String operador = JOptionPane.showInputDialog("Introduce el operador (+, -, *, /, ^, %):");

	        // Realizar la operación correspondiente
	        double resultado = calcularResultado(operando1, operando2, operador);

	        // Mostrar el resultado en un cuadro de diálogo
	        JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
	    }

	    // Método para realizar la operación correspondiente
	    private static double calcularResultado(int operando1, int operando2, String operador) {
	        double resultado = 0;

	        switch (operador) {
	            case "+":
	                resultado = operando1 + operando2;
	                break;
	            case "-":
	                resultado = operando1 - operando2;
	                break;
	            case "*":
	                resultado = operando1 * operando2;
	                break;
	            case "/":
	                resultado = (double) operando1 / operando2;
	                break;
	            case "^":
	                resultado = Math.pow(operando1, operando2);
	                break;
	            case "%":
	                resultado = operando1 % operando2;
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Operador no válido.");
	        }

	        return resultado;
	    }
	}