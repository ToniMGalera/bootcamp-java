import javax.swing.*;
import java.awt.*;
import java.util.Random; // Importar la clase Random
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdivinaNumero {
    private int numeroAleatorio;
    private int intentos;

    public AdivinaNumero() {
        Random random = new Random();
        numeroAleatorio = random.nextInt(500) + 1;
        intentos = 0;
    }

    public void jugar() {
        JOptionPane.showMessageDialog(null, "Bienvenido a Adivina el Número!\nEl número a adivinar está entre 1 y 500.");

        while (true) {
            String entrada = (String) JOptionPane.showInputDialog(null, "Introduce tu intento:", "Adivina el Número", JOptionPane.PLAIN_MESSAGE, null, null, null);
            try {
                int intento = Integer.parseInt(entrada);
                intentos++;

                if (intento == numeroAleatorio) {
                    JOptionPane.showMessageDialog(null, createRoundedPanel("¡Felicidades! Has adivinado el número en " + intentos + " intentos."));
                    break;
                } else if (intento < numeroAleatorio) {
                    JOptionPane.showMessageDialog(null, createRoundedPanel("El número a adivinar es mayor."));
                } else {
                    JOptionPane.showMessageDialog(null, createRoundedPanel("El número a adivinar es menor."));
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, createRoundedPanel("Error: Introduce un número válido."), "Error", JOptionPane.ERROR_MESSAGE);
                intentos++;
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, createRoundedPanel("¡Gracias por jugar!"), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }

    private JPanel createRoundedPanel(String mensaje) {
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15, 15); // Tamaño del arco de las esquinas
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // Dibuja el panel redondeado con los bordes suaves.
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // Dibuja el borde del panel.
            }
        };
        panel.setBackground(Color.WHITE);
        panel.setForeground(Color.BLACK);
        JLabel mensajeLabel = new JLabel(mensaje);
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(mensajeLabel, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        AdivinaNumero juego = new AdivinaNumero();
        juego.jugar();
    }
}

