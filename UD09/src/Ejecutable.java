import javax.swing.JOptionPane;

public class Ejecutable {
    public static void main(String[] args) {
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        electrodomesticos[0] = new Lavadora(150, 30);
        electrodomesticos[1] = new Television(50, 15);
        electrodomesticos[2] = new Electrodomestico(200, "negro", 'A', 25);
        electrodomesticos[3] = new Lavadora(120, 35);
        electrodomesticos[4] = new Television(60, 42);
        electrodomesticos[5] = new Electrodomestico(250, "rojo", 'E', 70);
        electrodomesticos[6] = new Lavadora(180, 50);
        electrodomesticos[7] = new Television(70, true, 55, "azul", 'D', 90);
        electrodomesticos[8] = new Electrodomestico(300, "gris", 'B', 80);
        electrodomesticos[9] = new Lavadora(200, 75);

        double precioElectrodomesticos = 0;
        double precioLavadoras = 0;
        double precioTelevisiones = 0;

        StringBuilder electrodomesticosInfo = new StringBuilder();
        StringBuilder lavadorasInfo = new StringBuilder();
        StringBuilder televisionesInfo = new StringBuilder();

        for (Electrodomestico electrodomestico : electrodomesticos) {
            double precioFinal = electrodomestico.precioFinal();
            precioElectrodomesticos += precioFinal;

            if (electrodomestico instanceof Lavadora) {
                precioLavadoras += precioFinal;
                lavadorasInfo.append("- Precio de la lavadora: ").append(precioFinal).append(" euros\n");
            } else if (electrodomestico instanceof Television) {
                precioTelevisiones += precioFinal;
                televisionesInfo.append("- Precio de la televisión: ").append(precioFinal).append(" euros\n");
            }

            electrodomesticosInfo.append("- Precio del electrodoméstico: ").append(precioFinal).append(" euros\n");
        }

        JOptionPane.showMessageDialog(null, "Precios totales:\n" +
                "- Electrodomésticos: " + precioElectrodomesticos + " euros\n" +
                "- Lavadoras: " + precioLavadoras + " euros\n" +
                "- Televisores: " + precioTelevisiones + " euros\n\n" +
                "Detalles por tipo:\n" +
                "Electrodomésticos:\n" + electrodomesticosInfo.toString() + "\n" +
                "Lavadoras:\n" + lavadorasInfo.toString() + "\n" +
                "Televisores:\n" + televisionesInfo.toString());
    }
}
