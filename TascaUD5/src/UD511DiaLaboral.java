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
            System.out.println("Es un día laboral.");
            break;
        case "sábado":
        case "sabado":  // Por si se escribe con tilde o no
        case "domingo":
            System.out.println("No es un día laboral.");
            break;
		}
		scanner.close();
	}

}
