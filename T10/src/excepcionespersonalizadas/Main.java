package excepcionespersonalizadas;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	public class Main {
	    public static void main(String[] args) {
	        mostrarMensaje();
	    }

	    private static void mostrarMensaje() {
	        try {
	            JOptionPane.showMessageDialog(null, "Mensaje mostrado por ventana.");
	            throw new CustomException("Se generó una excepción personalizada.");
	        } catch (CustomException e) {
	            mostrarError("Se capturó la excepción: " + e.getMensaje());
	        }
	    }

	    private static void mostrarError(String mensaje) {
	        JOptionPane.showMessageDialog(null, mensaje, "Excepción Personalizada", JOptionPane.ERROR_MESSAGE);
	    }
	}