import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class pruebatienda {
    public static void main(String[] args) {
        pruebatienda tienda = new pruebatienda();
        tienda.iniciar();
    }

    private final String ADMIN_PASSWORD = "CajaR";
    private Map<String, Producto> stockProductos = new HashMap<>();
    private Map<String, Integer> carrito = new HashMap<>();
    private double ivaPorDefecto = 0.21;

    public void iniciar() {
        inicializarBaseDeDatos();

        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "---- Menú Principal ----\n" +
                            "1. Ver lista de productos (con IVA)\n" +
                            "2. Comprar producto\n" +
                            "3. Realizar venta\n" +
                            "4. Modo Administrador\n" +
                            "5. Salir\n" +
                            "Seleccione una opción:");

            if (opcion == null) {
                return;
            }

            switch (opcion) {
                case "1":
                    listarProductos();
                    break;
                case "2":
                    comprarProducto();
                    break;
                case "3":
                    realizarVenta();
                    break;
                case "4":
                    modoAdmin();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }

            verificarStockBajo();
        }
    }

    private void inicializarBaseDeDatos() {
        agregarProducto("Manzanas", 20, 2.5);
        agregarProducto("Plátanos", 15, 1.8);
        agregarProducto("Leche", 30, 1.2);
        agregarProducto("Pan", 25, 0.9);
        agregarProducto("Huevos", 40, 3.0);
        agregarProducto("Arroz", 50, 1.5);
        agregarProducto("Aceite", 35, 2.8);
        agregarProducto("Azúcar", 45, 1.0);
        agregarProducto("Sal", 40, 0.8);
        agregarProducto("Café", 20, 4.0);
    }

    private void comprarProducto() {
        String nombreProducto = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto que desea comprar:");
        if (nombreProducto == null) {
            return;
        }

        if (!stockProductos.containsKey(nombreProducto)) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            return;
        }

        Producto producto = stockProductos.get(nombreProducto);
        int cantidadDisponible = producto.getCantidadDisponible();

        String cantidadCompraStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad que desea comprar:");
        if (cantidadCompraStr == null) {
            return;
        }
        int cantidadCompra;
        try {
            cantidadCompra = Integer.parseInt(cantidadCompraStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            return;
        }

        if (cantidadCompra <= 0 || cantidadCompra > cantidadDisponible) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida o insuficiente stock.");
            return;
        }

        carrito.put(nombreProducto, carrito.getOrDefault(nombreProducto, 0) + cantidadCompra);
        JOptionPane.showMessageDialog(null, "Producto agregado al carrito.");
    }

    private void realizarVenta() {
        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El carrito está vacío. No se puede realizar la venta.");
            return;
        }

        double totalVenta = 0.0;
        for (Map.Entry<String, Integer> entry : carrito.entrySet()) {
            String nombreProducto = entry.getKey();
            int cantidadCompra = entry.getValue();
            Producto producto = stockProductos.get(nombreProducto);
            double precio = producto.getPrecio();
            totalVenta += precio * cantidadCompra;
            producto.actualizarStock(-cantidadCompra);
        }

        JOptionPane.showMessageDialog(null, "Total a pagar: " + totalVenta);

        String cantidadPagadaStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad pagada por el cliente:");
        if (cantidadPagadaStr == null) {
            return;
        }
        double cantidadPagada;
        try {
            cantidadPagada = Double.parseDouble(cantidadPagadaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            return;
        }

        double cambio = cantidadPagada - totalVenta;
        if (cambio >= 0) {
            JOptionPane.showMessageDialog(null, "Cambio a devolver: " + cambio);
            carrito.clear();
        } else {
            JOptionPane.showMessageDialog(null, "Cantidad insuficiente. Venta cancelada.");
        }
    }

    private void modoAdmin() {
        String password = JOptionPane.showInputDialog(null, "Ingrese la contraseña de administrador:");
        if (password == null || !password.equals(ADMIN_PASSWORD)) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta. No tiene acceso al modo administrador.");
            return;
        }

        Administrador admin = new Administrador();
        admin.iniciar();
    }

    private void verificarStockBajo() {
        for (Producto producto : stockProductos.values()) {
            if (producto.getCantidadDisponible() <= 3) {
                JOptionPane.showMessageDialog(null, "¡Stock bajo de " + producto.getNombre() + "! La cantidad es " + producto.getCantidadDisponible() + ".");
            }
        }
    }

    private void listarProductos() {
        StringBuilder listaProductos = new StringBuilder();
        listaProductos.append("--- Productos Disponibles ---\n");
        for (Producto producto : stockProductos.values()) {
            double precioConIVA = producto.getPrecioConIVA();
            listaProductos.append(producto.getNombre()).append(" - Cantidad: ").append(producto.getCantidadDisponible())
                    .append(", Precio con IVA: €").append(String.format("%.2f", precioConIVA)).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaProductos.toString());
    }

    private void agregarProducto(String nombre, int cantidad, double precio) {
        Producto producto = new Producto(nombre, cantidad, precio, ivaPorDefecto);
        stockProductos.put(nombre, producto);
    }

    private class Producto {
        private String nombre;
        private int cantidadDisponible;
        private double precio;
        private double iva;

        public Producto(String nombre, int cantidadDisponible, double precio, double iva) {
            this.nombre = nombre;
            this.cantidadDisponible = cantidadDisponible;
            this.precio = precio;
            this.iva = iva;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCantidadDisponible() {
            return cantidadDisponible;
        }

        public double getPrecio() {
            return precio;
        }

        public double getPrecioConIVA() {
            return precio * (1 + iva);
        }

        public void actualizarStock(int cantidad) {
            cantidadDisponible += cantidad;
        }
        	}
    			}
