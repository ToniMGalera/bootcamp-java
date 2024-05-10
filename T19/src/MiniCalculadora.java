import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniCalculadora extends JFrame implements ActionListener {
    private JTextField operando1Field, operando2Field, resultadoField;
    private JButton sumaButton, restaButton, multiplicacionButton, divisionButton, salirButton, aboutButton;

    public MiniCalculadora() {
        // Configuración de la ventana
        setTitle("MiniCalculadora");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de componentes
        operando1Field = new JTextField(10);
        operando2Field = new JTextField(10);
        resultadoField = new JTextField(10);
        resultadoField.setEditable(false);

        sumaButton = new JButton("Suma");
        restaButton = new JButton("Resta");
        multiplicacionButton = new JButton("Multiplicación");
        divisionButton = new JButton("División");
        salirButton = new JButton("Salir");
        aboutButton = new JButton("About");

        sumaButton.addActionListener(this);
        restaButton.addActionListener(this);
        multiplicacionButton.addActionListener(this);
        divisionButton.addActionListener(this);
        salirButton.addActionListener(this);
        aboutButton.addActionListener(this);

        // Configuración del diseño
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Operando 1:"));
        panel.add(operando1Field);
        panel.add(new JLabel("Operando 2:"));
        panel.add(operando2Field);
        panel.add(new JLabel("Resultado:"));
        panel.add(resultadoField);
        panel.add(sumaButton);
        panel.add(restaButton);
        panel.add(multiplicacionButton);
        panel.add(divisionButton);
        panel.add(salirButton);
        panel.add(aboutButton);

        getContentPane().add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sumaButton) {
            calcular('+');
        } else if (e.getSource() == restaButton) {
            calcular('-');
        } else if (e.getSource() == multiplicacionButton) {
            calcular('*');
        } else if (e.getSource() == divisionButton) {
            calcular('/');
        } else if (e.getSource() == salirButton) {
            System.exit(0);
        } else if (e.getSource() == aboutButton) {
            JOptionPane.showMessageDialog(this, "MiniCalculadora\nHecho por: [Tu nombre o alias]\nVersión: 1.0", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void calcular(char operador) {
        try {
            double operando1 = Double.parseDouble(operando1Field.getText());
            double operando2 = Double.parseDouble(operando2Field.getText());
            double resultado = 0;

            switch (operador) {
                case '+':
                    resultado = operando1 + operando2;
                    break;
                case '-':
                    resultado = operando1 - operando2;
                    break;
                case '*':
                    resultado = operando1 * operando2;
                    break;
                case '/':
                    if (operando2 != 0) {
                        resultado = operando1 / operando2;
                    } else {
                        JOptionPane.showMessageDialog(this, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
            }

            resultadoField.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MiniCalculadora().setVisible(true);
            }
        });
    }
}
