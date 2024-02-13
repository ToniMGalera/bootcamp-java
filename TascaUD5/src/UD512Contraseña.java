import javax.swing.JOptionPane;

public class UD512Contraseña {

	public static void main(String[] args) {
		String pass= "Messi10", passUsuario = "", mensaje= "";
		int cont=0;
		
		while (cont <3) {
			
			passUsuario=JOptionPane.
					showInputDialog("Introduce contraseña: ");
			if (pass.equals (passUsuario)) {
				mensaje = "Enhorabuena";
				break;
			} else {
					mensaje = "Contraseña incorrecta";
					System.out.println(mensaje);
					cont++;
			}
			if (cont == 3) {
				mensaje = "Te quedaste sin intentos";			
				}
		}
		
		
		System.out.println(mensaje);
	}
}