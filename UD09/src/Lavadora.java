import javax.swing.JOptionPane;

public class Lavadora extends Electrodomestico {
    private static final double CARGA_POR_DEFECTO = 5;
    private static final double PRECIO_CARGA_MAYOR_30KG = 50;

    private double carga;

    public Lavadora() {
        super();
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double carga, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (carga > 30) {
            precioFinal += PRECIO_CARGA_MAYOR_30KG +50;
        }

        return precioFinal;
    }
}
