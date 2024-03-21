package Trabajo_Toni_Sebas_Santos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CarritoDeCompras {
	private List<Producto> productos;

    public CarritoDeCompras() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        System.out.println("Productos en el carrito:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". Nombre: " + producto.getNombre() + ", Precio: $" + producto.getPrecio());
        }
    }

    public void modificarProducto(int indice, Producto nuevoProducto) {
        if (indice < 0 || indice >= productos.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        productos.set(indice, nuevoProducto);
        System.out.println("Producto modificado correctamente.");
    }

    public void venderProductos() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        System.out.println("El total de la venta es: $" + total);
        productos.clear();
        System.out.println("Venta realizada correctamente. El carrito está vacío ahora.");
    }

    public static void main(String[] args) {
        CarritoDeCompras carrito = new CarritoDeCompras();
        Scanner scanner = new Scanner(System.in);

        // Agregar productos
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú del Carrito de Compras ---");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Modificar producto");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    carrito.mostrarProductos();
                    break;
                case 2:
                    System.out.print("Ingrese el índice del producto que desea modificar: ");
                    int indice = scanner.nextInt() - 1; // Ajuste para usar índices de 1 a n
                    scanner.nextLine(); // Limpiar el buffer
                    if (indice >= 0 && indice < carrito.productos.size()) {
                        System.out.print("Ingrese el nuevo nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el nuevo precio del producto: ");
                        double precio = scanner.nextDouble();
                        carrito.modificarProducto(indice, new Producto());
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                    carrito.venderProductos();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
            }
        }

        scanner.close();
    }
    public Venta venderProductos1() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        System.out.println("El total de la venta es: $" + total);
        Venta venta = new Venta(new ArrayList<>(productos), total);
        productos.clear();
        System.out.println("Venta realizada correctamente. El carrito está vacío ahora.");
        return venta;
    }
}
