package Proyecto.Maven.Tareas.ProyectosMaven;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class ejercicio4 extends JFrame {
		private JTextArea textArea;
		private JLabel label;
		private JButton boton;

		public ejercicio4() {
			setTitle("Registro");
			setSize(400, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);

			label = new JLabel("Eventos ventana:");
			textArea = new JTextArea();
			textArea.setEditable(false);
			boton = new JButton("Borrar");

			JScrollPane scrollPane = new JScrollPane(textArea);

			add(label, BorderLayout.WEST);
			add(scrollPane, BorderLayout.CENTER);
			add(boton, BorderLayout.SOUTH);

			// Añadiendo manejadores de eventos para la ventana
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent e) {
					logEvent("Abierta");
				}

				@Override
				public void windowClosing(WindowEvent e) {
					logEvent("Ccerrándose");
				}

				@Override
				public void windowClosed(WindowEvent e) {
					logEvent("Cerrada");
				}

				@Override
				public void windowIconified(WindowEvent e) {
					logEvent("Minimizada");
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					logEvent("Restaurada");
				}

				@Override
				public void windowActivated(WindowEvent e) {
					logEvent("Activada");
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					logEvent("Desactivada");
				}
			});

			// Añadiendo manejadores de eventos para el ratón
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					logEvent("Ratón clicado en posición (" + e.getX() + ", " + e.getY() + ")");
				}
			});

			// Añadiendo manejadores de eventos para el teclado
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					logEvent("Tecla pulsada: " + e.getKeyChar());
				}
			});
			
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
				}
			});

			setFocusable(true);
		}

		private void logEvent(String eventDescription) {
			textArea.append(eventDescription + "\n");
		}

		public static void main(String[] args) {

			ejercicio4 window = new ejercicio4();
			window.setVisible(true);

		}
	}