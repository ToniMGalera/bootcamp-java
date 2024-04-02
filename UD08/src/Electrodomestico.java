
public class Electrodomestico {
	
	 public void mostrarInformacion() {
	        System.out.println("Precio base: " + precioBase + " €");
	        System.out.println("Color: " + color);
	        System.out.println("Consumo energético: " + consumoEnergetico);
	        System.out.println("Peso: " + peso + " kg");
	    }

	    
	    public static void main(String[] args) {
	        
	        Electrodomestico electrodomestico1 = new Electrodomestico();

	        //info del primer electrodoméstico
	        System.out.println("Electrodoméstico 1:");
	        electrodomestico1.mostrarInformacion();
	        System.out.println(); // Salto de línea para separar la información

	        //precio y peso
	        Electrodomestico electrodomestico2 = new Electrodomestico(150, 8);

	        // info del segundo electrodoméstico
	        System.out.println("Electrodoméstico 2:");
	        electrodomestico2.mostrarInformacion();
	        System.out.println();

	        // electrodoméstico con todos los atributos
	        Electrodomestico electrodomestico3 = new Electrodomestico(200, "azul", 'A', 10);

	        //información del tercer electrodoméstico
	        System.out.println("Electrodoméstico 3:");
	        electrodomestico3.mostrarInformacion();
	    }
	// Atributos
    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    // Constantes
    protected static final String COLOR_DEFECTO = "blanco";
    protected static final char CONSUMO_ENERGETICO_DEFECTO = 'F';
    protected static final double PRECIO_BASE_DEFECTO = 100;
    protected static final double PESO_DEFECTO = 5;

    // Colores disponibles
    protected static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};

    // Constructores
    // Constructor por defecto
    public Electrodomestico() {
        this.precioBase = PRECIO_BASE_DEFECTO;
        this.color = COLOR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
        this.peso = PESO_DEFECTO;
    }

    // Constructor con precio y peso, el resto por defecto
    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.color = COLOR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
        this.peso = peso;
    }

    // Constructor con todos los atributos
    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        comprobarColor(color.toLowerCase());
        comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    // Métodos privados
    private void comprobarColor(String color) {
        for (String colorDisponible : COLORES_DISPONIBLES) {
            if (color.equals(colorDisponible)) {
                this.color = color;
                return;
            }
        }
        // Si el color no es válido, se establece como blanco por defecto
        this.color = COLOR_DEFECTO;
    }

    // Método para comprobar si el consumo energético es válido
    private void comprobarConsumoEnergetico(char consumo) {
        if (consumo >= 'A' && consumo <= 'F') {
            this.consumoEnergetico = consumo;
        } else {
            this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
        }
    }

    // Getters y setters
    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        comprobarColor(color.toLowerCase()); // Convertir el color a minúsculas y comprobar
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        comprobarConsumoEnergetico(consumoEnergetico);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
