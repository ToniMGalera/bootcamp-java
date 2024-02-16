
public class ExtraPalindromo {

	public static void main(String[] args) {
		// Ejercicio: escribe un programa que devuelva
				// si un String es palíndromo Ejemplo:"sometemos" o "aibofobia"
		String palin= "séverlasalrevés";
		String palinReverse="";
	int indiceRecorre=palin.length()-1;//8
		System.out.println(indiceRecorre);
		char caracter=palin.charAt (indiceRecorre);//a
		System.out.println(caracter);
		for (int i= indiceRecorre; i>=0; i--) {
			palinReverse=palinReverse.concat(palin.valueOf(caracter));
			
			indiceRecorre--;
			if (indiceRecorre >=0) {
				caracter = palin.charAt(indiceRecorre);
				
			}
		}
		
		
//		System.out.println(palinReverse);
		imprimePalindromo(palin, palinReverse);
	}
		
		public static void imprimePalindromo (String palindrom, String palindromInverso) {
		if (palindrom.equals(palindromInverso)) {
			System.out.println("Es un palindromo");
		}else{
			System.out.println("No es un palindromo");
		}
		
	}

}
