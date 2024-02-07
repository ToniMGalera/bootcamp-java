import javax.swing.JOptionPane;

public class PruebaUD5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double IVA=0.21;
		String texto_num=JOptionPane.showInputDialog("Introduce precio del producto");
		
		int precio=Integer.parseInt(texto_num);
		JOptionPane.showMessageDialog(null, "El producto tiene un precio de "+45647+" y su precio final es de "+(precio+(precio*IVA)));
	}

}
