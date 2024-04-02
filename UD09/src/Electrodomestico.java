import javax.swing.JOptionPane;

public class Electrodomestico {
    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    protected static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};
    protected static final char[] LETRAS_CONSUMO_ENERGETICO = {'A', 'B', 'C', 'D', 'E', 'F'};
    protected static final double PRECIO_POR_LETRA = 100;
    protected static final double[] PRECIOS_POR_TAMANO = {10, 50, 80, 100};

    public Electrodomestico() {
        this.color = "blanco";
        this.consumoEnergetico = 'F';
        this.precioBase = 100;
        this.peso = 5;
    }

    public Electrodomestico(double precioBase, double peso) {
        this();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this(precioBase, peso);
        comprobarColor(color);
        comprobarConsumoEnergetico(consumoEnergetico);
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    protected void comprobarConsumoEnergetico(char letra) {
        for (char c : LETRAS_CONSUMO_ENERGETICO) {
            if (Character.toUpperCase(letra) == c) {
                this.consumoEnergetico = letra;
                return;
            }
        }
        this.consumoEnergetico = 'F';
    }

    protected void comprobarColor(String color) {
        for (String c : COLORES_DISPONIBLES) {
            if (color.equalsIgnoreCase(c)) {
                this.color = color.toLowerCase();
                return;
            }
        }
        this.color = "blanco";
    }

    public double precioFinal() {
        double precioFinal = this.precioBase;

        switch (this.consumoEnergetico) {
            case 'A':
                precioFinal += PRECIO_POR_LETRA;
                break;
            case 'B':
                precioFinal += PRECIO_POR_LETRA - 20;
                break;
            case 'C':
                precioFinal += PRECIO_POR_LETRA - 40;
                break;
            case 'D':
                precioFinal += PRECIO_POR_LETRA - 50;
                break;
            case 'E':
                precioFinal += PRECIO_POR_LETRA - 70;
                break;
            case 'F':
                precioFinal += PRECIO_POR_LETRA - 90;
                break;
        }

        if (this.peso >= 0 && this.peso < 20) {
            precioFinal += PRECIOS_POR_TAMANO[0];
        } else if (this.peso >= 20 && this.peso < 50) {
            precioFinal += PRECIOS_POR_TAMANO[1];
        } else if (this.peso >= 50 && this.peso < 80) {
            precioFinal += PRECIOS_POR_TAMANO[2];
        } else if (this.peso >= 80) {
            precioFinal += PRECIOS_POR_TAMANO[3];
        }

        return precioFinal;
    }
}
