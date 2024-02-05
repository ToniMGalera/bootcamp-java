package operador;

public class CalculoIva {

	public static void main(String[] args) {
		
		int precioProducto=300;
		
		final double IVA=0.21;
		System.out.println("Información de producto\nEl precio del producto es"+precioProducto+" \nEl precio del producto incluyendo IVA es "+(precioProducto+(precioProducto*IVA)) );
		
	}

}
