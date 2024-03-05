import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Tasca02Supermercado {
	public static void main(String[] args) {
        ArrayList<Double> carrito = new ArrayList<>();

        // Obtener la cantidad de artículos a comprar
        int numArticulos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de artículos a comprar:"));

        // Solicitar y almacenar la cantidad de cada artículo en el carrito
        for (int i = 0; i < numArticulos; i++) {
            double cantidadArticulo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad del artículo " + (i + 1) + ":"));
            carrito.add(cantidadArticulo);
        }

        // Calcular el precio total bruto
        double precioTotalBruto = 0.0;
        for (double cantidad : carrito) {
            precioTotalBruto += cantidad;
        }

        // Obtener el tipo de IVA aplicado
        int tipoIVA = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de IVA (1: 21%, 2: 4%):"));

        // Calcular el IVA aplicado
        double iva;
        if (tipoIVA == 1) {
            iva = precioTotalBruto * 0.21;
        } else {
            iva = precioTotalBruto * 0.04;
        }

        // Calcular el precio total con IVA
        double precioTotalConIVA = precioTotalBruto + iva;

        // Obtener la cantidad pagada
        double cantidadPagada = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad pagada:"));

        // Calcular el cambio a devolver
        double cambio = cantidadPagada - precioTotalConIVA;

        // Mostrar la información
        JOptionPane.showMessageDialog(null, "Resumen de la compra:\n" +
                "IVA aplicado: " + (tipoIVA == 1 ? "21%" : "4%") + "\n" +
                "Precio total bruto: " + precioTotalBruto + "\n" +
                "Precio total con IVA: " + precioTotalConIVA + "\n" +
                "Número de artículos comprados: " + numArticulos + "\n" +
                "Cantidad pagada: " + cantidadPagada + "\n" +
                "Cambio a devolver: " + cambio);
    }
}
