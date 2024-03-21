
public class Persona {
	public static void main(String[] args) {
        
        Persona persona1 = new Persona();

        // Mostrar la info
        persona1.mostrarInformacion();

        
        Persona persona2 = new Persona("Anna", 19, 'M');

        // Mostrar la información de la segunda persona en la consola
        persona2.mostrarInformacion();
    }
	    // Atributos
	    private String nombre;
	    private int edad;
	    private final String DNI;
	    private char sexo;
	    private double peso;
	    private double altura;

	    // Constante para el sexo por defecto
	    private static final char SEXO_DEFECTO = 'H';

	    // Constructores
	    public Persona() {
	        this.nombre = "Antonio";
	        this.edad = 23;
	        this.DNI = generaDNI();
	        this.sexo = SEXO_DEFECTO;
	        this.peso = 90;
	        this.altura = 1.78;
	    }

	    // Constructor con nombre, edad y sexo, el resto por defecto
	    public Persona(String nombre, int edad, char sexo) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.DNI = generaDNI();
	        this.sexo = sexo;
	        this.peso = 0;
	        this.altura = 0;
	    }

	    // Constructor con todos los atributos como parámetro
	    public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.DNI = DNI;
	        this.sexo = sexo;
	        this.peso = peso;
	        this.altura = altura;
	    }

	    // Métodos privados
	    // Método para generar un DNI aleatorio
	    private String generaDNI() {
	        // Código para generar un DNI aleatorio
	        return "";
	    }

	    // Métodos públicos para acceder a los atributos (getters y setters)
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    public String getDNI() {
	        return DNI;
	    }

	    public char getSexo() {
	        return sexo;
	    }

	    public void setSexo(char sexo) {
	        this.sexo = sexo;
	    }

	    public double getPeso() {
	        return peso;
	    }

	    public void setPeso(double peso) {
	        this.peso = peso;
	    }

	    public double getAltura() {
	        return altura;
	    }

	    public void setAltura(double altura) {
	        this.altura = altura;
	    }

	    // Otros métodos públicos
	    // Método para calcular el índice de masa corporal (IMC)
	    public double calcularIMC() {
	        double imc = peso / (altura * altura);
	        return imc;
	    }

	    // Método para comprobar si la persona está en su peso ideal según el IMC
	    public String comprobarPeso() {
	        double imc = calcularIMC();
	        if (imc < 18.5) {
	            return "Bajo peso";
	        } else if (imc >= 18.5 && imc < 25) {
	            return "Peso normal";
	        } else {
	            return "Sobrepeso";
	        }
	    }

	    // Método para comprobar si la persona es mayor de edad
	    public boolean esMayorEdad() {
	        return edad >= 18;
	    }

	    // Método para mostrar información de la persona
	    public void mostrarInformacion() {
	        System.out.println("Nombre: " + nombre);
	        System.out.println("Edad: " + edad);
	        System.out.println("DNI: " + DNI);
	        System.out.println("Sexo: " + sexo);
	        System.out.println("Peso: " + peso + " kg");
	        System.out.println("Altura: " + altura + " m");
	    }
	}