package Proyecto.Maven.Tareas.ProyectosMaven;

	import java.awt.*;
	import javax.swing.*;
	import javax.swing.event.ChangeEvent;
	import javax.swing.event.ChangeListener;

	public class ejercicio1 extends JFrame {

		private JPanel contentPane = new JPanel();
		private JLabel campo;
		private JSlider slider;

		public ejercicio1() {

			setTitle("-- Ventana ejercicio 1 --");
			setSize(400, 300);
			setLocationRelativeTo(null); // Centrar 
			setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el programa

			//Para centrar
			contentPane.setLayout(new FlowLayout());
			setContentPane(contentPane);

			campo = new JLabel("-- ¡Holi catalunyi! --");
			contentPane.add(campo, BorderLayout.CENTER);

			//Cambio de tamaño de etiqueta
			slider = new JSlider(JSlider.HORIZONTAL, 10, 100, 20);
			slider.setMajorTickSpacing(10);


			//Cambio de tamaño de etiqueta
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int size = slider.getValue();
					campo.setFont(new Font("Arial", Font.PLAIN, size));
				}
			});

			contentPane.add(slider);

			setVisible(true);

		}

		public static void main(String[] args) {
			ejercicio1 ventana = new ejercicio1();
		}
	}