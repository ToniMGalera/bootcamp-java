import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MiniEncuesta extends JFrame implements ActionListener {
    private JRadioButton windowsRadio, linuxRadio, macRadio;
    private JCheckBox programacionCheck, disenoCheck, administracionCheck;
    private JSlider horasSlider;
    private JButton enviarButton;

    public MiniEncuesta() {
        // Configuración de la ventana
        setTitle("Mini Encuesta");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de componentes
        windowsRadio = new JRadioButton("Windows");
        linuxRadio = new JRadioButton("Linux");
        macRadio = new JRadioButton("Mac");
        ButtonGroup sistemaOperativoGroup = new ButtonGroup();
        sistemaOperativoGroup.add(windowsRadio);
        sistemaOperativoGroup.add(linuxRadio);
        sistemaOperativoGroup.add(macRadio);

        programacionCheck = new JCheckBox("Programación");
        disenoCheck = new JCheckBox("Diseño gráfico");
        administracionCheck = new JCheckBox("Administración");

        JLabel horasLabel = new JLabel("Horas dedicadas en el ordenador:");
        horasSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        horasSlider.setMajorTickSpacing(1);
        horasSlider.setPaintTicks(true);
        horasSlider.setPaintLabels(true);

        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(this);

        // Configuración del diseño
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(new JLabel("Elije un sistema operativo:"));
        panel.add(windowsRadio);
        panel.add(linuxRadio);
        panel.add(macRadio);
        panel.add(new JLabel("Elije tu especialidad:"));
        panel.add(programacionCheck);
        panel.add(disenoCheck);
        panel.add(administracionCheck);
        panel.add(horasLabel);
        panel.add(horasSlider);
        panel.add(enviarButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enviarButton) {
            // Obtener datos seleccionados
            String sistemaOperativo = "";
            if (windowsRadio.isSelected()) {
                sistemaOperativo = "Windows";
            } else if (linuxRadio.isSelected()) {
                sistemaOperativo = "Linux";
            } else if (macRadio.isSelected()) {
                sistemaOperativo = "Mac";
            }

            StringBuilder especialidades = new StringBuilder();
            if (programacionCheck.isSelected()) {
                especialidades.append("Programación, ");
            }
            if (disenoCheck.isSelected()) {
                especialidades.append("Diseño gráfico, ");
            }
            if (administracionCheck.isSelected()) {
                especialidades.append("Administración, ");
            }

            int horas = horasSlider.getValue();

            // Mostrar datos por pantalla
            JOptionPane.showMessageDialog(this, "Datos introducidos:\n\n" +
                    "Sistema operativo: " + sistemaOperativo + "\n" +
                    "Especialidades: " + (especialidades.length() > 0 ? especialidades.substring(0, especialidades.length() - 2) : "Ninguna") + "\n" +
                    "Horas dedicadas en el ordenador: " + horas);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MiniEncuesta().setVisible(true);
            }
        });
    }
}
