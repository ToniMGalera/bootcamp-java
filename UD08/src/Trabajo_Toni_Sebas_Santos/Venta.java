package Trabajo_Toni_Sebas_Santos;
import java.util.ArrayList;
import java.util.List;
public class Venta {
	 private List<Producto> productosVendidos;
	    private double totalVenta;

	    public Venta(List<Producto> productosVendidos, double totalVenta) {
	        this.productosVendidos = productosVendidos;
	        this.totalVenta = totalVenta;
	    }

	    public void mostrarDetallesVenta() {
	        System.out.println("Detalles de la venta:");
	        for (int i = 0; i < productosVendidos.size(); i++) {
	            Producto producto = productosVendidos.get(i);
	            System.out.println((i + 1) + ". Nombre: " + producto.getNombre() + ", Precio: $" + producto.getPrecio());
	        }
	        System.out.println("Total de la venta: $" + totalVenta);
	    }
}
