public class sumNumeros {

	public static void main (String [] args) {
		int num1=5, num2=4;
		int resultado = sumaNumeros (num1, num2);
		System.out.println("El resultado de la suma es: "+ resultado);
		
		if(positivos (resultado)) {
			System.out.println("El número es igual o mayor que 0 ");
		}else {	
			System.out.println("El resultado es negativo");
			
		
		}
		
	}
	
	public static int sumaNumeros (int num1, int num2) {
	
		int resultado = num1+num2;
		return resultado;
			
		}
		public static boolean positivos (int param1) {
			if (param1 >=0) {
				return true;
			}else{
				return false;
			}
		}
}
