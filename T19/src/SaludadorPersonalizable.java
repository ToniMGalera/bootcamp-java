    import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class SaludadorPersonalizable extends JFrame implements ActionListener {
	    private JTextField textField;
	    private JButton button;

	    public SaludadorPersonalizable() {
	        // Configuración de la ventana
	        setTitle("Saludador Personalizable");
	        setSize(300, 150);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Creación de componentes
	        textField = new JTextField(15);
	        button = new JButton("Saludar");
	        button.addActionListener(this);

	        // Configuración del diseño
	        setLayout(new FlowLayout());
	        add(new JLabel("Escribe tu nombre:"));
	        add(textField);
	        add(button);
	    }

	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == button) {
	            String nombre = textField.getText();
	            JOptionPane.showMessageDialog(this, "¡Hola " + nombre + "!");
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new SaludadorPersonalizable().setVisible(true);
	            }
	        });
	    }
	}
