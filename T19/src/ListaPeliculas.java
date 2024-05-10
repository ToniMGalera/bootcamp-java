import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListaPeliculas extends JFrame implements ActionListener {
    private JComboBox<String> comboBox;
    private JTextField textField;
    private JButton addButton;

    public ListaPeliculas() {
        // Configuración de la ventana
        setTitle("Lista de Películas");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de componentes
        comboBox = new JComboBox<>();
        textField = new JTextField(15);
        addButton = new JButton("Añadir");
        addButton.addActionListener(this);

        // Configuración del diseño
        setLayout(new FlowLayout());
        add(new JLabel("Película:"));
        add(textField);
        add(addButton);
        add(new JLabel("Lista de Películas:"));
        add(comboBox);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String pelicula = textField.getText();
            comboBox.addItem(pelicula);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListaPeliculas().setVisible(true);
            }
        });
    }
}

