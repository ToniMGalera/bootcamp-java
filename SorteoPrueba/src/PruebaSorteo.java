import java.util.Scanner;
public class PruebaSorteo {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String[] participantes=new String [3];
	
	for (int i=0; i<3; i++) {
		System.out.println("Ingresa el nombre del aprticipante "+ (i + 1) + ": ");
		participantes [i]=scanner.nextLine();
		
	}
	System.out.println("\nLista de participantes");
	for (String participante: participantes) {
		System.out.println(participante);
		
	}
	int indiceGanador =generarNumeroAleatorio (0,participantes.length-1);
	System.out.println("\n¡El ganador es: " + participantes [indiceGanador]+ "!");
	
	scanner.close();
	
	}
	public static int generarNumeroAleatorio(int minimo, int maximo) {
		return (int) (Math.random()* (maximo-minimo+1)) + minimo;
	}
	
}
