import javax.swing.JOptionPane;
public class Tasca02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantRandoms=Integer.parseInt(JOptionPane.
				showInputDialog("Introduce la cantidad de randoms: "));
		int r1, r2;
		while (cantRandoms>0) {
			r1=Integer.parseInt(JOptionPane.
					showInputDialog("Introduce el primer rango: "));
			r2=Integer.parseInt(JOptionPane.
					showInputDialog("Introduce el segundo rango: "));		
			System.out.println(enteroRandom (r1, r2));
			cantRandoms--;
		}
	}
	public static int enteroRandom (int rango1, int rango2) {
		int resultado= (int) (Math.random() * rango2) + rango1;;
		
		return resultado;
	
	
	}
}
