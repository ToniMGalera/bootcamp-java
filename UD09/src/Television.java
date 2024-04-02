import javax.swing.JOptionPane;

public class Television extends Electrodomestico {
    private static final double RESOLUCION_POR_DEFECTO = 20;
    private static final double INCREMENTO_PRECIO_POR_RESOLUCION_MAYOR_40 = 0.3;
    private static final double PRECIO_TDT_INCORPORADO = 50;

    private double resolucion;
    private boolean sintonizadorTDT;

    public Television() {
        super();
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.sintonizadorTDT = false;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.sintonizadorTDT = false;
    }

    public Television(double resolucion, boolean sintonizadorTDT, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public double getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (resolucion > 40) {
            precioFinal *= (1 + INCREMENTO_PRECIO_POR_RESOLUCION_MAYOR_40);
        }

        if (sintonizadorTDT) {
            precioFinal += PRECIO_TDT_INCORPORADO;
        }

        return precioFinal;
    }
}
