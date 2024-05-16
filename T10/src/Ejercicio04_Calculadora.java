import javax.swing.JOptionPane;

public class Ejercicio04_Calculadora {

    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Suma", "Resta", "Multiplicación", "División", "Potencia", "Raíz cuadrada", "Raíz cúbica", "Salir"};
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
                    "Calculadora", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                break;
            }

            double resultado;
            try {
                double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número:"));
                double numero2 = 0;

                if (!opcionSeleccionada.equals("Raíz cuadrada") && !opcionSeleccionada.equals("Raíz cúbica")) {
                    numero2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo número:"));
                }

                switch (opcionSeleccionada) {
                    case "Suma":
                        resultado = numero1 + numero2;
                        break;
                    case "Resta":
                        resultado = numero1 - numero2;
                        break;
                    case "Multiplicación":
                        resultado = numero1 * numero2;
                        break;
                    case "División":
                        if (numero2 == 0) {
                            JOptionPane.showMessageDialog(null, "No es divisible entre 0");
                            continue;
                        }
                        resultado = numero1 / numero2;
                        break;
                    case "Potencia":
                        resultado = Math.pow(numero1, numero2);
                        break;
                    case "Raíz cuadrada":
                        if (numero1 < 0) {
                            JOptionPane.showMessageDialog(null, "No es posible calcular un negativo a una raíz cuadrad, espabila.");
                            continue;
                        }
                        resultado = Math.sqrt(numero1);
                        break;
                    case "Raíz cúbica":
                        resultado = Math.cbrt(numero1);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "NO se puede");
                        continue;
                }

                JOptionPane.showMessageDialog(null, "Resultado: " + resultado);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Pon número válidos.");
            }
        }
    }
}
