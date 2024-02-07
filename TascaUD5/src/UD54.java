import java.util.Scanner;

public class UD54 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Calcula el área de un circulo");
	
		String radioString= scanner.nextLine();
		double radio=Double.parseDouble(radioString);
		
		Double area= Math.PI * Math.pow(radio, 2);
		
//		mostrar área
		System.out.println("área circulo " +radio+ "es: " +area);
		

	}

}
