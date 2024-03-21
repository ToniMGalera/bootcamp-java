package Trabajo_Toni_Sebas_Santos;

public class Productos {
	 private String nombre;
	    private double precio;

	    public void EjercicioAparteAñadirDespués(String nombre, double precio) {
	        this.nombre = nombre;
	        this.precio = precio;
	    }

	    // Getters y setters (puedes agregar más atributos según sea necesario)
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }
	}

	import java.util.ArrayList;
	import java.util.List;

	public class CarritoDeCompras {
	    private List<Productos> productos;

	    public CarritoDeCompras() {
	        this.productos = new ArrayList<>();
	    }

	    public void agregarProducto(Productos producto) {
	        Productos.add(producto);
	    }

	    public void mostrarProductos() {
	        System.out.println("Productos en el carrito:");
	        for (Productos producto : productos) {
	            System.out.println("Nombre: " + producto.getNombre() + ", Precio: $" + producto.getPrecio());
	        }
	    }

	    // Otros métodos según sea necesario
	}

	public class Main {
	    public static void main(String[] args) {
	        // Crear productos
	    	Productos producto1 = new Productos("Camiseta", 15.99);
	        Productos producto2 = new Productos("Pantalón", 29.99);

	        // Crear un carrito de compras
	        CarritoDeCompras carrito = new CarritoDeCompras();

	        // Agregar productos al carrito
	        carrito.agregarProducto(producto1);
	        carrito.agregarProducto(producto2);

	        // Mostrar los productos en el carrito
	        carrito.mostrarProductos();
	    }
	}

