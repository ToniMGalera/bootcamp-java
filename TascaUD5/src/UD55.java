
public class UD55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner (System.in);
		System.out.println("Ingresar un número: ");
		
	int numero=scanner.NextInt();
	if (numero % 2 == 0) {
		
		System.out.println("El número " +numero+ " es divisible de 2");
		
	} else {
		
		System.out.println("El número " + numero + " no es divisible entre 2");
	}
	}

}
