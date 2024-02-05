
public class Tasca45 {

	public static void main(String[] args) {
		// Declarar cuatro variables enteras A, B, C y D y asignarles valores
        int A = 10;
        int B = 20;
        int C = 30;
        int D = 40;

        // Realizar el intercambio de valores
        int temp = B;  // Guardar el valor de B temporalmente
        B = C;         // B toma el valor de C
        C = A;         // C toma el valor de A
        A = D;         // A toma el valor de D
        D = temp;      // D toma el valor original de B (almacenado en temp)

        // Mostrar los valores después del intercambio
        System.out.println("Valor de A después del intercambio: " + A);
        System.out.println("Valor de B después del intercambio: " + B);
        System.out.println("Valor de C después del intercambio: " + C);
        System.out.println("Valor de D después del intercambio: " + D);// TODO Auto-generated method stub

	}

}
