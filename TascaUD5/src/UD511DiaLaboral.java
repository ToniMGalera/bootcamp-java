import java.util.Scanner;

public class UD511DiaLaboral {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Indica día de la semana: ");
		String diaSemana=scanner.next().toLowerCase();
		switch (diaSemana) {
		case "lunes":
        case "martes":
        case "miércoles":
        case "miercoles":  // Por si se escribe con tilde o no
        case "jueves":
        case "viernes":
            System.out.println("Es día laboral, trabaja.");
            break;
        case "sábado":
        case "sabado":  // Por si se escribe con tilde o no
        case "domingo":
            System.out.println("No es día laboral.");
            break;
        default:
        	System.out.println( "No hay valor o " + "no es día de la semana");
		}
		scanner.close();
	}

}
