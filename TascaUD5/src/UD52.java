import javax.swing.JOptionPane;
public class UD52 {

	public static void main(String[] args) {
		String nombre=JOptionPane.showInputDialog("Introduce tu nombre");
		
		JOptionPane.showMessageDialog(null, "Hola, tu nombre es " +nombre);
		
//Ahora muestralo con JOPtionPane
		JOptionPane.showMessageDialog(null, "Bienvenido " + nombre);

	}
}
