import java.text.SimpleDateFormat;
import java.util.Date;

public class PruebaHoraSwitch {

	public static void main(String[] args) {
		Date fechaActual= new Date ();
		SimpleDateFormat formatoHora = new SimpleDateFormat("H");
		int hora = Integer.parseInt(formatoHora.format(fechaActual));
		String saludo;
	switch (hora) {
	case 0:
	case 1:
	case 2:
	case 3:
	case 4:
	case 5:
		saludo="Buenas noches";
		break;
	case 6:
	case 7:
	case 8:
	case 9:
	case 10:
	case 11:
		saludo ="Buenos dias";
		break;
	case 12:
	case 13:
	case 14:
	case 15:
	case 16:
	case 17:
		saludo="Buenas tardes";
		
		break;
	default:
		saludo="Buenas noches";
		
	}
		
	System.out.println(saludo);

	}

}
